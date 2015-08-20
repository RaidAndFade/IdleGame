package it.gocode.idlewar.images;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import it.gocode.idlewar.idleWar;
import it.gocode.idlewar.ground.Ground;

public class gameImagePreloader {
	private idleWar theGame;
	private Map<String,Image> cached = new HashMap<String,Image>();
	public gameImagePreloader(idleWar _theGame){
		theGame = _theGame;
	}

	public Image getImage(String type, String subtype, int num) {
		if(!cached.containsKey(type+""+num)){
			loadImage(type,subtype,num);
		}
		return cached.get(type+""+num);
	}

	private void loadImage(String type,String subtype, int num) {
		try {
			cached.put(type+""+num, ImageIO.read(getClass().getResource("/it/gocode/idlewar/resources/"+type+"/"+subtype+"_"+num+".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
