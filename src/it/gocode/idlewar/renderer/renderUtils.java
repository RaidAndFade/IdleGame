package it.gocode.idlewar.renderer;

import it.gocode.idlewar.idleWar;
import it.gocode.idlewar.images.Texture;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;

public class renderUtils {
	private static int prevTEXTURE=-5123213;

	/**
	 * Draws a Rectangle on an opengl display
	 * @param x X coord
	 * @param y Y coord
	 * @param w Width
	 * @param h Length
	 */
	public static void drawRECT(int x,int y,int w,int h){
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x,y);
		GL11.glVertex2f(x+w,y);
		GL11.glVertex2f(x+w,y+h);
		GL11.glVertex2f(x,y+h);
		GL11.glEnd();
	}
	public static void drawTRECT(int x, int y, int w, int h, Texture t) {		
		t.bind();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0f, 0f);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(1, 0f);
		GL11.glVertex2f(x+w,y);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(x+w,y+h);
		GL11.glTexCoord2f(0f, 1);
		GL11.glVertex2f(x,y+h);
		GL11.glEnd();
		System.out.println(idleWar.curFPS);
	}
	public static void drawQTRECT(int x, int y, int w, int h, Texture t,int q) {
		t.bind();
		float tw=0.4f,th=0.4f,tx,ty;
		
		switch(q){
		default : tx=0;ty=0;break;
		case 1 : tx=0.5f;ty=0.5f;break;
		case 2 : tx=0f;ty=0.5f;break;
		case 3 : tx=0.5f;ty=0f;break;
		}
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(tx, ty);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(tx+tw, ty);
		GL11.glVertex2f(x+w,y);
		GL11.glTexCoord2f(tx+tw, ty+th);
		GL11.glVertex2f(x+w,y+h);
		GL11.glTexCoord2f(tx, ty+th);
		GL11.glVertex2f(x,y+h);
		GL11.glEnd();
		GL11.glPopMatrix();
		System.out.println(idleWar.curFPS);
	}
	/**
	 * Draws a Square on an opengl display
	 * @param x X coord
	 * @param y Y coord
	 * @param l Side length
	 */
	public static void drawSQ(int x, int y, int l){
		drawRECT(x,y,l,l);
	}
	
	public static void drawTSQ(int x, int y, int l,Texture t){
		drawTRECT(x,y,l,l,t);
	}

	public static void drawQTSQ(int x, int y, int l, Texture t, int q) {
		drawQTRECT(x,y,l,l,t,q);
	}

}
