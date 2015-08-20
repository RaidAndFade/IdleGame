package it.gocode.idlewar.debris;

import it.gocode.idlewar.interfaces.Ticking;

public class Debris implements Ticking {
	int variation = 0;
	String objName = "";
	boolean fancy = true;
	
	public int getVariation() {
		return variation;
	}

	public void setVariation(int variation) {
		this.variation = variation;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public boolean isFancy() {
		return fancy;
	}

	public void setFancy(boolean fancy) {
		this.fancy = fancy;
	}

	
	public void Tick() {}

	public boolean Tickable() {return false;}

}
