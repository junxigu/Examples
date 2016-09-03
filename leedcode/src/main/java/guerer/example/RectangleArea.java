package guerer.example;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 Rectangle Area

 Assume that the total area is never beyond the maximum possible value of int.

 * 
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		return rectangleArea(A, B, C, D)
				+ rectangleArea(E, F, G, H)
				- (isOverlap(A, B, C, D, E, F, G, H) ? computeOverlap(A, B, C,
					D, E, F, G, H) : 0);
	}

	public int rectangleArea(int A, int B, int C, int D) {
		return (C - A) * (D - B);
	}

	public boolean isOverlap(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int lx = Math.max(A, E);
		int ly = Math.max(B, F);
		int rx = Math.min(C, G);
		int ry = Math.min(D, H);

		return lx < rx && ly < ry;
	}

	public int computeOverlap(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int lx = Math.max(A, E);
		int ly = Math.max(B, F);
		int rx = Math.min(C, G);
		int ry = Math.min(D, H);

		return (rx - lx) * (ry - ly);
	}
}
