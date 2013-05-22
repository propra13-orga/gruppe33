import javax.swing.JFrame;

public class DrawManager {
  public static void DrawMap(Map m) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    
    MapCanvas mc = new MapCanvas();
    mc.MapToDraw = m;
    
    window.getContentPane().add(mc);
    window.setVisible(true);
  }
}