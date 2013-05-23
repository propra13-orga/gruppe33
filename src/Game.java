import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Game {
	public static int CurrentLevel;
	public static Map CurrentMap;
	
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir") + "\\maps");
		Maps.LoadMapList(3, System.getProperty("user.dir") + "\\maps");
		
		Game.CurrentLevel = 1;
		// SAVE LEVEL
		
		Char.PosX = config.POSX_PLAYER_START;
		Char.PosY = config.POSY_PLAYER_START;
		
		Game.CurrentMap = Maps.GetMap(Game.CurrentLevel);
		DrawManager.DrawMap(Game.CurrentMap);
		
		DrawManager.window.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP) {
					Char.MoveUp();
				}
				if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
					Char.MoveDown();
				}
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
					Char.MoveRight();
				}
				if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
					Char.MoveLeft();
				}
			}
		});
	}
	
	public static void GameOver() {
		// TODO: GAMEOVER SCREEN
	}
}