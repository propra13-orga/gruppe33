public class Enemy {
	public int MapLevel;
	public int X;
	public int Y;
	
	public String Name;
	public int HP;
	public int EType;
	
	public Enemy(int EType, String Name, int posx, int posy, int hp, int MapLevel) {
		this.EType = EType;
		this.Name = Name;
		
		this.MapLevel = MapLevel;
		this.X = posx;
		this.Y = posy;
		this.HP = hp;
	}
	
	public void OnTouch() {
		Game.GameOver();
	}
}
