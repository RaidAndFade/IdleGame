package it.gocode.idlewar.debris;

import it.gocode.idlewar.utils.mathUtils;

public class Tree extends Debris {

	public Tree() {
		this.setObjName("tree");
		this.setFancy(true);
		this.setVariation(mathUtils.randInt(0, 1));
	}

}
