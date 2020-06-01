import java.util.ArrayList;
import java.util.Collections;

public class NetFlixPredictor {

	// Add fields to represent your database.
	private ArrayList<User> userData;
	private ArrayList<Movie> movieData;
	private ArrayList<Tag> tagData;
	private ArrayList<Rating> ratingData;
	private String[] allGenres = { "Action", "Adventure", "Animation", "Children", "Comedy", "Crime", "Documentary",
			"Drama", "Fantasy", "Film-Noir", "Horror", "IMAX", "Musical", "Mystery", "Romance", "Sci-Fi", "Thriller",
			"War", "Western" };
	private double[][] userGenreRatings = new double[671][18];

	/**
	 * 
	 * Use the file names to read all data into some local structures.
	 * 
	 * @param movieFilePath
	 *            The full path to the movies database.
	 * @param ratingFilePath
	 *            The full path to the ratings database.
	 * @param tagFilePath
	 *            The full path to the tags database.
	 * @param linkFilePath
	 *            The full path to the links database.
	 */
	public NetFlixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {
		ArrayList<String> movieStrings = FileIO.readFile(movieFilePath);
		ArrayList<String> ratingStrings = FileIO.readFile(ratingFilePath);
		ArrayList<String> tagStrings = FileIO.readFile(tagFilePath);
		ArrayList<String> linkStrings = FileIO.readFile(linkFilePath);

		movieStrings.remove(0);
		ratingStrings.remove(0);
		tagStrings.remove(0);
		linkStrings.remove(0);

		userData = new ArrayList<>();
		for (int i = 0; i < 671; i++) {
			userData.add(new User(i));
		}

		movieData = new ArrayList<>();
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		for (String s : movieStrings) {
			Movie m = translator.parseMovie(s);
			movieData.add(m);

			// for (int i = 0; i < userData.size(); i++) {
			// if (r.getUserId() == userData.get(i).getUserId()) {
			// userData.get(i).addRatings(r);
			// }
			// }
		}

		// Collections.sort(movieData);

		ratingData = new ArrayList<>();
		for (String s : ratingStrings) {
			Rating r = translator.parseRatings(s, movieData, userData);
			ratingData.add(r);

			for (int i = 0; i < userData.size(); i++) {
				if (r.getUserId() == userData.get(i).getUserId()) {
					userData.get(i).addRating(r);
				}
			}

			for (int i = 0; i < movieData.size(); i++) {
				if (r.getMovieId() == movieData.get(i).getMovieId()) {
					movieData.get(i).addRating(r);
				}
			}
		}

		tagData = new ArrayList<>();
		for (String s : tagStrings) {
			Tag t = translator.parseTags(s, movieData);
			tagData.add(t);

			int x = Collections.binarySearch(movieData, new Movie(t.getMovieId()));
			if (x >= 0) {
				movieData.get(x).addTag(t);
			} else {
				// not in list
			}
		}

		for (String s : linkStrings) {
			translator.parseLinks(s, movieData);
		}

		for (int i = 0; i < userData.size(); i++) {
			userData.get(i).addMovie(movieData);
		}
		
		for (int z = 0; z < userData.size(); z++) {
			ArrayList<Movie> ms = userData.get(z).getMovies();
			double[] ratingsPerGenre = new double[allGenres.length];
			int[] moviesPerGenre = new int[allGenres.length];

			for (int i = 0; i < ms.size(); i++) {
				double rate = getRating(userData.get(z).getUserId(), ms.get(i).getMovieId());
				if (ms.get(i).getGenres().length != 0) {
					for (int x = 0; x < ms.get(i).getGenres().length; x++) {
						for (int y = 0; y < allGenres.length; y++) {
							if (ms.get(i).getGenres()[x].equals(allGenres[y])) {
								ratingsPerGenre[y] += rate;
								moviesPerGenre[y]++;
							}
						}
					}
				}
			}

			for (int i = 0; i < ratingsPerGenre.length; i++) {
				if (moviesPerGenre[i] != 0) {
					ratingsPerGenre[i] = ratingsPerGenre[i] / moviesPerGenre[i];
				}
			}

			userGenreRatings[z] = ratingsPerGenre;
		}

	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber
	 *            The ID of the user.
	 * @param movieNumber
	 *            The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does
	 *         not exist in the database, the movie does not exist, or the movie has
	 *         not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {
		if (userID < 671 && userID >= 0) {
			return userData.get(userID).getRating(movieID);
		} else {
			return -1;
		}
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other
	 * available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber
	 *            The ID of the user.
	 * @param movieNumber
	 *            The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the
	 *         movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {

		Movie m = new Movie(movieID);
		User u = new User(userID);

		for (int i = 0; i < movieData.size(); i++) {
			if (movieData.get(i).getMovieId() == movieID) {
				m = movieData.get(i);
			}
		}

		m.calcAvgRating();

		for (int i = 0; i < userData.size(); i++) {
			if (userData.get(i).getUserId() == userID) {
				u = userData.get(i);
			}
		}

		double[] distFromUsers = new double[userData.size()];
		
		for (int i = 0; i < distFromUsers.length; i++) {
			distFromUsers[i] = calcDistance(userGenreRatings[i], userGenreRatings[u.getUserId() - 1]);
		}

//		boolean notFound = true;
//		
//		while (notFound) {
		for (int y = 0; y < distFromUsers.length - 1; y++) {
			int indexMin = 0;
			// double prevMin = 0;
			double currMin = Double.MAX_VALUE;

			for (int i = 0; i < distFromUsers.length; i++) {
				if (i != u.getUserId() - 1) {
					if (distFromUsers[i] < currMin) {
						currMin = distFromUsers[i];
						indexMin = i;
					}
				}
			}

			if (userData.get(indexMin).getMovies().indexOf(m) != -1) {
				System.out.println(getRating(userData.get(indexMin).getUserId(), m.getMovieId()));
				return getRating(userData.get(indexMin).getUserId(), m.getMovieId());
			} else {
				distFromUsers[indexMin] = Double.MAX_VALUE;
			}
		}

//		double avg = 0;

//		 for (int i = 0; i < m.getGenres().length; i++) {
//		 for (int x = 0; x < allGenres.length; x++) {
//		 if (m.getGenres()[i].equals(allGenres[x])) {
//		 avg += ratingsPerGenre[x];
//		 }
//		 }
//		 }

//		if (m.getGenres().length != 0) {
//			avg = avg / m.getGenres().length;
//		} else {
//			avg = m.getAvgRating();
//		}

		// System.out.println(avg);

		return m.getAvgRating();
	}

	/**
	 * Recommend a movie that you think this user would enjoy (but they have not
	 * currently rated it).
	 * 
	 * @param userNumber
	 *            The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but
	 *         they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {

		User u = new User(userID);
		
		for (int i = 0; i < userData.size(); i++) {
			if (userData.get(i).getUserId() == userID) {
				u = userData.get(i);
			}
		}

		double[] distFromUsers = new double[userData.size()];
		
		for (int i = 0; i < distFromUsers.length; i++) {
			distFromUsers[i] = calcDistance(userGenreRatings[i], userGenreRatings[u.getUserId() - 1]);
		}

//		boolean notFound = true;
//		
//		while (notFound) {
		for (int y = 0; y < distFromUsers.length - 1; y++) {
			int indexMin = 0;
			// double prevMin = 0;
			double currMin = Double.MAX_VALUE;

			for (int i = 0; i < distFromUsers.length; i++) {
				if (i != u.getUserId() - 1) {
					if (distFromUsers[i] < currMin) {
						currMin = distFromUsers[i];
						indexMin = i;
					}
				}
			}

			for (Movie m : userData.get(indexMin).getMovies()) {
				if (u.getMovies().indexOf(m) == -1) {
					return m.getMovieId();
				} else {
					distFromUsers[indexMin] = Double.MAX_VALUE;
				}
			}
			
		}
		
		return 1;
	}

	public ArrayList<Movie> getMovies() {
		return movieData;
	}

	public double calcDistance(double[] d1, double[] d2) {

		double squaredSum = 0;

		for (int i = 0; i < d1.length; i++) {
			squaredSum += (Math.pow(d2[i] - d1[i], 2));
		}

		return Math.sqrt(squaredSum);
	}
}
