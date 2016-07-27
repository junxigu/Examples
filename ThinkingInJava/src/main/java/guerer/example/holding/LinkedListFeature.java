package guerer.example.holding;

import guerer.example.typeinfos.pets.Hamster;
import guerer.example.typeinfos.pets.Pet;
import guerer.example.typeinfos.pets.Pets;
import guerer.example.typeinfos.pets.Rat;
import guerer.example.util.Print;

import java.util.LinkedList;

public class LinkedListFeature {

	public static void main(String[] args) {
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
		Print.print(pets);
		
		// Identical
		Print.print("pets.getFirst(): " + pets.getFirst());
		Print.print("pets.element(): " + pets.element());
		// only different in empty-list behavior
		Print.print("pets.peek(): " + pets.peek());
		
		// Identical
		Print.print("pets.removeFirst(): " + pets.removeFirst());
		Print.print("pets.remove(): " + pets.remove());
		// only different in empty-list behavior
		Print.print("pets.poll(): " + pets.poll());
		
		Print.print(pets);
		
		pets.addFirst(new Rat());
		Print.print("After addFirst(): " + pets);
		
		pets.offer(Pets.randompet());
		Print.print("After offer(): " + pets);
		
		pets.add(Pets.randompet());
		Print.print("After add(): " + pets);
		
		pets.addLast(new Hamster());
		Print.print("After addLast(): " + pets);
		
		Print.print("pets.removeLast(): " + pets.removeLast());
	}

}
