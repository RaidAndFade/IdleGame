package it.gocode.idlewar.listeners;

import org.lwjgl.glfw.GLFWErrorCallback;

public class ErrorListener extends GLFWErrorCallback {

	@Override
	public void invoke(int error, long description) {
		System.out.println("Error!");
	}

}
