package flightTrack;

import java.util.ArrayList;

public class capitals {
	
	private ArrayList<String> capitals = new ArrayList<String>();
	
	public void addCapital(String name) {
		capitals.add(name);
	}
	
	public void updateCapital(String newName,int index) {
		capitals.set(index, newName);
	}
	
	public void deleteCapital(int index) {
		capitals.remove(index);
	}

	public ArrayList<String> getCapitals() {
		return capitals;
	}

}
