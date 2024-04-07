package packages;
import java.io.File;
import java.util.ArrayList;

public class albom {
    private ArrayList<song> songs;
    private int cur_song;
    private final String name;
    // create file with paths to songs
    public albom (String name_playlist) {
        name = name_playlist;
        songs = new ArrayList<>();
        cur_song = 0;
    }
    public song set_cur_song(int i) {
        i--;
        cur_song = i;
        if (i >= songs.size()) {
            System.out.println("Wrong num");
            return null;
        }
        else return songs.get(i);
    }

    public song get_cur_song() {
        if (songs.size() == 0) return null;
        return songs.get(cur_song);
    }

    public song next_song() {
        if (cur_song + 1 < songs.size()) cur_song++;
        else cur_song = 0;
        if (songs.size() == 0) return null;
        return songs.get(cur_song);
    }
    public song previous_song() {
        if (cur_song - 1 >= 0) cur_song--;
        else cur_song = songs.size()-1;
        if (songs.size() == 0) return null;
        return songs.get(cur_song);
    }
    public String get_name() {return name;}

    public void out() {
        System.out.println(name);
        for (int i=0;i<songs.size();i++) {
            songs.get(i).out();
        }
    }
    public void remove_song(int index) {
        index--;
        if (index >= 0 && index < songs.size() ) {
            songs.remove(index);
            if (cur_song == songs.size()) cur_song--;
        }
        else {
            System.out.println("can't remove unreal song");
        }
    }
    public void remove_song(String name) {
        for (int i=0;i<songs.size();i++) {
            if (songs.get(i).get_name().equals(name)) {
                songs.remove(i);
                if (cur_song == songs.size()) cur_song--;
                break;
            }
        }
    }

    public void add_song(String path, int index) {
        if (index > songs.size()) index = songs.size();
        songs.add(index, new song(path));
    }

    public void add_song(String path) {
        songs.add(new song(path));
    }
    public void add_song(song _song) {
        if (_song != null && _song.get_name() != null)  songs.add(_song);
        else System.out.println("song is unreal");
    }
    public song[] get_songs() {
        song[] _songs = new song[songs.size()];
        songs.toArray(_songs);
        return _songs;

    }
    // didn't work
    public void save_albom() {
        File theDir = new File("/music/" + name);
        if (!theDir.exists()) {theDir.mkdir();System.out.println("asd");}
        for (int i=0;i<songs.size();i++) {
            songs.get(i).save_song("/music/" + name + "/\"" + songs.get(i).get_name() + "\".mp3");
        }

    }
}
// equals, hashcode