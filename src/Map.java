import java.io.*;

public class Map {
	public int Level;
	public String Name;
	
	public int[] Player_Start_Positions;
	public int[] Player_End_Positions;
	public int[][] Fields;
	public int[] Size;
	public String Filename;
	private String RawMapData;
	
	
	public Map(String filename) throws IOException {
		this.Filename = filename;
		
		FileReader freader = new FileReader(filename);
		BufferedReader breader = new BufferedReader(freader);
		
		this.RawMapData = breader.readLine();
		
		breader.close();
		freader.close();
		
		String[] params = this.RawMapData.split(",");
		this.Level = Integer.parseInt(params[0]);
		this.Name = params[1];
		int[] getSize = {Integer.parseInt(params[2]), Integer.parseInt(params[3])};
		this.Size = getSize;
		
		// Auch wenn der Programmierer bei 0 anfängt zu zählen, sollte das bei den MapDateien nicht so sein.
		this.Fields = new int[this.Size[0] + 1][this.Size[1] + 1];
		int[] playerstartpos = {Integer.parseInt(params[4]), Integer.parseInt(params[5])};
		this.Player_Start_Positions = playerstartpos;
		
		int[] playerendpos = {Integer.parseInt(params[6]), Integer.parseInt(params[7])};
		this.Player_End_Positions = playerendpos;
		
		String[] fieldsData = params[8].split("#");
		for(int i = 0; i < fieldsData.length; i++) {
			char[] fdata = fieldsData[i].toCharArray();
			int x = Integer.parseInt(String.valueOf(fdata[0]));
			int y = Integer.parseInt(String.valueOf(fdata[1]));
			int mode = Integer.parseInt(String.valueOf(fdata[2]));
			
			this.Fields[x][y] = mode;
		}
	}
	
	public int GetField(int x, int y) {
		return this.Fields[x][y];
	}
}