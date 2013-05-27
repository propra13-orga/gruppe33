import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Manager für die ganzen Maps
 * @author Gruppe33
 *
 */
public class Maps {
	public static ArrayList<Map> MapList;
	
	/**
	 * Initialisiert für jede Datei im Ordner ein Map Objekt und fügt es zur MapList hinzu
	 * @param dir Der Pfad des Ordners indem sich die Map Dateien befinden
	 * @throws IOException
	 */
	public static void LoadMapList(String dir) throws IOException {
		Maps.MapList = new ArrayList<Map>();
		
		// Wir saugen uns den ganzen Ordner
		File getDir = new File(dir);
		File[] mapDir = getDir.listFiles();
		
		// und laufen durch jede einzelne Datei
		for(int i = 0; i < mapDir.length; i++) {
			String mapFile = mapDir[i].getAbsolutePath();
			
			// und initialisieren von ihr dann ein Map Objekt
			Map newMap = new Map(mapFile);
			Maps.MapList.add(newMap);
		}
		
		// ... und am Ende wollen wir wissen, wieviele Maps hat das Ding jetzt?
		System.out.println(Integer.toString(Maps.MapList.size()) + " Maps geladen");
	}
	
	/**
	 * Gibt die Map mit einem bestimmten Level zurück, ansonsten null.
	 * @param Level Das Level, welches geladen werden soll
	 * @return Liefert ein Map Objekt mit dem jeweiligen Level
	 */
	public static Map GetMap(int Level) {
		for(int i = 0; i < Maps.MapList.size(); i++) {
			if(Maps.MapList.get(i).Level == Level) {
				return Maps.MapList.get(i);
			}
		}
		
		return null;
	}
}
