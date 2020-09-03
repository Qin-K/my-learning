package ch10;

class Player{
	static int playerCount = 0;
	private String name;
	public Player(String n) {
		name = n;
		playerCount++;
	}
}
public class PlayerTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Player.playerCount);
		Player one = new Player("Tiger Woods");
		System.out.println(Player.playerCount);
	}

}
