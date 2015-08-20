package it.gocode.idlewar;

import it.gocode.idlewar.data.Location;
import it.gocode.idlewar.ground.Ground;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Random;

import javax.imageio.ImageIO;

public class gameRenderer {
	private idleWar theGame;
	public gameRenderer(idleWar _game) {
		theGame = _game;
	}
	int i=0;
	public void drawGame(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		int xoff=theGame.gframe.WIDTH,yoff=(int) (theGame.gframe.HEIGHT);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(rh);
		for(Entry<Location,Ground> ge : theGame.currgd.map.ground.entrySet()){
			Ground gr = ge.getValue();Location l = ge.getKey();
			int xr,yr;
			switch(gr.subType){
			default: xr=100;yr=100;break;
			case 1: xr=200;yr=100;break;
			case 2: xr=100;yr=200;break;
			case 3: xr=200;yr=200;break;
			}
			int x=l.getX()*20-xoff/2,y=l.getY()*20-yoff/2;
			g2.drawImage(theGame.imageLoader.getImage("ground",gr.type,gr.variation), x, y, x+20, y+20, xr-50, yr-50, xr, yr, null);
		}
		
		
        if(idleWar.showStats){
    		renderDebug(g2);
        }
        
        theGame.rendered=true;
	}
	private void renderDebug(Graphics2D g2) {
		Font f = new Font(Font.SANS_SERIF,Font.PLAIN,12);    
		g2.setFont(f);
        g2.setColor(Color.black);
		AffineTransform affinetransform = new AffineTransform(); 
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    	String fpsCount = "Current FPS : " + idleWar.curFPS;
    	String tickCount = "Current Ticks : " + idleWar.curTicks;
    	g2.drawString(fpsCount, (int) (theGame.gframe.getWidth()-20-f.getStringBounds(fpsCount, frc).getWidth()), 15);
    	g2.drawString(tickCount, (int) (theGame.gframe.getWidth()-20-f.getStringBounds(tickCount, frc).getWidth()), 30);
	}
}
