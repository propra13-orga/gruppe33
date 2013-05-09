import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Maps {
	public static ArrayList<Map> MapList;
	
	public static void LoadMapList(int MaxMaps, String dir) throws IOException {
		Maps.MapList = new ArrayList<Map>();
		
		File getDir = new File(dir);
		File[] mapDir = getDir.listFiles();
		
		for(int i = 0; i < mapDir.length; i++) {
			String mapFile = mapDir[i].getAbsolutePath();
			
			Map newMap = new Map(mapFile);
			Maps.MapList.add(newMap);
		}
		
		// ... und am Ende wollen wir wissen, wieviele Maps hat das Ding jetzt?
		System.out.println(Integer.toString(Maps.MapList.size()) + " Maps geladen");
	}
}
