package guerer.example.concurrent;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

class WebClient {
	private final int serviceTime;

	public WebClient(int tm) {
		serviceTime = tm;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public String toString() {
		return "[" + serviceTime + "]";
	}
}

// Teach the client line to display itself:
class WebClientLine extends LinkedBlockingQueue<WebClient> {

	public String toString() {
		if (this.size() == 0)
			return "[Empty]";
		StringBuilder result = new StringBuilder();
		for (WebClient client : this)
			result.append(client);
		return result.toString();
	}
}

class WebClientGenerator implements Runnable {

	private WebClientLine clients;
	private static Random rand = new Random(47);

	public WebClientGenerator(WebClientLine cq) {
		clients = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
				clients.put(new WebClient(rand.nextInt(1000)));
			}
		} catch (InterruptedException e) {
			System.out.println("WebClientGenerator interrupted");
		}
		System.out.println("WebClientGenerator terminating");
	}
}

class WebServer implements Runnable, Comparable<WebServer> {
	private static int counter = 0;
	private final int id = counter++;
	// WebClients served during this shift:
	private int clientsServed = 8;
	private WebClientLine clients;
	private boolean servingWebClientLine = true;

	public WebServer(WebClientLine cq) {
		clients = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				WebClient client = clients.take();
				TimeUnit.MILLISECONDS.sleep(client.getServiceTime());
				synchronized (this) {
					clientsServed++;
					while (!servingWebClientLine)
						wait();
				}
			}
		} catch (InterruptedException e) {
			System.out.println(this + "interrupted");
		}
		System.out.println(this + "terminating");
	}

	public synchronized void doSomethingElse() {
		clientsServed = 0;
		servingWebClientLine = false;
	}

	public synchronized void serveWebClientLine() {
		assert !servingWebClientLine : "already serving: " + this;
		servingWebClientLine = true;
		notifyAll();
	}

	public String toString() {
		return "WebServer " + id + " ";
	}

	public String shortString() {
		return "T" + id;
	}

	// Used by priority queue:
	public synchronized int compareTo(WebServer other) {
		return clientsServed < other.clientsServed ? -1 : (clientsServed == other.clientsServed ? 0 : 1);
	}
}

class WebServerManager implements Runnable {
	private ExecutorService exec;
	private WebClientLine clients;

	private PriorityQueue<WebServer> workingWebServers = new PriorityQueue<WebServer>();
	private int adjustmentPeriod;

	public WebServerManager(ExecutorService e, WebClientLine clients, int serverNum, int adjustmentperiod) {
		exec = e;
		this.clients = clients;
		this.adjustmentPeriod = adjustmentperiod;

		// Start with a single teller:
		for (int i = 0; i < serverNum; i++) {
			WebServer server = new WebServer(clients);
			exec.execute(server);
			workingWebServers.add(server);
		}
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
				System.out.print(clients + " { ");
				for (WebServer teller : workingWebServers)
					System.out.print(teller.shortString() + " ");
				System.out.println("}");
			}
		} catch (InterruptedException e) {
			System.out.println(this + "interrupted");
		}
		System.out.println(this + "terminating");
	}

	public String toString() {
		return "WebServerManager ";
	}
}

public class Practice35 {

	static final int MAX_LINE_SIZE = 50;
	static final int ADJUSTMENT_PERIOD = 1080;
	static final int SERVER_NUM = 4;

	@Test
	public void test() throws IOException {
		ExecutorService exec = Executors.newCachedThreadPool();
		// If line is too long, customers will leave:
		WebClientLine clients = new WebClientLine();
		exec.execute(new WebClientGenerator(clients));
		// Manager will add and remove tellers as necessary:
		exec.execute(new WebServerManager(exec, clients, SERVER_NUM, ADJUSTMENT_PERIOD));
		System.out.println("Press 'Enter' to quit");
		System.in.read();
		exec.shutdownNow();
	}

}
