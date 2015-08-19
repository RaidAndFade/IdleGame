package it.gocode.idlewar;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamePanel extends JPanel{
	private idleWar theGame;
	public gamePanel(idleWar _theGame){
		this.theGame = _theGame;
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		theGame.grenderer.drawGame(g);
	}

}
