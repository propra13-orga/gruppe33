import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class MapCanvas extends JComponent {
	Map MapToDraw;
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    
	    for(int y = 0; y <= this.MapToDraw.Size[1]; y++) {
			for(int x = 0; x <= this.MapToDraw.Size[0]; x++) {
				int zustand = this.MapToDraw.GetField(x, y);
				
				Image img1 = Toolkit.getDefaultToolkit().getImage("images/" + String.valueOf(zustand) + ".jpg");
				g2.drawImage(img1, x * 32, y * 32, this);
			    g2.finalize();
			}
		}
	}
}
