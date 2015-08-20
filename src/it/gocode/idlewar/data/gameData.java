package it.gocode.idlewar.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.gocode.idlewar.buildings.Building;
import it.gocode.idlewar.units.Unit;

public class gameData {
	public int playercount;
	public gameMap map;
	public Player[] players;
	public gameData(int _pc, gameMap _map, Player[] _players){
		this.playercount=_pc;
		this.map=_map;
		this.players=_players;
	}
}
