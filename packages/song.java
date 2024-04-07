package packages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class song {
    private String name;
    private String artist;
    private long duration;
    public song (String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            name = scanner.nextLine();
            artist = scanner.nextLine();
            duration = Long.parseLong(scanner.nextLine());
        }
        catch (FileNotFoundException e) {
            System.out.println(path + " not found " + this.getClass());
        }
    }
    public String get_name() {return name;}
    public String get_artist() {return artist;}
    public long get_duration() {return duration;}
    public void out() {
        System.out.println(name + " " + artist + " " + duration + " sec");
    }
    public void save_song(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(name + "\n");
            writer.write(artist + "\n");
            writer.write(duration + "\n");
        }
        catch(IOException e) {
            System.out.println(path + " not found" + this.getClass());
        }
    }
}
