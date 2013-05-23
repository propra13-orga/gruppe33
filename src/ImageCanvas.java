import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class ImageCanvas extends JComponent {
	public String filename;
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    
	    Image img = Toolkit.getDefaultToolkit().getImage(this.filename);
	    g2.drawImage(img, 0, 0, this);
	    g2.finalize();
	}
}
