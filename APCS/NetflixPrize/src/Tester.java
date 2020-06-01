import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		ArrayList<String> movieStrings = FileIO.readFile("data" + FileIO.fileSeparator + "movies.csv");
		
//		for (String s : movieStrings) {
//			System.out.println(s);
//		}
		
		movieStrings.remove(0);
		
		ArrayList<Movie> movieData = new ArrayList<>();
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		for (String s : movieStrings) {
			Movie m = translator.parseMovie(s);
			movieData.add(m);
		}
		
		for (Movie m : movieData) {
			System.out.println(m);
		}
	}
	
}
