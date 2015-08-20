package it.gocode.idlewar.listeners;

import it.gocode.idlewar.idleWar;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_TRUE;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.lwjgl.glfw.GLFWKeyCallback;

public class gameKeyListener extends GLFWKeyCallback  {


	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		if(window==idleWar.theGame.gWindow.mainWindow){
	        if (key == GLFW_KEY_F3 && action == GLFW_PRESS) {
	        	idleWar.showStats=!idleWar.showStats;
	        }
		}
	}

}
