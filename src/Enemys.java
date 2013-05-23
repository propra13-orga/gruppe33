import java.io.File;
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
			
			Enemy newEnemy = new Enemy(enFile);
			Enemys.EnemyList.add(newEnemy);
		}
	}
	
	public static int isEnemy(int x, int y, int MapLevel) {
		for(int i = 0; i < Enemys.EnemyList.size(); i++) {
			if(Enemys.EnemyList.get(i).IsEnemyField(x, y)) {
				return Enemys.EnemyList.get(i).EType;
			}
		}
		
		return 0;
	}
}
