public class Enemy {
	public int X;
	public int Y;
	public int EnemyType;
	
	public Enemy(int posx, int posy, int et) {
		this.X = posx;
		this.Y = posy;
		this.EnemyType = et;
	}
	
	public void OnTouch() {
		// TODO: Initialisiere Kampf
		Game.GameOver();
	}
}
