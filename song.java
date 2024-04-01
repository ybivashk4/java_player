package java_player;

import java.io.File;
import java.io.FileNotFoundException;
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
            System.out.println(path + " not found" + this.getClass());
            /*name = "";
            artist = "";
            duration = -1;*/
        }
    }
    public String get_name() {return name;}
    public String get_artist() {return artist;}
    public long get_duration() {return duration;}
    public void out() {
        System.out.println(name);
        System.out.println(artist);
        System.out.println(duration);
    }

}
