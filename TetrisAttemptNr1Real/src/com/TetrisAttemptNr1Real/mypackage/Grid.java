package com.TetrisAttemptNr1Real.mypackage;

public class Grid {
	private int x = 0;
	private int y = 0;
	private boolean empty = true;
	private boolean floorEmpty = true;
	public Grid(int pX, int pY) {
		x = pX;
		y = pY;
	}
	public void setEmpty(boolean pEmpty) {
		this.empty = pEmpty;
	}
	public boolean isEmpty() {
		return empty;
	}
	public int getX() {
		return x;
	}
	public void setX(int pX) {
		this.x = pX;
	}
	public int getY() {
		return y;
	}
	public void setY(int pY) {
		this.y = pY;
	}
	public void setFloorEmpty(boolean pFloorEmpty) {
		this.floorEmpty = pFloorEmpty;
	}
	public boolean isFloorEmpty() {
		return floorEmpty;
	}
}