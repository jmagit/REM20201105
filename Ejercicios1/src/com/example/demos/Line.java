package com.example.demos;

public class Line {
	private Point point1, point2;

	
	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	
	public int deltaX() {
		return Math.abs(point1.x -point2.x);
	}
	
	public int deltaY() {
		return Math.abs(point1.y -point2.y);
	}
}
