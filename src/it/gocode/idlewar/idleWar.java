package it.gocode.idlewar;

import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.gocode.idlewar.buildings.Building;
import it.gocode.idlewar.data.Player;
import it.gocode.idlewar.data.gameData;
import it.gocode.idlewar.exceptions.noNameProvidedException;
import it.gocode.idlewar.listeners.gameKeyListener;
import it.gocode.idlewar.listeners.gameMouseListener;
/***
 * 
 * @author Sepehr
 *
 *
 * TODO LIST 
 * Tap that, for max
 * Make Secrets
 * 
 */
public class idleWar {
	public static idleWar theGame;
	public static double curFPS, curTicks;
	public static boolean running=true;
	public static boolean showStats=true;
	public gameFrame gframe;
	public gameRenderer grenderer;
	public gameData currgd;
	public gameMouseListener mouseListener;
	public gameKeyListener keyListener;
	
	int fps=0; long lastFPSCheck=System.currentTimeMillis();
	int ticks=0; long lastTickCheck=System.currentTimeMillis();
	public int desiredFPS = 60,desiredTicks=40;
	
	public idleWar(){
		mouseListener = new gameMouseListener();
		keyListener = new gameKeyListener();
		grenderer = new gameRenderer(this);
		gframe = new gameFrame(this);
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
		currgd = new gameData(2,"New Game",players);
	}

	public void gameLoop(){
		new Thread("Renderer"){
			public void run(){
				while(running){
					gframe.repaint();
					
					if(System.currentTimeMillis()-lastFPSCheck>=1000){
						curFPS=fps;fps=0;
						lastFPSCheck=System.currentTimeMillis();
					}
					fps++;
					try {Thread.sleep(1000/desiredFPS);} catch (InterruptedException e) {}
				}
			}
		}.start();
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
		for(Building b : currgd.buildings){
			if(b.Tickable()){
				b.Tick();
			}
		}
	}
}
