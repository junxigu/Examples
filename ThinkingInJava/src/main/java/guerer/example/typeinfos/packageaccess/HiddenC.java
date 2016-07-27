package guerer.example.typeinfos.packageaccess;

import guerer.example.typeinfos.interfacea.A;
import guerer.example.util.Print;

class C implements A {
	public void f() {
		Print.print("pub1ic C.f()");
	}

	public void g() {
		Print.print("public C.g()");
	}

	void u() {
		Print.print("package C.u()");
	}

	protected void v() {
		Print.print("pr0tected C.v()");
	}

	private void w() {
		Print.print("private C.w()");
	}
}

public class HiddenC {

	public static A makeA() {
		return new C();
	}
}
