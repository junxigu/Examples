package guerer.example.typeinfos.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {

	private Random rand = new Random(47);

	public abstract List<Class<? extends Pet>> types();

	public Pet randomPet() {
		int n = rand.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public Pet[] createArray(int size) {
		Pet[] pets = new Pet[size];
		for (int i = 0; i < size; i++) {
			pets[i] = randomPet();
		}
		return pets;
	}

	public ArrayList<Pet> arrayList(int size) {
		ArrayList<Pet> list = new ArrayList<Pet>();
		Collections.addAll(list, createArray(size));
		return list;
	}
}
