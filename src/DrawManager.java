public class DrawManager {
	public static void DrawMap(Map m) {
		StdDraw.setCanvasSize(m.Size[0] * 32, m.Size[1] * 32);
		
		for(int y = 0; y < m.Size[1]; y++) {
			for(int x = 0; x < m.Size[0]; x++) {
				int field = m.GetField(x, y);
				System.out.println("X: " + x + ", Y: " + y + ", M: " + field);
				StdDraw.picture(32 * x, 32 * y, "images/" + String.valueOf(field) + ".jpg");
				break;
			}
			break;
		}
	}
}
