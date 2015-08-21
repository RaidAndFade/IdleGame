package it.gocode.idlewar;

import java.nio.IntBuffer;
import java.util.Map.Entry;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLContext;

import it.gocode.idlewar.buildings.Building;
import it.gocode.idlewar.data.Location;
import it.gocode.idlewar.data.Player;
import it.gocode.idlewar.data.gameData;
import it.gocode.idlewar.data.gameMap;
import it.gocode.idlewar.exceptions.noNameProvidedException;
import it.gocode.idlewar.images.gameTexturePreloader;
import it.gocode.idlewar.listeners.gameKeyListener;
import it.gocode.idlewar.listeners.gameMouseListener;
import it.gocode.idlewar.renderer.gameWindow;
import it.gocode.idlewar.units.Unit;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

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
	public static int loading;
	public static double curFPS, curTicks;
	public static boolean running=false;
	public static boolean showStats=true;
	public gameWindow gWindow;
	public gameData currgd;
	public gameMouseListener mouseListener;
	public gameKeyListener keyListener;
	public gameTexturePreloader textureLoader;
	int ticks=0; long lastTickCheck=System.currentTimeMillis();
	public int desiredFPS = 60,desiredTicks=20;
	protected boolean rendered = true;
	
	public idleWar(){
		loading=0;
		mouseListener = new gameMouseListener();
		keyListener = new gameKeyListener();
		gWindow = new gameWindow(this);
		textureLoader = new gameTexturePreloader(this);
		idleWar.theGame = this;
		this.newGame();
	}
	private void newGame() {
		Player[] players = new Player[2];
		try {
			players[0] = new Player(false,"Player");
			players[1] = new Player(true);
		} catch (noNameProvidedException e) {
			e.printStackTrace();
		}loading=8;
		currgd = new gameData(2,new gameMap("New Game"),players);
		currgd.map.genMap(1000,1000);
		running=true;
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
