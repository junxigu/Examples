package guerer.example.enumerate;

import guerer.example.util.Print;

public enum OzWitch {

	// Instances must be defined f i r s t , before methods:
	WEST("Miss Gulch, aka the Wicked Witch of the West"), NORTH(
			"Glinda, the Good Witch of the North"), EAST(
			"Wicked Witch of the East, wearer of the Ruby "
					+ "Slippers, crushed by Dorothy's house"), SOUTH(
			"Good by inference, but missing");

	private String description;

	private OzWitch(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static void main(String[] args) {
		for (OzWitch witch : OzWitch.values())
			Print.print(witch + ": " + witch.getDescription());
	}
}
