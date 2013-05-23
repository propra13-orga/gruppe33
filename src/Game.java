import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Game {
	public static int CurrentLevel;
	public static Map CurrentMap;
	
	public static void main(String[] args) throws IOException {
		Maps.LoadMapList(System.getProperty("user.dir") + "\\maps");
		Enemys.LoadEnemeys(System.getProperty("user.dir") + "\\enemys");
		
		DrawManager.DrawMenu();
	}
	
	public static void LoadMap(int GameLevel) {
		Game.CurrentLevel = GameLevel;
		Game.CurrentMap = Maps.GetMap(GameLevel);
		
		Char.PosX = Game.CurrentMap.Player_Start_Positions[0];
		Char.PosY = Game.CurrentMap.Player_Start_Positions[1];
		
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
	
	public static void StartMenu() {
		DrawManager.window.getContentPane().removeAll();
		DrawManager.window.revalidate();
		DrawManager.window.repaint();
		
		ImageCanvas ic = new ImageCanvas();
		ic.filename = "images/startmenu.jpg";
    	
		DrawManager.window.getContentPane().add(ic);
		DrawManager.window.setBounds(30, 30, 640, 480);
		DrawManager.window.setVisible(true);
	}
	
	public static void GameOver() {
		// TODO: OPTIMIZING THIS WEIRD STUFF
		DrawManager.window.getContentPane().removeAll();
		DrawManager.window.revalidate();
		DrawManager.window.repaint();
		
		ImageCanvas ic = new ImageCanvas();
		ic.filename = "images/gameover.jpg";
    	
		DrawManager.window.getContentPane().add(ic);
		DrawManager.window.setBounds(30, 30, 640, 480);
		DrawManager.window.setVisible(true);
	}
}