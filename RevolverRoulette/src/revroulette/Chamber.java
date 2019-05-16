package revroulette;

/**
 * A class representation of a single chamber in a revolver's cylinder.
 * 
 * @author Topi Matikainen
 *
 */
public class Chamber {
	private boolean isLoaded;

	/**
	 * Get loaded state.
	 * 
	 * @return true if loaded.
	 */
	public boolean isLoaded() {
		return isLoaded;
	}

	/**
	 * Set loaded state.
	 * 
	 * @param isLoaded
	 */
	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}
	
	/**
	 * Constructor
	 */
	public Chamber() {
		this.isLoaded = false;
	}
	
}
