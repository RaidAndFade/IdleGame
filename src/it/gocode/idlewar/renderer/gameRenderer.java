package it.gocode.idlewar.renderer;

import static org.lwjgl.glfw.GLFW.*;

import it.gocode.idlewar.idleWar;
import it.gocode.idlewar.data.Location;
import it.gocode.idlewar.ground.Ground;
import static it.gocode.idlewar.renderer.renderUtils.*;

import java.nio.IntBuffer;
import java.util.Map.Entry;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class gameRenderer {
    public float now, last=0, delta;
    public idleWar theGame;
    public IntBuffer widthb,heightb;
	public int xoff=0,yoff=0;
	public gameRenderer(idleWar _theGame) {
		theGame = _theGame;

		widthb = BufferUtils.createIntBuffer(1);
		heightb = BufferUtils.createIntBuffer(1);
	}

	public void render(long Window) {
		glfwGetWindowSize(Window, widthb, heightb);
		widthb.rewind();heightb.rewind();
		int width = widthb.get(),height = heightb.get();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);         
		GL11.glClearDepth(1);
		GL11.glViewport(0-xoff,0-yoff,width,height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		for(Entry<Location,Ground> ge : theGame.currgd.map.ground.entrySet()){
			Ground g = ge.getValue();Location l = ge.getKey();
			drawTSQ(l.getX()*20,l.getY()*20,20,theGame.textureLoader.getTexture("ground", g.type, g.subType));
		}
		
		widthb.flip();heightb.flip();
	}

}
