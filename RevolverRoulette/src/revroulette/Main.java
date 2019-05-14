package revroulette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Player> players = new ArrayList<Player>();
		Player p1 = new Player("Aku");
		Player p2 = new Player("Mikki");
		Player p3 = new Player("Hessu");
		Player p4 = new Player("Pelle");
		Player p5 = new Player("Roope");
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		players.add(p5);

		Revolver revolver = new Revolver();

		revolver.checkChambers();

		System.out.println("\n LOAD 4 \n");
		revolver.load(1);

		revolver.checkChambers();

		while (revolver.countShots()) {
			for (Iterator<Player> it = players.iterator(); it.hasNext(); ) {
				Player P = it.next();
				if (revolver.pullTrigger()) {
					System.out.println("BOOM! Player " + P.getName() + " blew their brains out!");
					it.remove();
				} else {
					System.out.println("Whew! Player " + P.getName() + " got away this time!");
				}
			}
		}
		System.out.println("\nThe revolver is now empty! \n The survivors are: ");
		for (Player L : players) {
			System.out.println(L.getName());
		}
	}
}
