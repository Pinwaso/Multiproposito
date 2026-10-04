package Clase.Clase;

public class triangulo extends figura2d {
	private punto2d p1, p2, p3;

	public triangulo(punto2d p1, punto2d p2, punto2d p3) {
		super(3);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public double perimetro() {
		return p1.distancia(p1, p2) + p2.distancia(p2, p3) + p3.distancia(p3, p1);
	}

	public double area() {
		double a = punto2d.distancia(p1, p2);
		double b = punto2d.distancia(p2, p3);
		double c = punto2d.distancia(p3, p1);
		double s = (a + b + c) / 2;
		return (Math.sqrt(s * (s - a) * (s - b) * (s - c)));
	}

	@Override
	public String toString() {
		return "El triángulo es de tipo \n"
				+ "Es de area " + area() + "\n"
				+ "Perímetro " + perimetro() + "\n"
				+ "Sus puntos son: " + p1 + p2 + p3;
	}	
}