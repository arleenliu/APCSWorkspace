import java.util.ArrayList;

public class User {
	
	private int userId;
	
	// all movies rated by the user
	private ArrayList<Movie> movies;
	private ArrayList<Rating> ratings;
	private ArrayList<Tag> tags; // not sure if needed
	
	public User(int id) {
		userId = id;
		movies = new ArrayList<>();
		ratings = new ArrayList<>();
		tags = new ArrayList<>();
	}
	
	// comes after all addRating
	// can optimize later by first finding last instance of movie rated
	public void addMovie(ArrayList<Movie> movieData) {
		
		for (Movie m : movieData) {
			for (Rating r : ratings) {
				if (m.getMovieId() == r.getMovieId()) {
					movies.add(m);
				}
			}
		}
		
	}

	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	public int getUserId() {
		return userId;
	}
	
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	public double getRating(int movieID) {
		for (int i = 0; i < ratings.size(); i++) {
			if (ratings.get(i).getMovieId() == movieID) {
				return ratings.get(i).getRating();
			}
		}
		return -1;
	}
	
}
