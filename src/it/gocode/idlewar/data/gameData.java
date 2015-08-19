package it.gocode.idlewar.data;

import java.util.ArrayList;
import java.util.List;

import it.gocode.idlewar.buildings.Building;
import it.gocode.idlewar.units.Unit;

public class gameData {
	public int playercount;
	public String map;
	public Player[] players;
	public List<Building> buildings = new ArrayList<Building>();
	public List<Unit> units = new ArrayList<Unit>();
	public gameData(int _pc, String _map, Player[] _players){
		this.playercount=_pc;
		this.map=_map;
		this.players=_players;
	}
}
