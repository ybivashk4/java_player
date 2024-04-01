package java_player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class song {
    private final String name;
    private final String artist;
    private final long duration;
    public song (String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            int i=0;
            name = scanner.nextLine();
            artist = scanner.nextLine();
            duration = Long.parseLong(scanner.nextLine());
        }
        catch (FileNotFoundException e) {
            System.out.println(path + " not found");
            /*name = "";
            artist = "";
            duration = -1;*/
        }
    }

}
