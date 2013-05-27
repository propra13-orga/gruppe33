/**
 * Die Klasse für die Feinde im Spiel
 * @author Gruppe33
 *
 */
public class Enemy {
	public int MapLevel;
	public int X;
	public int Y;
	
	public String Name;
	public int HP;
	public int EType;
	
	/**
	 * 
	 * @param EType Um welchen Gegner handelt es sich, siehe enemys/ Ordner
	 * @param Name Der Name des Gegners
	 * @param posx Die X Position des Gegners auf dem Feld
	 * @param posy Die Y Position des Gegner auf dem Feld
	 * @param hp Wieviel HP hat er zu Beginn
	 * @param MapLevel Auf welchen Level taucht er auf / befindet er sich gerade
	 */
	public Enemy(int EType, String Name, int posx, int posy, int hp, int MapLevel) {
		this.EType = EType;
		this.Name = Name;
		
		this.MapLevel = MapLevel;
		this.X = posx;
		this.Y = posy;
		this.HP = hp;
	}
	
	/**
	 * Wird aufgerufen wenn der Spieler den Gegner berührt
	 */
	public void OnTouch() {
		Game.GameOver();
	}
}
