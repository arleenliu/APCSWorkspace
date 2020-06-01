
public class Tag {
	private int userId;
	private int movieId;
	private String tag;
	private int timestamp;
	
	public Tag (int userId, int movieId, String tag, int timestamp) {
		this.userId = userId;
		this.movieId = movieId;
		this.tag = tag;
		this.timestamp = timestamp;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getMovieId() {
		return movieId;
	}
}
