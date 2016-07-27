package guerer.example.generics;


public class Wildcards {
	// Raw argument:
	static void rawArgs(Holder holder, Object arg) {
		holder.set(arg); // update after SE5
		holder.set(new Wildcards()); // Same warning
		// Can't do this ; don't have any 'T':

		// T t = holder.get();
		// OK, but type information has been lost:

		Object obj = holder.get();
	}

	// Similar to rawArgs(), but error s instead of warnings:
	static void unboundedArg(Holder<?> holder, Object arg) {
		// holder.set(arg); // Error :
		// set(capture of ?) in Holder<capture of ?>
		// cannot be applied to (Object)
		// holder.set(new Wildcards()); // Same error
		// Can't do this ; don't have any 'T':

		// T t = holder.get();
		// OK, but type information has been lost:

		Object obj = holder.get();
	}

	static <T> T exactl(Holder<T> holder) {
		T t = holder.get();
		return t;
	}

	static <T> T exact2(Holder<T> holder, T arg) {
		holder.set(arg);
		T t = holder.get();
		return t;
	}

	static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
		// holder.set(arg); // Error:
		// set(capture of ? extends T) i n
		// Holder<capture of ? extends T>
		// cannot be applied t o (T)
		T t = holder.get();
		return t;
	}

	static <T> void wildSupertype(Holder<? super T> holder, T arg) {
		holder.set(arg);
		// T t = holder.get(); // Error:
		// Incompatible types: found Object, required T
		// OK, but type information has been l o s t :
		Object obj = holder.get();
	}

	public static void main(String[] args) {
		Holder raw = new Holder<Long>();
		// Or:
		raw = new Holder();
		Holder<Long> qualified = new Holder<Long>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<Long>();
		Long lng = 1L;

		rawArgs(raw, lng);
		rawArgs(qualified, lng);
		rawArgs(unbounded, lng);
		rawArgs(bounded, lng);

		unboundedArg(raw, lng);
		unboundedArg(qualified, lng);
		unboundedArg(unbounded, lng);
		unboundedArg(bounded, lng);

		Object rl = exactl(raw);
		Long r2 = exactl(qualified);
		Object r3 = exactl(unbounded); // Must return Object
		Long r4 = exactl(bounded);

		Long r5 = exact2(raw, lng);
		Long r6 = exact2(qualified, lng);
		// Long r7 = exact2(unbounded, lng); // Error:
		// exactZ(Holder<T>,T) cannot be applied t o
		// (Holder<capture of ?>,Long)
		// Long r8 = exact2(bounded, lng); // Error:
		// exact2(Holder<T>,T) cannot be applied
		// t o (Holder<capture of ? extends Long>,Long)

		Long r9 = wildSubtype(raw, lng);
		Long r10 = wildSubtype(qualified, lng);
		// OK, but can only return Object:
//		Object r11 = wildSubtype(unbounded, lng);
		Long rl2 = wildSubtype(bounded, lng);
		wildSupertype(raw, lng); // Warnings:
		// Unchecked conversion from Holder
		// to Holder<? super Long>
		// Unchecked method invocation:
		// wildSupertype(Holder<? super T>,T)
		// i s applied t o (Holder,Long)
		wildSupertype(qualified, lng);
		// wildSupertype(unbounded, lng); // Error:
		// wildSupertype(Holder<? super T>,T) cannot be
		// applied t o (Holderccapture of ?>,Long)
		// wildSupertype(bounded, lng); // Error:
		// wi ldSupertype(Holder<? super T> ,T) cannot be
		// applied t o (Holder<capture of ? extends Long>,Long)
	}

}
