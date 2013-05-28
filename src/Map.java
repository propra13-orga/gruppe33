import java.io.*;

/**
 * Map Objekt, welches alle Informationen für eine Map enthält
 * @author Gruppe33
 *
 */
public class Map {
	public int Level;
	public String Name;
	
	public int[] Player_Start_Positions;
	public int[] Player_End_Positions;
	public int[][] Fields;
	public int[] Size;
	public String Filename;
	private String RawMapData;
	
	/**
	 * Konstruktor, initialisiert die Map und setzt die Felder entsprechend aus der Datei
	 * @param filename Der Pfad der zu lesenden .map Datei
	 * @throws IOException 
	 */
	public Map(String filename) throws IOException {
		this.Filename = filename;
		
		// Datei wird eingelesen
		FileReader freader = new FileReader(filename);
		BufferedReader breader = new BufferedReader(freader);
		
		this.RawMapData = breader.readLine();
		
		breader.close();
		freader.close();
		
		// Paramter sind durch , getrennt.
		String[] params = this.RawMapData.split(",");
		this.Level = Integer.parseInt(params[0]);
		this.Name = params[1];
		int[] getSize = {Integer.parseInt(params[2]), Integer.parseInt(params[3])};
		this.Size = getSize;
		
		// Auch wenn der Programmierer bei 0 anfängt zu zählen, sollte das bei den MapDateien nicht so sein.
		this.Fields = new int[this.Size[0] + 1][this.Size[1] + 1];
		// Eingänge des Spielers Map
		int[] playerstartpos = {Integer.parseInt(params[4]), Integer.parseInt(params[5])};
		this.Player_Start_Positions = playerstartpos;
		
		// Ausgänge des Spielers auf der Map
		int[] playerendpos = {Integer.parseInt(params[6]), Integer.parseInt(params[7])};
		this.Player_End_Positions = playerendpos;
		
		// Der letze Parameter sind die einzelnen Felder welche nochmal durch # getrennt werden
		String[] fieldsData = params[8].split("#");
		for(int i = 0; i < fieldsData.length; i++) {
			char[] fdata = fieldsData[i].toCharArray();
			int x = Integer.parseInt(String.valueOf(fdata[0]));
			int y = Integer.parseInt(String.valueOf(fdata[1]));
			int mode = Integer.parseInt(String.valueOf(fdata[2]));
			
			// Letztendlich setzen wir den Zustand des Feldes.
			this.Fields[x][y] = mode;
		}
	}
	
	/**
	 * Ruft den Zustand eines Feldes innerhalb der Map auf
	 * @param x X-Koordinate des Feldes
	 * @param y Y-Koordinate des Feldes
	 * @return Gibt den Zustand des Feldes als Ganzzahl zurück 
	 * (1: Begehbar, alles andere: Nicht begehbar)
	 */
	public int GetField(int x, int y) {
		// Existiert Feld überhaupt, wenn nicht wird das Feld auch nicht aus dem Array geholt
		if(!this.FieldExists(x, y)) {
			return 0; 
		}
		
		return this.Fields[x][y];
	}
	
	/**
	 * Prüft ob ein Feld ein gültiges Spielfeld ist
	 * @param x X-Koordinate des Feldes
	 * @param y Y-Koordinate des Feldes
	 * @return Gibt true zurück, wenn sich das Feld x,y auf Map m befindet.
	 */
	private Boolean FieldExists(int x, int y) {
		int width = this.Size[0] * 32;
		int height = this.Size[1] * 32;
		
		return x >= 0 && y >= 0 && x < width && y < height;
	}
}