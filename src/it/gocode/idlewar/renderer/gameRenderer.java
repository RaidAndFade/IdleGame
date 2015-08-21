package it.gocode.idlewar.renderer;

import static org.lwjgl.glfw.GLFW.*;

import it.gocode.idlewar.idleWar;
import it.gocode.idlewar.data.Location;
import it.gocode.idlewar.ground.Ground;
import it.gocode.idlewar.images.Texture;

import static it.gocode.idlewar.renderer.renderUtils.*;

import java.nio.IntBuffer;
import java.util.Map.Entry;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class gameRenderer {
    public float now, last=0, delta;
    public idleWar theGame;
    public int width,height;
    public IntBuffer widthb,heightb;
	public int xoff=0,yoff=0;
	public float scale;
	public gameRenderer(idleWar _theGame) {
		theGame = _theGame;

		widthb = BufferUtils.createIntBuffer(1);
		heightb = BufferUtils.createIntBuffer(1);
		scale = 1;
	}

	public void render(long Window) {
		glfwGetWindowSize(Window, widthb, heightb);
		widthb.rewind();heightb.rewind();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		scale=1f;
		
		width = widthb.get();height = heightb.get();
		GL11.glViewport(0-xoff,0-yoff,width,height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glScalef(scale, scale, 1f);
		
		for(Entry<Location,Ground> ge : theGame.currgd.map.ground.entrySet()){
			Ground g = ge.getValue();Location l = ge.getKey();
			int quadrent = g.variation;
			if(l.getX()*20<width&&l.getX()*20>=xoff)
				if(l.getY()*20<height&&l.getY()*20>=yoff)
					drawQTSQ(l.getX()*20,l.getY()*20,20,theGame.textureLoader.getTexture("ground", g.type, g.subType),quadrent);
		}
		
		widthb.flip();heightb.flip();
	}

}
