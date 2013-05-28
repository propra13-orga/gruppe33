import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * Manager für alle Aufgbaen die mit dem Zeichnen auf das JFrame zutun haben
 * @author Gruppe33
 *
 */
public class DrawManager {
	public static JFrame window = new JFrame();
	public static KeyAdapter CurrentKeyListener;
	
	/**
	 * Zeichnet eine Map aufs JFrame
	 * @param m Die zu zeichende Map
	 */
	public static void DrawMap(Map m) {
		window.getContentPane().removeAll();
		
		// Bisschen dreckig, aber JFrame war zu klein für die Map
		int width = m.Size[0];
		int height = m.Size[1] + 1;
		
		// also fügen noch paar Pixel hinzu und voilá es klappt.
		// TODO: Lösung dafür finden
		window.setBounds(30, 30, (width* 32) + 11, (height * 32) + 11);
		
		MapCanvas mc = new MapCanvas();
    	mc.MapToDraw = m;
    
    	window.getContentPane().add(mc);
    	window.setVisible(true);
    	window.setTitle(mc.MapToDraw.Name);
    	
    	// Falls ein KeyListener auf dem JFrame ist, hol den runter!
    	window.removeKeyListener(CurrentKeyListener);
    	
    	// denn wir machen einen neuen drauf.
    	// Der KeyListener, mit allen Tastensteuerungen für den Char
    	CurrentKeyListener = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke) {
				// Pfeiltaste hoch
				if(ke.getKeyCode() == KeyEvent.VK_UP) {
					Char.MoveUp();
				}
				
				// Pfeiltaste runter
				if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
					Char.MoveDown();
				}
				
				// Pfeiltaste rechts
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
					Char.MoveRight();
				}
				
				// Pfeiltaste links
				if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
					Char.MoveLeft();
				}
				
				// Falls wir auf einen Eingang treffen
				if(Game.CurrentMap.Player_Start_Positions[0] == Char.PosX
						&& Game.CurrentMap.Player_Start_Positions[1] == Char.PosY) {
					Game.CurrentLevel--;
					Game.LoadMap(Game.CurrentLevel, true);
				}
				
				// Falls wir auf einen Ausgang treffen
				if(Game.CurrentMap.Player_End_Positions[0] == Char.PosX 
						&& Game.CurrentMap.Player_End_Positions[1] == Char.PosY) {
					Game.CurrentLevel++;
					Game.LoadMap(Game.CurrentLevel, false);
				}
				
				// Wenn der Spieler auf dem Zielfeld ist
				if(Game.CurrentLevel == Game.Goal[2]
						&& Char.PosX == Game.Goal[0]
						&& Char.PosY == Game.Goal[1]) {
					Game.Win();
				}
				
				
			}
		};
		
		DrawManager.window.addKeyListener(CurrentKeyListener);
	}
	
	/**
	 * Zeichnet das Menü auf den Jframe
	 */
	public static void DrawMenu() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuCanvas mc = new MenuCanvas();
		DrawManager.window.getContentPane().add(mc);
		DrawManager.window.setBounds(30, 30, 640, 480);
		DrawManager.window.setVisible(true);
		
		// Die Tastensteuerung für das Menü
		DrawManager.CurrentKeyListener = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke) {
				// Pfeiltaste hoch
				if(ke.getKeyCode() == KeyEvent.VK_UP) {
					if(MenuCanvas.CurrentState == 1) {
						// damit ist es nach unten weiter geht
						// Zustand 4 (danach -1 ist : 3 -> Wir sind beim letzen Element)
						MenuCanvas.CurrentState = 4;
					}
					
					MenuCanvas.CurrentState--;
				}
				
				// Pfeiltaste runter
				if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
					if(MenuCanvas.CurrentState == 3) {
						// Falls wir versuchen über das letzte Element hinaus zu gehen
						// fangen wir wieder ganz von vorne an (0 + 1 = 1 -> Tada, wir sind
						// im ersten Zustand wieder.
						MenuCanvas.CurrentState = 0;
					}
					MenuCanvas.CurrentState++;
				}
				
				// Eingabetaste
				if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
					switch(MenuCanvas.CurrentState){
					case 1: // NEUES SPIEL
						Game.LoadMap(1, false); // Lädt das erste Level
						
						// Die Startpositionen werden gesetzt
						Char.PosX = Game.Start[0];
						Char.PosY = Game.Start[1];
						break;
					case 2:
						// TODO: LOAD MAP
						break;
					case 3: // SPIEL BEENDEN
						System.exit(0); // Beendet das Programm
						break;
					}
				}
				
				// und wir müssen dem Fenster sagen wieder neu zu zeichnen damit man auch
				// Verändeurngen sieht
				DrawManager.window.revalidate();
				DrawManager.window.repaint();
			}
		};
		
		DrawManager.window.addKeyListener(CurrentKeyListener);
		
	}
}