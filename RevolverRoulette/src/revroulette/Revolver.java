package revroulette;

import java.util.Collections;
import java.util.LinkedList;

public class Revolver {
	int cylinderSize = 5;
	LinkedList<Chamber> Cylinder = new LinkedList<Chamber>();
	boolean isReady = false;
	boolean hasBulletsLeft = false;

	
	public Revolver() {	
	}
	
	public void load(int amt) {
		int leftEmpty = cylinderSize - amt;
			for(int j = 0;j < amt; j++) {
				Chamber chamber = new Chamber();
				chamber.setLoaded(true);
				Cylinder.add(chamber);
			}
		for (; leftEmpty >= 0; leftEmpty--) {
				Cylinder.add(new Chamber());
		}
		Collections.shuffle(Cylinder);
		isReady = true;
	}

	public boolean pullTrigger() {
		if(!isReady) {
			System.out.println("Load the revolver first!");
			return false;
		} else if (!Cylinder.isEmpty()) {
		Chamber fired = Cylinder.pop();
		return fired.isLoaded();
		} else {
			return false;
		}
	}

	public void checkChambers() {
		for (Chamber c : Cylinder) {
			System.out.println(c.isLoaded());
		}
	}

	public boolean countShots() {
		for (Chamber c : Cylinder) {
			if (c.isLoaded()) {
				return c.isLoaded();
			}
		}
		return false;
	}
}
