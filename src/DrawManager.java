import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawManager {
	public static JFrame window;
	public static void DrawMap(Map m) {
		DrawManager.window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int width = m.Size[0];
		int height = m.Size[1] + 1;
		
		window.setBounds(30, 30, (width* 32) + 11, (height * 32) + 11);
		
		
		MapCanvas mc = new MapCanvas();
    	mc.MapToDraw = m;
    
    	window.getContentPane().add(mc);
    	window.setVisible(true);
	}
}