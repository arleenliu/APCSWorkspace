
public class Rating implements Comparable<Rating> {
	private int userId;
	private int movieId;
	private double rating;
	private int timestamp;
	
	public Rating(int userId, int movieId) {
		this.userId = userId;
		this.movieId = movieId;
	}
	
	public Rating(int userId, int movieId, double rating, int timestamp) {
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
		this.timestamp = timestamp;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public double getRating() {
		return rating;
	}

	@Override
	public int compareTo(Rating o) {
		if (userId > o.userId) {
			return 1;
		} else if (userId < o.userId) {
			return -1;
		} else {
			if (movieId > o.movieId) {
				return 1;
			} else if (movieId < o.movieId) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
