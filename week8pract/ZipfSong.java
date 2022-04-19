// Kattis ID: zipfsong
// Kattis Best: , My Timing:

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class ZipfSong {
    public static void main(String arg[]) throws Exception {
        //Reading and writing classes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        // Main code
        String stats[] = br.readLine().split(" ");
        int numSongs = Integer.parseInt(stats[0]);
        int numChosen = Integer.parseInt(stats[1]);
        PriorityQueue<Song> pq = new PriorityQueue<Song>();

        // Parsing first song
        String firstSong[] = br.readLine().split(" ");
        int timesPlayed = Integer.parseInt(firstSong[0]);
        String songTitle = firstSong[1];
        pq.offer(new Song(1, 1, songTitle));

        // Parsing remaining songs
        for (int i = 2; i < numSongs+1; i++) {
            String song[] = br.readLine().split(" ");
            int played = Integer.parseInt(song[0]);
            pq.offer(new Song(i, played/(timesPlayed/i) ,song[1]));
        }

        // Printing out top few songs
        for (int i = 0; i < numChosen; i++) {
            pw.println(pq.poll().title);
        }
        pw.close();
    }
}

class Song implements Comparable<Song> {
    public int id;
    public double songQuality;
    public String title;

    Song(int id, double songQuality, String title) {
        this.id = id;
         this.songQuality = songQuality;
         this.title = title;
    }

    @Override
    public int compareTo(Song other) {
        if (this.songQuality == other.songQuality) {
            return this.id - other.id;
        } else {
            if (other.songQuality - this.songQuality < 0) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}