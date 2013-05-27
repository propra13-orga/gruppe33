import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Der Manager für die Gegner im Spiel
 * @author Gruppe33
 *
 */
public class Enemys {
	public static ArrayList<Enemy> EnemyList;
	
	/**
	 * Lädt alle Gegner für das Spiel aus einem Ordner
	 * @param dir Der Pfad des Orders mit den .enemy Dateien
	 * @throws IOException
	 */
	public static void LoadEnemeys(String dir) throws IOException {
		Enemys.EnemyList = new ArrayList<Enemy>();
		
		// Wir lesen den Ordner ein
		File getDir = new File(dir);
		File[] enDir = getDir.listFiles();
		
		// gehen alle Dateien durch im Ordner
		for(int i = 0; i < enDir.length; i++) {
			String enFile = enDir[i].getAbsolutePath();
			
			// und laden unsere Enemys und speichern die in unser Array
			ArrayList<Enemy> listToAdd = Enemys.GetEnemysFromOneType(enFile);
			Enemys.EnemyList.addAll(listToAdd);
		}
	}
	
	/**
	 * Gibt den Gegner der sich auf einem Feld befindet zurück, ansonsten null, wenn kein Gegner
	 * da ist
	 * @param x Die X-Koordinate auf dem Feld
	 * @param y Die Y-Koordinate auf dem Feld
	 * @return Gibt ein Enemy Objekt zurück
	 */
	public static Enemy GetEnemyOnThisField(int x, int y) {
		for(int i = 0; i < Enemys.EnemyList.size(); i++) {
			if(Enemys.EnemyList.get(i).X == x && Enemys.EnemyList.get(i).Y == y
					&& Enemys.EnemyList.get(i).MapLevel == Game.CurrentLevel) {
				return Enemys.EnemyList.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * Holt sich aus einer Datei alle Gegner eines Typs und gibt diese in einer ArrayList zurück
	 * @param filename Der Pfad der .enemy Datei
	 * @return Eine ArrayList mit Enemy Objekten für jeden Gegner von einem bestimmtne Typ
	 * @throws IOException
	 */
	private static ArrayList<Enemy> GetEnemysFromOneType(String filename) throws IOException {
		ArrayList<Enemy> listToReturn = new ArrayList<Enemy>();
		
		// Datei wird gelesen
		FileReader freader = new FileReader(filename);
		BufferedReader breader = new BufferedReader(freader);
		
		String rawData = breader.readLine();
		
		breader.close();
		freader.close();
		
		// Datei enthält Parameter getrennt mit einem ,
		String[] params = rawData.split(",");
		int EType = Integer.parseInt(params[0]);
		String Name = params[1];
		int HP = Integer.parseInt(params[2]);
		
		// Alle Positionen (XY und Level) des Gegners mit einem # getrennt
		String[] positions = params[3].split("#");
		for(int i = 0; i < positions.length; i++) {
			String data = positions[i];
			char[] dchars = data.toCharArray();
			
			int[] pos = {Integer.parseInt(String.valueOf(dchars[0])), 
						Integer.parseInt(String.valueOf(dchars[1])), 
						Integer.parseInt(String.valueOf(dchars[2]))};
			
			// ... und wir haben hier den Gegner geladen, gerüstet und darf nun in die Liste
			listToReturn.add(new Enemy(EType, Name, pos[0], pos[1], HP, pos[2]));
		}
		
		return listToReturn;
	}
}
