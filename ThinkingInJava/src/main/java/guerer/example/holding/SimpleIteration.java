package guerer.example.holding;

import guerer.example.typeinfos.pets.Pet;
import guerer.example.typeinfos.pets.Pets;
import guerer.example.util.Print;

import java.util.Iterator;
import java.util.List;

public class SimpleIteration {

	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(12);
		Iterator<Pet> it = pets.iterator();
		
		while(it.hasNext()){
			Pet p = it.next();
			Print.printnb(p.id() + ": " + p + " ");
		}
		Print.print();
		
		for(Pet p : pets){
			Print.printnb(p.id() + ": " + p + " ");
		}
		Print.print();
		
		it = pets.iterator();
		for(int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		Print.print(pets);
	}

}
