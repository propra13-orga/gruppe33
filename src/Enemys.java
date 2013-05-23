import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Enemys {
	public static ArrayList<Enemy> EnemyList;
	
	public static void LoadEnemeys(String dir) throws IOException {
		Enemys.EnemyList = new ArrayList<Enemy>();
		
		File getDir = new File(dir);
		File[] enDir = getDir.listFiles();
		
		for(int i = 0; i < enDir.length; i++) {
			String enFile = enDir[i].getAbsolutePath();
			
			ArrayList<Enemy> listToAdd = Enemys.GetEnemysFromOneType(enFile);
			Enemys.EnemyList.addAll(listToAdd);
		}
	}
	
	public static Enemy GetEnemyOnThisField(int x, int y) {
		for(int i = 0; i < Enemys.EnemyList.size(); i++) {
			if(Enemys.EnemyList.get(i).X == x && Enemys.EnemyList.get(i).Y == y
					&& Enemys.EnemyList.get(i).MapLevel == Game.CurrentLevel) {
				return Enemys.EnemyList.get(i);
			}
		}
		
		return null;
	}
	
	private static ArrayList<Enemy> GetEnemysFromOneType(String filename) throws IOException {
		ArrayList<Enemy> listToReturn = new ArrayList<Enemy>();
		
		FileReader freader = new FileReader(filename);
		BufferedReader breader = new BufferedReader(freader);
		
		String rawData = breader.readLine();
		
		breader.close();
		freader.close();
		
		String[] params = rawData.split(",");
		int EType = Integer.parseInt(params[0]);
		String Name = params[1];
		int HP = Integer.parseInt(params[2]);
		
		String[] positions = params[3].split("#");
		for(int i = 0; i < positions.length; i++) {
			String data = positions[i];
			char[] dchars = data.toCharArray();
			
			int[] pos = {Integer.parseInt(String.valueOf(dchars[0])), 
						Integer.parseInt(String.valueOf(dchars[1])), 
						Integer.parseInt(String.valueOf(dchars[2]))};
			
			listToReturn.add(new Enemy(EType, Name, pos[0], pos[1], HP, pos[2]));
		}
		
		return listToReturn;
	}
}
