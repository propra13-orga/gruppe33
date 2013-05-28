/**
 * Die Klasse für den Spieler
 * @author Gruppe33
 *
 */
public class Char {
	public static int PosX;
	public static int PosY;
	
	/**
	 * Wird aufgerufen wenn Spieler sich nach oben bewegen soll
	 */
	public static void MoveUp() {
		// Prüft den Zustand des Feldes einen weiter oben (Y - 1), wenn es 1 ist (begehbar) dann ...
		if(Game.CurrentMap.GetField(Char.PosX,(Char.PosY) - 1) == 1) {
			
			// Schauen wir erstmal ob unser Spieler auf einen Feind trifft
			Enemy eOnField = Enemys.GetEnemyOnThisField(Char.PosX, (Char.PosY - 1));
			if(eOnField != null) { // wenn ja ..
				eOnField.OnTouch(); // raisen wir die Funktion OnTouch und der Kamnpf beginnt!
			}
			
			// Es ging aber ums Bewegen, also setzen wir die Y Position des Spielers neu
			Char.PosY = Char.PosY - 1;
			
			// und fordern das JFrame auf neu zu zeichnen, und so nimmt alles seinen Lauf.
			// MapCanvas wird gezeichnet, Spieler Koordinate werden ermittelt und schon steht der
			// Spieler einen weiter oben
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
	}
	
	/**
	 * Wird aufgerufden wenn Spieler sich nach unten bewegen soll
	 */
	public static void MoveDown() {
		if(Game.CurrentMap.GetField(Char.PosX,(Char.PosY) + 1) == 1) {
			Enemy eOnField = Enemys.GetEnemyOnThisField(Char.PosX, (Char.PosY + 1));
			if(eOnField != null) {
				eOnField.OnTouch();
			}
			
			Char.PosY = Char.PosY + 1;
			
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
	}
	
	/**
	 * Wird aufgerufen wenn Spieler sich nach Links bewegen soll
	 */
	public static void MoveLeft() {
		if(Game.CurrentMap.GetField((Char.PosX) - 1,Char.PosY) == 1) {
			Enemy eOnField = Enemys.GetEnemyOnThisField((Char.PosX - 1), Char.PosY);
			if(eOnField != null) {
				eOnField.OnTouch();
			}
			
			Char.PosX = Char.PosX - 1;
			
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
		
	}
	
	/**
	 * Wird aufgerufen wenn Spieler sich nach rechts bewegen soll
	 */
	public static void MoveRight() {
		if(Game.CurrentMap.GetField((Char.PosX + 1), Char.PosY) == 1) {
			Enemy eOnField = Enemys.GetEnemyOnThisField((Char.PosX + 1), Char.PosY);
			if(eOnField != null) {
				eOnField.OnTouch();
			}
			
			Char.PosX = Char.PosX + 1;
			
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
	}
	
}
