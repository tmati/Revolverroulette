package revroulette;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Plays a roulette game between players.
 * 
 * @author Topi Matikainen
 *
 */
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
				
			
		Revolver revolver = Revolver.getInstance();	
				
		int bullets = 0;
		try(Scanner keyboard = new Scanner(System.in)){
		
			do {
				try {
					System.out.println("How many bullets do you want?");
					bullets = keyboard.nextInt();
				}
				
				catch(InputMismatchException e) {
					System.out.println("Invalid input");
					System.out.println("Enter a number of bullets between 0 and " + revolver.getCylinderSize());
					keyboard.nextLine();
				}
				if (bullets < 1 || bullets > revolver.getCylinderSize()) {
					System.out.println("Number should be between 1 and " + revolver.getCylinderSize());
				}
				
			} while (bullets < 1 || bullets > revolver.getCylinderSize());
			
			System.out.println("\nLOAD " + bullets + "\n");
			revolver.load(bullets);
		}
		
		while (revolver.countShots()) {
			for (Iterator<Player> it = players.iterator(); it.hasNext(); ) {
				Player P = it.next();
				if (revolver.pullTrigger()) {
					System.out.println("BOOM! Player " + P.getName() + " blew their brains out!");
					it.remove();
					if (!revolver.hasBulletsLeft) {
						break;
					}
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
