import java.io.IOException;

public class Game {
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir") + "\\maps");
		Maps.LoadMapList(3, System.getProperty("user.dir") + "\\maps");
	}
}