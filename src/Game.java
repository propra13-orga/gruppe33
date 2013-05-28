import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Die Hauptklasse, hier ist der Einstiegspunkt f�r das Spiel
 * @author Gruppe3
 *
 */
public class Game {
	public static int CurrentLevel;
	public static Map CurrentMap;
	
	// Die Koordinaten des Ziels im Spiel, [2] : Level
	public static int[] Goal = {1, 1, 3};
	
	// Die Startpositionen des Charakters im Spiel
	public static int[] Start = {1, 4};
	
	/**
	 * L�dt die Maps, die Gegner und anschlie�end das Startmen�
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Maps.LoadMapList(System.getProperty("user.dir") + "\\maps");
		Enemys.LoadEnemeys(System.getProperty("user.dir") + "\\enemys");
		
		DrawManager.DrawMenu();
	}
	
	/**
	 * L�dt eine Map und zeichnet sie und den Spieler aufs JFrame
	 * @param GameLevel Das Spiellevel, welches geladen werden soll
	 * @param GoBack Kommt man gerade durch einen Ausgang?
	 */
	public static void LoadMap(int GameLevel, Boolean GoBack) {
		Game.CurrentLevel = GameLevel;
		Game.CurrentMap = Maps.GetMap(GameLevel);
		
		System.out.println(Game.CurrentLevel);
		if(!GoBack) {
			Char.PosX = Game.CurrentMap.Player_Start_Positions[0];
			Char.PosY = Game.CurrentMap.Player_Start_Positions[1];
		} else {
			Char.PosX = Game.CurrentMap.Player_End_Positions[0];
			// Damit der Char ein weiter unten kommt und nicht wieder zur�ckgeschickt wird
			Char.PosY = Game.CurrentMap.Player_End_Positions[1] + 1;
			
			// TODO: Oberes verhindern
		}
		
		DrawManager.DrawMap(Game.CurrentMap);
	}
	
	/**
	 * Hier wird das GameOver ausgef�hrt und auch aufs JFrame zeichnet
	 */
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
		
		DrawManager.window.removeKeyListener(DrawManager.CurrentKeyListener);
		DrawManager.CurrentKeyListener = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_ENTER){
					Game.LoadMap(1, false);
					
					// Die Startpositionen werden gesetzt
					Char.PosX = Game.Start[0];
					Char.PosY = Game.Start[1];
				}
			}
		};
		
		
		DrawManager.window.addKeyListener(DrawManager.CurrentKeyListener);
	}
	
	/**
	 * Wird ausgef�hrt wenn Spieler auf Zielfeld ist
	 */
	public static void Win() {
		// TODO: OPTIMIZING THIS WEIRD STUFF
		DrawManager.window.getContentPane().removeAll();
		DrawManager.window.revalidate();
		DrawManager.window.repaint();
				
		ImageCanvas ic = new ImageCanvas();
		ic.filename = "images/win.jpg";
		    	
		DrawManager.window.getContentPane().add(ic);
		DrawManager.window.setBounds(30, 30, 640, 480);
		DrawManager.window.setVisible(true);
		
		DrawManager.window.removeKeyListener(DrawManager.CurrentKeyListener);
		DrawManager.CurrentKeyListener = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_ENTER){
					Game.LoadMap(1, false);
					// Die Startpositionen werden gesetzt
					Char.PosX = Game.Start[0];
					Char.PosY = Game.Start[1];
				}
			}
		};
		
		
		DrawManager.window.addKeyListener(DrawManager.CurrentKeyListener);
	}
}