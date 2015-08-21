package it.gocode.idlewar.data;

import it.gocode.idlewar.buildings.Building;
import it.gocode.idlewar.debris.Debris;
import it.gocode.idlewar.debris.Tree;
import it.gocode.idlewar.ground.Ground;
import it.gocode.idlewar.units.Unit;
import it.gocode.idlewar.utils.mathUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class gameMap {

	public Map<Location,Building> buildings = new HashMap<Location, Building>();
	public Map<Location,Unit> units = new HashMap<Location, Unit>();
	public Map<Location,Ground> ground = new HashMap<Location, Ground>();
	public Map<Location,Debris> debris = new HashMap<Location, Debris>();
	public String mapName;
	//public Map<Location,Integer> heightMap = new HashMap<Location, Integer>();
	//Maybe 3d at some point?
	
	public gameMap(String _mapName) {
		mapName=_mapName;
	}
	public void genMap(int width,int height){
		width/=20;height/=20;
		genGround(width,height);
		genDebris(width,height);
	}
	private void genDebris(int width, int height) {
		//Tree Gen
		for(Entry<Location,Ground> ge : ground.entrySet()){
			Ground g = ge.getValue();
			Location l = ge.getKey();
			int rand = mathUtils.randInt(0, 100);
			boolean spawn;
			switch(g.type){
				case "grass" : spawn = rand>70;break;
				case "sand" : spawn = rand>90;break;
				default : spawn = false;break;
			}
			if(spawn){
				debris.put(l, new Tree());
			}
		}
	}
	public void genGround(int width,int height){
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				ground.put(new Location(x,y), new Ground("grass",0));
			}
		}
	}
}
