package it.gocode.idlewar.listeners;

import it.gocode.idlewar.idleWar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gameKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_F3){
			idleWar.showStats=!idleWar.showStats;
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {

	}

}
