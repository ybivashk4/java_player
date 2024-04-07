import java.util.Scanner;

import packages.*;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static player my_player = new player();
    public static void main(String [] args) {
        
        out_menu();
        int option = scanner.nextInt();
        while (option != 0) {
            switch (option) { 
                case 0:
                    break;
                case 1:
                    my_player.out_songs();
                    out_menu();
                    break;
                case 2:
                    add_albom();
                    break;
                case 3:
                    my_player.set_cur_albom(pick_albom());
                    break;
                case 4:
                    my_player.get_cur_albom().save_albom();
                    break;
                case 5:
                    System.out.println("Enter index of albom");
                    int ind = scanner.nextInt();
                    my_player.remove_albom(ind);
                    break;
                case 6:
                    albom _albom = pick_albom();
                    song [] songs = pick_songs();
                    for (int i=0;i<songs.length;i++)
                        _albom.add_song(songs[i]);
                    break;
                case 7:
                    my_player.get_cur_albom().out();
                    break;
                case 8:
                    System.out.println("Enter index of song to remove");
                    int _ind = scanner.nextInt();
                    my_player.get_cur_albom().remove_song(_ind);
                    break;
                case 9:
                    my_player.get_cur_albom().previous_song();
                    break;
                case 10:
                    my_player.get_cur_albom().next_song();
                    break; 
                case 11:
                    my_player.get_cur_albom().get_cur_song();
                    break;
                case 12:
                    my_player.out_alboms();
                    break;
            }
            out_menu();
            option = scanner.nextInt();
        }
        scanner.close();

    }
    private static void out_menu() {
        System.out.println("0. Exit");
        System.out.println("1. Out songs");
        System.out.println("2. Create albom");
        System.out.println("3. On albom");
        System.out.println("4. save albom");
        System.out.println("5. Remove albom");
        System.out.println("6. Add song");
        System.out.println("7. out cur albom");
        System.out.println("8. Remove song");
        System.out.println("9. Next song");
        System.out.println("10. Previous song");
        System.out.println("11. Repeat song");
        System.out.println("12. Out alboms");
        
    }
    private static void add_albom() { 
        System.out.println("Enter name of albom");
        String name = scanner.next();
        System.out.println("if you want to chose index of albom input non 0 integer value");
        int index = scanner.nextInt();
        if (index != 0) {
            my_player.add_albom(new albom(name), index);
        }
        else {
            my_player.add_albom(name);
        }
        System.out.print("\033[H\033[J");
        out_menu();
    }
    private static song[] pick_songs() { 
        System.out.println("if you want Enter name of song to add input 0, if you want to chose index of song input 1, if you want add all artist's songs input 2");
        int menu = scanner.nextInt();
        song[] songs = new song[1];
        switch (menu) {
            case 0:
                String name = scanner.next();
                songs[0] = my_player.get_song(name);
                return songs;
            case 1:
                int ind = scanner.nextInt();
                songs[0] = my_player.get_song(ind);
                return songs;
            case 2:
                String aString = scanner.next();
                return my_player.get_songs(aString);
            default:
                System.out.println("Wrong input");
                return null;
        }
    }
    private static albom pick_albom() { 
        System.out.println("if you want Enter name of albom input 0, if you want to chose index of albom input 1");
        int menu = scanner.nextInt();
        switch (menu) {
            case 0:
                String name = scanner.next();
                return my_player.get_albom(name);
            case 1:
                int ind = scanner.nextInt();
                return my_player.get_albom(ind);
            default:
                System.out.println("Wrong input");
                return null;
        }
    }
}
