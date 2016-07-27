package third;

import java.util.Map;

import second.MissValueException;

public class Variable implements Segment{

	private String name;
	
	public Variable(String name) {
		this.name = name;
	}

	public boolean equals(Object other){
		return name.equals(((Variable) other).name);
	}
	
	public String evaluate(Map<String, String> variables) {
		String val = variables.get(name);
		if(val == null){
			throw new MissValueException("No value for ${" + name + "}");
		}
		return val;
	}
}
