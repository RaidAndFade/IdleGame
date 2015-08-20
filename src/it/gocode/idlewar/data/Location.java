package it.gocode.idlewar.data;

public class Location {
	int x,y;
	public Location(int _x, int _y) {
		x=_x;y=_y;
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
}
