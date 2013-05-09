import java.io.File;
import java.util.ArrayList;

public class Maps {
	public static ArrayList<Map> MapList;
	
	public static void LoadMapList(int MaxMaps, String dir) {
		Maps.MapList = new ArrayList<Map>();
		
		File getDir = new File(dir);
		File[] mapDir = getDir.listFiles();
		
		for(int i = 0; i <= mapDir.length; i++) {
			String mapFile = mapDir[i].getAbsolutePath();
			
			Map newMap = new Map(mapFile);
			Maps.MapList.add(newMap);
		}
		
		int x = 3;
		
		System.out.println("Maps geladen");
	}
}
