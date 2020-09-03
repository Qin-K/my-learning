package ch16;

import java.util.*;
import java.io.*;

class Song5 {
	String title;
	String artist;
	String rating;
	String bpm;
	
	public Song5(String t, String a, String r, String b) {
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getRating() {
		return rating;
	}
	public String getBpm() {
		return bpm;
	}
	public String toString() {
		String result = title + ":" + artist;
		return result;
	}
}
public class Jukebox5 {

	ArrayList<Song5> songList = new ArrayList<Song5>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Jukebox5().go();
	}
	class ArtistCompare implements Comparator<Song5>{

		@Override
		public int compare(Song5 one, Song5 two) {
			// TODO Auto-generated method stub
			return one.getArtist().compareTo(two.getArtist());
		}
		
	}
	public void go() {
		getSongs();
		System.out.println(songList);
		
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList, artistCompare);
		System.out.println(songList);
	}
	void getSongs() {
		try {
			File file = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
			reader.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song5 nextSong = new Song5(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
	

}
