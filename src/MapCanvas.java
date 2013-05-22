import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class MapCanvas extends JComponent {
	Map MapToDraw;
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    Image img1 = Toolkit.getDefaultToolkit().getImage("images/0.jpg");
	    g2.drawImage(img1, 10, 10, this);
	    g2.finalize();
	}
}
