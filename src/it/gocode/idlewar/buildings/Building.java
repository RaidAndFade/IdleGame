package it.gocode.idlewar.buildings;

import it.gocode.idlewar.interfaces.Ticking;

public class Building implements Ticking {
	public int PlayerID;
	public void Tick(){}
	public boolean Tickable() {return true;}
	
}
