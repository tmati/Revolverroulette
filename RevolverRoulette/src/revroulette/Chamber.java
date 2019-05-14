package revroulette;

public class Chamber {
	private boolean isLoaded;

	public boolean isLoaded() {
		return isLoaded;
	}

	public void setLoaded(boolean isLoaded) {
		this.isLoaded = isLoaded;
	}
	
	public Chamber() {
		this.isLoaded = false;
	}
	
}
