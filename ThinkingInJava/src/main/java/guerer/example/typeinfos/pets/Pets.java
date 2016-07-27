package guerer.example.typeinfos.pets;

import java.util.ArrayList;

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();

	public static Pet randompet() {
		return creator.randomPet();
	}

	public static Pet[] createArray(int size) {
		return creator.createArray(size);
	}

	public static ArrayList<Pet> arrayList(int size) {
		return creator.arrayList(size);
	}

}
