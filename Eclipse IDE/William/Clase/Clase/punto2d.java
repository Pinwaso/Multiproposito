package Clase.Clase;

public class punto2d {
	private double x, y;

	public punto2d(double x, double y) {
	this.x = x;
	this.y = y;
	}

	public static double distancia(punto2d p1, punto2d p2) {
		return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
	}

	@Override
	public String toString() {
		return "punto2d [x=" + x + ", y=" + y + "]";
	}
}