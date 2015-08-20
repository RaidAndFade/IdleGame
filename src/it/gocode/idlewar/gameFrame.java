package it.gocode.idlewar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class gameFrame extends JFrame{
	private static final long serialVersionUID = -2116535665276884824L;
	private idleWar theGame;
	public gameFrame(idleWar _theGame) {
		theGame = _theGame;
		setTitle("Idle War");
		addMouseListener(theGame.mouseListener);
		addMouseMotionListener(theGame.mouseListener);
		addKeyListener(theGame.keyListener);
		add(new gamePanel(theGame));
		setMinimumSize(new Dimension(800,600));
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}