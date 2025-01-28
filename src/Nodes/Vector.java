package Nodes;

public class Vector {
	public double x = 0.0;
	public double y = 0.0;
	
	public Vector(double x1, double y1) {
		x=x1;
		y=y1;
	}
	
	public Vector normalize() {
		double magnitude = length();
		if (magnitude != 0.0) {
			return new Vector(x/magnitude,y/magnitude);
		}
		else {
			return this;
		}
	}
	
	public double length() {
		return Math.sqrt((x * x) + (y * y));
	}
	
	public double distanceTo(Vector other) {
		return new Vector(x - other.x, y - other.y).length();
	}
	
	public Vector add(Vector other) {
		Vector newVector = new Vector(x + other.x, y + other.y);
		return newVector;
	}
	public Vector subtract(Vector other) {
		Vector newVector = new Vector(x - other.x, y - other.y);
		return newVector;
	}
	public Vector multiply(double other) {
		Vector newVector = new Vector(x * other, y * other);
		return newVector;
	}
	public Vector divide(double other) {
		Vector newVector = new Vector(x / other, y / other);
		return newVector;
	}

}
