import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class DrawManager {
	public static JFrame window = new JFrame();
	public static void DrawMap(Map m) {
		window.getContentPane().removeAll();
		
		int width = m.Size[0];
		int height = m.Size[1] + 1;
		
		window.setBounds(30, 30, (width* 32) + 11, (height * 32) + 11);
		
		MapCanvas mc = new MapCanvas();
    	mc.MapToDraw = m;
    
    	window.getContentPane().add(mc);
    	window.setVisible(true);
    	
    	window.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_UP) {
					Char.MoveUp();
				}
				if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
					Char.MoveDown();
				}
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
					Char.MoveRight();
				}
				if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
					Char.MoveLeft();
				}
			}
		});
	}
	
	public static void DrawMenu() {
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
					case 1:
						Game.LoadMap(2);
						break;
					}
				}
				
				DrawManager.window.revalidate();
				DrawManager.window.repaint();
			}
		});
		
	}
}