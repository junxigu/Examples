package guerer.example.holding;

import guerer.example.util.Print;
import guerer.example.util.Range;

import java.util.ArrayList;
import java.util.List;

public class Gerbil {

	int gerbilNumber;
	
	Gerbil(int gerbilNumber) {
		this.gerbilNumber = gerbilNumber;
	}
	
	public void hop() {
		Print.printf("Gerbil %d hopping.\n", gerbilNumber);
	}
	
	public static void main(String[] args) {
		List<Gerbil> list = new ArrayList<Gerbil>();
		for(int i : Range.range(5)) {
			list.add(new Gerbil(i));
			
			list.get(i).hop();
		}
	}
}
