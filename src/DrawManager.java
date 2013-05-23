import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class DrawManager {
	public static JFrame window;
	public static void DrawMap(Map m) {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int width = m.Size[0];
		int height = m.Size[1] + 1;
		
		window.setBounds(30, 30, (width* 32) + 11, (height * 32) + 11);
		
		MapCanvas mc = new MapCanvas();
    	mc.MapToDraw = m;
    
    	window.getContentPane().add(mc);
    	window.setVisible(true);
	}
	
	public static void DrawMenu() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuCanvas mc = new MenuCanvas();
		DrawManager.window.getContentPane().add(mc);
		DrawManager.window.setBounds(30, 30, 640, 480);
		DrawManager.window.setVisible(true);
		
		DrawManager.window.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP) {
					if(MenuCanvas.CurrentState == 1) {
						MenuCanvas.CurrentState = 4;
					}
					MenuCanvas.CurrentState--;
				}
				if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
					if(MenuCanvas.CurrentState == 3) {
						MenuCanvas.CurrentState = 0;
					}
					MenuCanvas.CurrentState++;
				}
				
				if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
					switch(MenuCanvas.CurrentState){
					
					}
				}
				
				DrawManager.window.revalidate();
				DrawManager.window.repaint();
			}
		});
		
	}
}