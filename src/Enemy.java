import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Enemy {
	private String Filename;
	public ArrayList<int[]> Positions;
	
	public String Name;
	public int HP;
	public int EType;
	
	public Enemy(String filename) throws IOException {
		this.Positions = new ArrayList<int[]>();
		this.Filename = filename;
		
		FileReader freader = new FileReader(this.Filename);
		BufferedReader breader = new BufferedReader(freader);
		
		String rawData = breader.readLine();
		
		breader.close();
		freader.close();
		
		String[] params = rawData.split(",");
		this.EType = Integer.parseInt(params[0]);
		this.Name = params[1];
		this.HP = Integer.parseInt(params[2]);
		
		String[] positions = params[3].split("#");
		for(int i = 0; i < positions.length; i++) {
			String data = positions[i];
			char[] dchars = data.toCharArray();
			
			
			int[] pos = {Integer.parseInt(String.valueOf(dchars[0])), 
						Integer.parseInt(String.valueOf(dchars[1])), 
						Integer.parseInt(String.valueOf(dchars[2]))};
			this.Positions.add(pos);
			
		}
	}
	
	public Boolean IsEnemyField(int x, int y) {
		for(int i = 0; i < this.Positions.size(); i++) {
			if(x == this.Positions.get(i)[0] && y == this.Positions.get(i)[1]) {
				if(Game.CurrentLevel == this.Positions.get(i)[2]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void OnTouch() {
		Game.GameOver();
	}
}
