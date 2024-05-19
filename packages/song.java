package java_player.packages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class song {
    private String name;
    private String artist;
    private long duration;
    public song (String path){
        String can_path = ".";
        try {
            can_path = new File(".").getCanonicalPath();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (Scanner scanner = new Scanner(new File(can_path + path))) {
            name = scanner.nextLine();
            artist = scanner.nextLine();
            duration = Long.parseLong(scanner.nextLine());
        }
        catch (FileNotFoundException e) {
            System.out.println(can_path + path + " not found in" + this.getClass());
        }
    }
    public String get_name() {return name;}
    public String get_artist() {return artist;}
    public long get_duration() {return duration;}
    public void out() {
        System.out.println(name + " " + artist + " " + duration + " sec");
    }
    public void save_song(String path) {
        String currentPath = "";
        try {
            currentPath = new File(".").getCanonicalPath();
        }
        catch (IOException e) {
            System.out.println(e.getMessage() + ": error in " + e.getClass());
        }
        File targetFile = new File(currentPath + path);
        targetFile.delete();
        Path newFilePath = Paths.get(currentPath + path);
        try {
            Files.createFile(newFilePath);
        }
        catch (IOException e) {
            System.out.println("Wrong path: " + path + " in class" + this.getClass());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentPath + path))) {
            writer.write(name + "\n");
            writer.write(artist + "\n");
            writer.write(duration + "\n");
        }
        catch(IOException e) {
            System.out.println(path + " not found" + this.getClass());
        }
    }
    public boolean equals(song song) {
        if (song == null) return false;
        return name.equals(song.name) && artist.equals(song.artist) && duration == song.duration;
    }
}
