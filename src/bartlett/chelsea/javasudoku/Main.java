package bartlett.chelsea.javasudoku;

public class Main {
	
	private static abstract class Shape {
		abstract public double getArea();
		}
	
	public static class Circle extends Shape {
		private final double _radius;
		public Circle(double radius) {
			_radius = radius;
		}
		@Override
		public double getArea() {
			return Math.PI * _radius * _radius;
		}
	}
	
	public static class Rectangle extends Shape {
		private final double _length;
		private final double _width;
		public Rectangle(double l, double w) {
			_length = l;
			_width = w;					
		}
		@Override
		public double getArea() {
			return _length * _width;
		}
	}
	
	public static class Square extends Rectangle {
		public Square(double l) {
			super(l,  l);
		}
	}
	
	
	
	public static void main (String[] args){
		
	}
}
