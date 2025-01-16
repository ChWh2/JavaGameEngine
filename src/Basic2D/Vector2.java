package Basic2D;

public class Vector2 {
	public double x = 0.0;
	public double y = 0.0;
	
	public Vector2(double x1, double y1) {
		x=x1;
		y=y1;
	}
	
	public Vector2 normalize() {
		double magnitude = length();
		if (magnitude != 0.0) {
			return new Vector2(x/magnitude,y/magnitude);
		}
		else {
			return this;
		}
	}
	
	public double length() {
		return Math.sqrt((x * x) + (y * y));
	}
	public Vector2 add(Vector2 other) {
		Vector2 newVector = new Vector2(x + other.x, y + other.y);
		return newVector;
	}
	public Vector2 subtract(Vector2 other) {
		Vector2 newVector = new Vector2(x - other.x, y - other.y);
		return newVector;
	}
	public Vector2 multiply(double other) {
		Vector2 newVector = new Vector2(x * other, y * other);
		return newVector;
	}
	public Vector2 divide(double other) {
		Vector2 newVector = new Vector2(x / other, y / other);
		return newVector;
	}

}
