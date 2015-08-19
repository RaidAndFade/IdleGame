package it.gocode.idlewar;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class gameRenderer {
	private idleWar theGame;
	public gameRenderer(idleWar _game) {
		theGame = _game;
	}
	int i=0;
	public void drawGame(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(rh);
		Font f = new Font(Font.SANS_SERIF,Font.PLAIN,12);
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
		g2.setFont(f);
        g2.setColor(Color.black);
        if(idleWar.showStats){
        	String fpsCount = "Current FPS : " + idleWar.curFPS;
        	String tickCount = "Current Ticks : " + idleWar.curTicks;
        	g2.drawString(fpsCount, (int) (theGame.gframe.getWidth()-20-f.getStringBounds(fpsCount, frc).getWidth()), 15);
        	g2.drawString(tickCount, (int) (theGame.gframe.getWidth()-20-f.getStringBounds(tickCount, frc).getWidth()), 30);
        }
	}
}
