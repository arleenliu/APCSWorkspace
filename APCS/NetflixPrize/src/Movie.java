import java.util.ArrayList;

public class Movie implements Comparable<Movie> {
	private String title;
	private int movieId;
	private int year;
	private String[] genres;
	private String imdbId;
	private String tmdbId;
	private double avgRating;

	// private int avgRating;

	private ArrayList<User> users; // not sure if needed
	private ArrayList<Rating> ratings;
	private ArrayList<Tag> tags;

	public Movie(int id) {
		movieId = id;
	}

	public Movie(String title, int id, int yr, String[] genres) {
		this.title = title;
		movieId = id;
		year = yr;
		this.genres = genres;
		imdbId = "";
		tmdbId = "";

		users = new ArrayList<>();
		ratings = new ArrayList<>();
		tags = new ArrayList<>();

		avgRating = 0;

	}

	public int getMovieId() {
		return movieId;
	}

	public String[] getGenres() {
		return genres;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getImdbId() {
		return imdbId;
	}

	// called b4 getAvgRating
	public void calcAvgRating() {
		double sum = 0;

		if (ratings.size() > 0) {
			for (int i = 0; i < ratings.size(); i++) {
				sum += ratings.get(i).getRating();
			}
			avgRating = sum / ratings.size();
		} else {
			avgRating = 3;
		}
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setId(String imdbId, String tmdbId) {
		this.imdbId = imdbId;
		this.tmdbId = tmdbId;
	}

	public void addUser(User u) {
		users.add(u);
	}

	public void addRating(Rating r) {
		ratings.add(r);
	}

	public void addTag(Tag t) {
		tags.add(t);
	}

	public String toString() {
		String str = movieId + ", " + title + " (" + year + "), ";

		for (String genre : genres) {
			str += genre;
			str += " | ";
		}
		str = str.substring(0, str.length() - 3);

		return str;
	}

	public int compareTo(Movie arg0) {
		// TODO Auto-generated method stub
		/*
		 * if (movieId > arg0.movieId) { return 1; } else if (movieId < arg0.movieId) {
		 * return -1; } else { return 0; }
		 */
		return movieId - arg0.movieId;
	}

}
