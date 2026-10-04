package Clase.Clase;

public class punto {
	private int x, y;
	public punto(int x, int y) {
		setX(x);
		setY(y);
	}
	public punto() {
		this.x = 0;
		this.y = 0;
	}
	public int getX() { 
		return this.x; 
	}
	public void setX(int x) {
		if (x > 0) {
			this.x = x;
		} else {
			this.x = 0;
		}
	}
	public int getY () { 
		return this.y; 
	}
	public void setY (int y) {
		if (y > 0) {
			this.y = y;
		} else {
			this.y = 0;
		}
	}
}
