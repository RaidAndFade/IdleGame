package it.gocode.idlewar.renderer;

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
	private static void drawTRECT(int x, int y, int w, int h, int i) {		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0f, 0f);
		GL11.glVertex2f(x,y);
		GL11.glTexCoord2f(1f, 0f);
		GL11.glVertex2f(x+w,y);
		GL11.glTexCoord2f(1f, 1f);
		GL11.glVertex2f(x+w,y+h);
		GL11.glTexCoord2f(0f, 1f);
		GL11.glVertex2f(x,y+h);
		GL11.glEnd();
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
		t.bind();
		drawTRECT(x,y,l,l,1);
	}

}
