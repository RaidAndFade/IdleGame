package it.gocode.idlewar.interfaces;

public class Targetable{
	public int width,length;
	public boolean canTarget=true;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isTargetable() {
		return canTarget;
	}

	public void setTargetable(boolean _canTarget) { canTarget = _canTarget; }
}
