import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

/**
 * Auf dieses Canvas wird das Menü gezeichnet
 * @author Gruppe33
 *
 */
public class MenuCanvas extends JComponent {
	// Steht für das Feld auf den der Zeiger gerade zeigt
	public static int CurrentState = 1;
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // DRAW MENU SCREEN
	    Image img = Toolkit.getDefaultToolkit().getImage("images/startmenu.jpg");
	    g2.drawImage(img, 0, 0, this);
	    g2.finalize();
	    
	    // DRAW POINTER
	    Image pimg = Toolkit.getDefaultToolkit().getImage("images/pointer.png");
	    g2.drawImage(pimg, 124, 198 + (60 * MenuCanvas.CurrentState), this);
	    g2.finalize();
	}
}
