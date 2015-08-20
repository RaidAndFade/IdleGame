package it.gocode.idlewar.ground;

import it.gocode.idlewar.utils.mathUtils;

public class Ground {
	public int variation;
	public int subType;
	public String type;
	public Ground(String gType,int gVar) {
		variation=gVar;
		type=gType;
		subType=mathUtils.randInt(0, 3);
	}
}
