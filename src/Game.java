import java.io.IOException;

public class Game {
	public static int CurrentLevel;
	
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir") + "\\maps");
		Maps.LoadMapList(3, System.getProperty("user.dir") + "\\maps");
		
		Game.CurrentLevel = 1;
		// SAVE LEVEL
		
		DrawManager.DrawMap(Maps.GetMap(Game.CurrentLevel));
	}
	
	public static void GameOver() {
		// TODO: GAMEOVER SCREEN
	}
}