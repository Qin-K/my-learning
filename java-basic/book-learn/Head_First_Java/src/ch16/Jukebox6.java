package ch16;

import java.util.*;
import java.io.*;

public class Jukebox6 {

	ArrayList<Song> SongList = new ArrayList<Song>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Jukebox6().go();
	}
	public void go() {
		getSongs();
		System.out.println(SongList);
		Collections.sort(SongList);
		System.out.println(SongList);
	//	HashSet<Song> songSet = new HashSet<Song>();
	//  songSet.addAll(SongList);
		TreeSet<Song> songSet = new TreeSet<Song>();
		songSet.addAll(SongList);
		System.out.println(songSet);
	}
	void getSongs() {
		try {
			File file = new File("SongListMore.txt");
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
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		SongList.add(nextSong);
	}

}
