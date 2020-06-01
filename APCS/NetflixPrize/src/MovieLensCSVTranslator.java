import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieLensCSVTranslator {

	// make user class, have arraylist of movies, ratings
	// put arraylist of movies, ratings in movie class

	public Movie parseMovie(String line) {
		// Go through line, extract pieces of data
		// look for commas (in general)

		Matcher m;

		String idString = line.substring(0, line.indexOf(","));
		String middle = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
		String genreString = line.substring(line.lastIndexOf(",") + 1);

		int movieId = Integer.parseInt(idString);
		String[] genres = genreString.split("\\|");
		int year = 0;
		String title = "";

		// if (middle.lastIndexOf("(") != -1) {
		// if (middle.substring(middle.lastIndexOf("(") + 1,
		// middle.lastIndexOf(")")).indexOf("[0-9]") != -1) {
		// year = Integer.parseInt(middle.substring(middle.lastIndexOf("(") + 1,
		// middle.lastIndexOf(")")));
		// title = middle.substring(0, middle.lastIndexOf("("));
		// }
		//
		// }

		int yearStart = middle.lastIndexOf("(");

		if (yearStart != -1
				&& Pattern.matches("[0-9][0-9][0-9][0-9]", middle.substring(yearStart + 1, yearStart + 5))) {
			year = Integer.parseInt(middle.substring(yearStart + 1, yearStart + 5));
			title = middle.substring(0, yearStart);
		} else {
			title = middle;
		}

		return new Movie(title, movieId, year, genres);
		// Create new Movie object

		// return Movie
	}

	public Tag parseTags(String line, ArrayList<Movie> movieData) {
		int userId = Integer.parseInt(line.substring(0, line.indexOf(",")));
		String newLine = line.substring(line.indexOf(",") + 1);
		int movieId = Integer.parseInt(newLine.substring(0, newLine.indexOf(",")));
		String tag = newLine.substring(newLine.indexOf(",") + 1, newLine.lastIndexOf(","));
		int timeStamp = Integer.parseInt(newLine.substring(newLine.lastIndexOf(",") + 1));

		Tag t = new Tag(userId, movieId, tag, timeStamp);

		for (int i = 0; i < movieData.size(); i++) {
			if (movieData.get(i).getMovieId() == movieId) {
				movieData.get(i).addTag(t);
				break;
			}
		}

		return t;
	}

	public void parseLinks(String line, ArrayList<Movie> movieData) {
		int movieId = Integer.parseInt(line.substring(0, line.indexOf(",")));
		String imdbId = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
		String tmdbId = line.substring(line.lastIndexOf(",") + 1);

		for (int i = 0; i < movieData.size(); i++) {
			if (movieData.get(i).getMovieId() == movieId) {
				movieData.get(i).setId(imdbId, tmdbId);
				break;
			}
		}

	}

	public Rating parseRatings(String line, ArrayList<Movie> movieData, ArrayList<User> userData) {
		int userId = Integer.parseInt(line.substring(0, line.indexOf(",")));
		String newLine = line.substring(line.indexOf(",") + 1);
		int movieId = Integer.parseInt(newLine.substring(0, newLine.indexOf(",")));
		String newLine2 = newLine.substring(newLine.indexOf(",") + 1);
		double rating = Double.parseDouble(newLine2.substring(0, newLine2.indexOf(",")));
		int timestamp = Integer.parseInt(newLine2.substring(newLine2.lastIndexOf(",") + 1));

		Rating r = new Rating(userId, movieId, rating, timestamp);

		return r;
	}

}
