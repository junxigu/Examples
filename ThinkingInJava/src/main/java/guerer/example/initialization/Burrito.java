package guerer.example.initialization;

import guerer.example.util.Print;

public class Burrito {

	private Spiciness degree;

	public Burrito(Spiciness degree) {
		this.degree = degree;
	}

	public void describe() {
		Print.printnb("This burrito is ");
		switch (degree) {
		case NOT:
			Print.print("not spicy at all");
			break;
		case MILD:
		case MEDIUM:
			Print.print("a little spicy");
			break;
		case HOT:
		case FLAMING:
		default:
			Print.print("maybe too hot");
			break;
		}
	}

	public static void main(String[] args) {
		new Burrito(Spiciness.NOT).describe();
		new Burrito(Spiciness.MEDIUM).describe();
		new Burrito(Spiciness.HOT).describe();
	}

}
