
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;

	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}

	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
			if (coverArt != null) {
				drawer.image(coverArt, x, y, width, height);
			}
		}

		if (movie != null) {
			String title = movie.getTitle();

			drawer.text(title, x, y);
		}

		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}

	public void downloadArt(PApplet drawer) {

		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {

				Scanner scan = null;

				try {

					String imdbId = movie.getImdbId();

					String pageURLString = "http://www.imdb.com/title/tt" + imdbId + "/";

					URL pageURL = new URL(pageURLString);
					InputStream is = pageURL.openStream();
					scan = new Scanner(is);

					String fileData = "";
					while (scan.hasNextLine()) {
						String line = scan.nextLine();
						fileData += line + FileIO.lineSeparator;
					}

					// Some file parsing (using indexOf)
					// substring to get out the url

					String sectionToSearch = fileData.substring(fileData.indexOf("slate_wrapper"),
							fileData.indexOf("<div class=\"slate\">"));
					
					System.out.println(sectionToSearch);
					
					String temp = sectionToSearch.substring(sectionToSearch.indexOf("src=\"") + 5);

					String url = temp.substring(0, temp.indexOf('"'));

					System.out.println(url);

					// Find the cover art using IMDB links
					// Initialize coverArt

					coverArt = drawer.loadImage(url);

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (scan != null) {
						scan.close();
					}
				}

			}

		});

		downloader.start();

	}

}
