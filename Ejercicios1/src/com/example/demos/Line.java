package com.example.demos;

public class Line {
	private Point point1, point2;
	
	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	public Point getPoint1() {
		return point1.clone();
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2.clone();
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	
	public int deltaX() {
		return Math.abs(point1.getX() -point2.getX());
	}
	
	public int deltaY() {
		return Math.abs(point1.getY() -point2.getY());
	}
}
