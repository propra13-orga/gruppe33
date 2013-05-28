import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

/**
 * Auf dieses Feld wird die Map draufgezeichnet
 * (Wird ersetzt durch performanteres)
 * @author Gruppe33
 *
 */
public class MapCanvas extends JComponent {
	Map MapToDraw;
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // Wir laufen einmal durch alle Felder auf der Map
	    for(int y = 0; y <= this.MapToDraw.Size[1] - 1; y++) {
			for(int x = 0; x <= this.MapToDraw.Size[0] - 1; x++) {
				int zustand = this.MapToDraw.GetField(x, y);
				
				// Das Bild wird geladen, je nach Zustand (0, 1, 2) wird auch die Datei geladen
				// (0.jpg / 1.jpg / 2.jpg)
				Image img1 = Toolkit.getDefaultToolkit().getImage("images/" + String.valueOf(zustand) + ".jpg");
				g2.drawImage(img1, x * 32, y * 32, this);
			    g2.finalize();
			    
			    // Prüft ob es auf dem Feld einen Gegner gibt, wenn ja ...
			    Enemy eOnField = Enemys.GetEnemyOnThisField(x, y);
			    if(eOnField != null){
			    	
			    	// ... zeichnen wir diesen natürlich auch aufs die Map
			    	Image enemyImg = Toolkit.getDefaultToolkit().getImage("images/Enemy" + eOnField.EType + ".png");
			    	g2.drawImage(enemyImg, x * 32, y * 32, this);
			    	g2.finalize();
			    }
			}
		}
	    
	    if(Game.Goal[2] == Game.CurrentLevel) {
	    	Image imgGoal = Toolkit.getDefaultToolkit().getImage("images/goal.png");
		    g2.drawImage(imgGoal, Game.Goal[0] * 32, Game.Goal[1] * 32, this);
		    g2.finalize();
	    }
	    
	    // und was niemals fehlen dürfte, wäre zu guter letzt der Spieler.
	    Image imgChar = Toolkit.getDefaultToolkit().getImage("images/char.png");
	    g2.drawImage(imgChar, Char.PosX * 32, Char.PosY * 32, this);
	    g2.finalize();
	}
}
