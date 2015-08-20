import org.lwjgl.Sys;

import it.gocode.idlewar.idleWar;

public class launch {

	public static void main(String[] args) {
		System.setProperty("org.lwjgl.librarypath", launch.class.getResource("/it/gocode/idlewar/resources/openjgl/natives").getFile());
		new idleWar();
	}

}
