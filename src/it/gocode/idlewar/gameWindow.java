package it.gocode.idlewar;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

public class gameWindow {
	private idleWar theGame;
	public long mainWindow;
	private GLFWErrorCallback errorCallback = Callbacks.errorCallbackPrint(System.err);
	public gameWindow(idleWar _theGame) {
		theGame = _theGame;
		glfwSetErrorCallback(errorCallback);
		if (glfwInit() != GL_TRUE) {
		    throw new IllegalStateException("Unable to initialize GLFW");
		}
		mainWindow = glfwCreateWindow(640, 480, "Simple example", NULL, NULL);
		if (mainWindow == NULL) {
		    glfwTerminate();
		    throw new RuntimeException("Failed to create the GLFW window");
		}

	}
}