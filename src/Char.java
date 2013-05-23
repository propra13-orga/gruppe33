
public class Char {
	public static int PosX;
	public static int PosY;
	
	public static void MoveUp() {
		if(Game.CurrentMap.GetField(Char.PosX,(Char.PosY) - 1) == 1) {
			Char.PosY = Char.PosY - 1;
			
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
	}
	
	public static void MoveDown() {
		if(Game.CurrentMap.GetField(Char.PosX,(Char.PosY) + 1) == 1) {
			Char.PosY = Char.PosY + 1;
			
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
	}
	
	public static void MoveLeft() {
		if(Game.CurrentMap.GetField((Char.PosX) - 1,Char.PosY) == 1) {
			Char.PosX = Char.PosX - 1;
			
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
		
	}
	
	public static void MoveRight() {
		if(Game.CurrentMap.GetField((Char.PosX) + 1, Char.PosY) == 1) {
			Char.PosX = Char.PosX + 1;
			
			DrawManager.window.revalidate();
			DrawManager.window.repaint();
		}
	}
}
