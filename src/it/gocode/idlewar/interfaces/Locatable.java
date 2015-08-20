package it.gocode.idlewar.interfaces;

import it.gocode.idlewar.data.Location;

public class Locatable extends Location {
	public Locatable(int _x, int _y) {
		super(_x, _y);
	}

	public boolean canLocate=true;

	public boolean canLocate() {
		return canLocate;
	}

	public void setLocatable(boolean _canLocate) {
		this.canLocate = _canLocate;
	}
	
	
}
