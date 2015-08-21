package it.gocode.idlewar.images;

import java.util.HashMap;
import java.util.Map;


import it.gocode.idlewar.idleWar;

public class gameTexturePreloader {
	private idleWar theGame;
	private Map<String,Texture> cached = new HashMap<String,Texture >();
	public gameTexturePreloader(idleWar _theGame){
		theGame = _theGame;
	}
	
	public void loadAllTextures(){
		loadTexture("ground","grass",0);
	}
	
	public Texture getTexture(String type, String subtype, int num) {
		if(!cached.containsKey(type+""+num)){
			loadTexture(type,subtype,num);
		}
		return cached.get(type+""+num);
	}

	private void loadTexture(String type,String subtype, int num) {
		cached.put(type+""+num, Texture.loadTexture(getClass().getResource("/it/gocode/idlewar/resources/"+type+"/"+subtype+"_"+num+".png").getFile()));
	}
}
