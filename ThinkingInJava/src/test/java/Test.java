import java.util.concurrent.TimeUnit;

class PublicHolder {
	public Holder holder;

	public void init() {
		holder = new Holder(47);
	}
}

class Holder {
	private int n;

	public Holder(int n) {
		this.n = n;
	}

	public void assertSanity() {
		int i = n;
		if (i != n) {
			throw new AssertionError("Not Equal?");
		}
	}
}

public class Test {

	public static Holder holder = new Holder(1);

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		printHtml("png");
		printHtml("jpg");
	}

	public static void printHtml(String imgSuf) {
		System.out.println("<html><body>");
		for (int i = 1; i < 70; i++) {
			System.out.println("<div><img src=\"" + i + "." + imgSuf + "\"></div>");
		}
		System.out.println("</body></html>");
	}

}
