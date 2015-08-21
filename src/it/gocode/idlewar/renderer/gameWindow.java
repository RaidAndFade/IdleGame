package it.gocode.idlewar.renderer;

import it.gocode.idlewar.idleWar;
import it.gocode.idlewar.listeners.ErrorListener;
import it.gocode.idlewar.renderer.gameRenderer;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

public class gameWindow {
	private idleWar theGame;
	public long mainWindow;
	public GLContext glc;
	private GLFWErrorCallback errorCallback = new ErrorListener();
	public gameRenderer gRenderer;
	public gameWindow(idleWar _theGame) {
		theGame = _theGame;
		new Thread("Running"){
			public void run(){
				Start();
			}
		}.start();
	}
	public void Start(){
		glfwSetErrorCallback(errorCallback);
		if (glfwInit() != GL_TRUE) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}
		mainWindow = glfwCreateWindow(640, 480, "Idle War", NULL, NULL);
		if (mainWindow == NULL) {
			glfwTerminate();
			throw new RuntimeException("Failed to create the GLFW window");
		}
		glfwSetKeyCallback(mainWindow, theGame.keyListener);
		glfwMakeContextCurrent(mainWindow);
		glfwShowWindow(mainWindow);
		GLContext.createFromCurrent();
		glEnable(GL_TEXTURE_2D);
		gRenderer = new gameRenderer(theGame);
		theGame.textureLoader.loadAllTextures();
		run();
	}
	public void run() {
		int fps=0; long lastFPSCheck=System.currentTimeMillis();
		
		while (glfwWindowShouldClose(mainWindow) != GL_TRUE) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		 
			gRenderer.render(mainWindow);
			
			
			glfwSwapBuffers(mainWindow);
			glfwPollEvents();
			//FPSCALC
			if(System.currentTimeMillis()-lastFPSCheck>=1000){
				theGame.curFPS=fps;fps=0;
				lastFPSCheck=System.currentTimeMillis();
			}
			fps++;
			if(idleWar.running)theGame.tickGame();
		}
	}
}