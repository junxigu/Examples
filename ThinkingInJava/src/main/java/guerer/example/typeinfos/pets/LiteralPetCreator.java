package guerer.example.typeinfos.pets;

import guerer.example.util.Print;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {

	public static final List<Class<? extends Pet>> allTypes = (List<Class<? extends Pet>>) Collections
			.unmodifiableList(Arrays.asList(Pet.class, Dog.class,
					Cat.class, Rodent.class, Mutt.class, Pug.class,
					EgyptianMau.class, Manx.class, Cymric.class, Rat.class,
					Mouse.class, Hamster.class));

	private static final List<Class<? extends Pet>> types = allTypes.subList(
			allTypes.indexOf(Mutt.class), allTypes.size());

	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print.print(types);
	}
}
