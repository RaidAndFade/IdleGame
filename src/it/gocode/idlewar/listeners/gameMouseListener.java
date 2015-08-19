package it.gocode.idlewar.listeners;

import it.gocode.idlewar.listeners.utils.mouseInfo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class gameMouseListener implements MouseListener, MouseMotionListener  {

	public mouseInfo mInfo;
	
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {
		//Pause Game?
	}

	public void mousePressed(MouseEvent e) {
		switch(e.getButton()){
		case 1 : //Left Click
		case 2 : //Middle click
		case 3 : //Right Click
	}
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
		// TODO Select units
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO
	}

}
