package revroulette;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Revolver implementation with Singleton creation pattern.
 * 
 * @author Topi Matikainen
 *
 */
public class Revolver {
	int cylinderSize = 5;
	LinkedList<Chamber> Cylinder = new LinkedList<Chamber>();
	boolean isReady = false;
	boolean hasBulletsLeft = false;

	/**
	 * private Singleton instance.
	 */
	private static Revolver REVOLVER = null;

	/**
	 * Private constructor for Singleton implementation.
	 */
	private Revolver() {
	}

	/**
	 * Singleton initializer
	 * 
	 * @return
	 */
	public static Revolver getInstance() {
		if (REVOLVER != null)
			REVOLVER = new Revolver();
		return REVOLVER;

	}
	
	/**
	 * Loads bullets into the revolvers cylinder
	 * 
	 * @param amt The amount of cylinders to have bullets in them.
	 */
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

	/**
	 * Cycles the revolver.
	 * 
	 * @return true if cycled chamber had a bullet in it.
	 */
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

	/**
	 * Prints out the order of the bullets in the cylinder.
	 */
	public void checkChambers() {
		for (Chamber c : Cylinder) {
			System.out.println(c.isLoaded());
		}
	}

	/**
	 * Checks for unfired bullets
	 * 
	 * @return true if bullets left.
	 */
	public boolean countShots() {
		for (Chamber c : Cylinder) {
			if (c.isLoaded()) {
				return c.isLoaded();
			}
		}
		return false;
	}
}
