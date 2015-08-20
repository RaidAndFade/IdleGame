package it.gocode.idlewar;

import java.util.Map.Entry;

import it.gocode.idlewar.buildings.Building;
import it.gocode.idlewar.data.Location;
import it.gocode.idlewar.data.Player;
import it.gocode.idlewar.data.gameData;
import it.gocode.idlewar.data.gameMap;
import it.gocode.idlewar.exceptions.noNameProvidedException;
import it.gocode.idlewar.images.gameImagePreloader;
import it.gocode.idlewar.listeners.gameKeyListener;
import it.gocode.idlewar.listeners.gameMouseListener;
import it.gocode.idlewar.units.Unit;
/***
 * 
 * @author Sepehr
 * @version 0.0.1
 *
 *
 * TODO LIST 
 * Tap that, for max
 * Make Secrets
 * 
 *
 */
/*REAL TODO LIST
 * Make the map auto-generate with trees.
 * Textures for different types of ground, with semi-transparent sides.
 * 
 * 
 */
public class idleWar {
	public static idleWar theGame;
	public static double curFPS, curTicks;
	public static boolean running=false;
	public static boolean showStats=true;
	public gameWindow gWindow;
	public gameData currgd;
	public gameMouseListener mouseListener;
	public gameKeyListener keyListener;
	public gameImagePreloader imageLoader;
	
	int fps=0; long lastFPSCheck=System.currentTimeMillis();
	int ticks=0; long lastTickCheck=System.currentTimeMillis();
	public int desiredFPS = 60,desiredTicks=20;
	protected boolean rendered = true;
	
	public idleWar(){
		mouseListener = new gameMouseListener();
		keyListener = new gameKeyListener();
		gWindow = new gameWindow(this);
		imageLoader = new gameImagePreloader(this);
		idleWar.theGame = this;
		this.newGame();
		this.gameLoop();
	}
	private void newGame() {
		Player[] players = new Player[2];
		try {
			players[0] = new Player(false,"Player");
			players[1] = new Player(true);
		} catch (noNameProvidedException e) {
			e.printStackTrace();
		}
		currgd = new gameData(2,new gameMap("New Game"),players);
		//currgd.map.genMap(gframe.getWidth(), gframe.getHeight());
		running=true;
	}

	public void gameLoop(){
		new Thread("GameTick"){
			public void run(){
				while(running){
					idleWar.theGame.tickGame();

					if(System.currentTimeMillis()-lastTickCheck>=1000){
						curTicks=ticks;ticks=0;
						lastTickCheck=System.currentTimeMillis();
					}
					ticks++;
					try {Thread.sleep(1000/desiredTicks);} catch (InterruptedException e) {}
				}
			}
		}.start();
	}
	public void tickGame() {
		for(Entry<Location, Building> be : currgd.map.buildings.entrySet()){
			Building b = be.getValue();
			if(b.Tickable()){
				b.Tick();
			}
		}
		for(Entry<Location, Unit> ue : currgd.map.units.entrySet()){
			Unit u = ue.getValue();
			if(u.Tickable()){
				u.Tick();
			}
		}
	}
}
