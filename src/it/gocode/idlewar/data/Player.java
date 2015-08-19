package it.gocode.idlewar.data;

import java.util.HashMap;
import java.util.Map;
import it.gocode.idlewar.exceptions.noNameProvidedException;

public class Player {
	String name;
	boolean isAI;
	Map<String,Integer> values = new HashMap<String,Integer>();
	public Player(boolean _isAI, String _name) throws noNameProvidedException{
		if(!_isAI){
			if(_name==""||_name==null)throw new noNameProvidedException("The name is invalid");
			this.name=_name;
		}else{
			this.name="Bot";
		}
		values.put("wood", 0);
		values.put("gold", 0);
	}
	public Player(boolean _isAI) throws noNameProvidedException{
		new Player(_isAI,"");
	}
}
