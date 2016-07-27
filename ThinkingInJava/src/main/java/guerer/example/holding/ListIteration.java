package guerer.example.holding;

import guerer.example.typeinfos.pets.Pet;
import guerer.example.typeinfos.pets.Pets;
import guerer.example.util.Print;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {

	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(8);
		ListIterator<Pet> it = pets.listIterator();

		while (it.hasNext()) {
			Print.printnb(it.next() + ", " + it.nextIndex() + ", "
					+ it.previousIndex() + "; ");
		}
		Print.print();
		
		while(it.hasPrevious()) {
			Print.printnb(it.previous() + " ");
		}
		Print.print();
		
		Print.print(pets);
		it = pets.listIterator(3);
		while(it.hasNext()){
			it.next();
			it.set(Pets.randompet());
		}
		Print.print(pets);
	}

}
