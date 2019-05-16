package revroulette;

/**
 * Player with name information
 * 
 * @author Topi Matikainen
 *
 */
public class Player {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Player(String name) {
		this.name = name;
	}

}
