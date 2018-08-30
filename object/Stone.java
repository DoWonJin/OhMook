package org.wonjin.ohmook.object;

import java.awt.Point;

public class Stone {
	public static final int COLOR_EMPTY = 0;
	public static final int COLOR_WHITE = 1;
	public static final int COLOR_BLACK = 2;
	
	public static final int RESULT_PLAY = 0;
	public static final int RESULT_WHITE_WIN = 1;
	public static final int RESULT_BLACK_WIN = 2;
	
	
	
	public int x;
	public int y;
	public int result;
	public int color;
	
	

	public int getStoneColor() {
		return color;
	}
	public void setStoneColor(int stoneColor) {
		this.color = stoneColor;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public Point getPoint() {
		return new Point(x,y);
	}
	public void setPoint(Point point) {
		this.x = (int) point.getX();
		this.y = (int) point.getY();
	}
	@Override
	public String toString() {
		return "Stone [x=" + x + ", y=" + y + ", result=" + result + ", color=" + color + "]";
	}

}
