package packages;

import java.util.ArrayList;

public class player {
    private ArrayList<albom> alboms;
    private int cur_albom;
    private ArrayList<song> songs;
    public player() { 
        alboms = new ArrayList<>();
        cur_albom = 0;
    }
    public void set_cur_albom(int i) { 
        i--;
        if (i >= alboms.size())
            System.out.println("Wrong num");
        else 
            cur_albom = i;
        
    }
    public void set_cur_albom(albom _albom) { 
        cur_albom = alboms.indexOf(_albom);
        if (cur_albom == -1) {
            throw new IllegalArgumentException("unexpected error in set_cur_albom(albom _albom) in class" + this.getClass().getName());
        }
    }
    public albom get_cur_albom() {
        return alboms.get(cur_albom);
    }

    public void remove_albom(int index) { 
        index--;
        if (index >= 0 && index < alboms.size() ) {
            alboms.remove(index);
            if (cur_albom == alboms.size()) cur_albom--;
        }
        else {
            System.out.println("can't remove unreal albom");
        }
    }
    public void remove_albom(String name) {
        for (int i=0;i<alboms.size();i++) {
            if (alboms.get(i).get_name() == name) {
                alboms.remove(i);
                if (cur_albom == alboms.size()) cur_albom--;
                break;
            }
        }
    }
    public void add_albom(albom _albom) {
        alboms.add(_albom);
        song [] _songs = _albom.get_songs();
        for (int i=0;i<_songs.length;i++) {
            songs.add(_songs[i]);
        }
    }
    public void add_albom(albom _albom, int index) {
        if (index > alboms.size()) index = alboms.size();
        alboms.add(index, _albom);
        song [] _songs = _albom.get_songs();
        for (int i=0;i<_songs.length;i++) {
            songs.add(_songs[i]);
        }
    }
    public void add_albom(String name) {
        alboms.add(new albom(name));
        song [] _songs = alboms.get(alboms.size()-1).get_songs();
        for (int i=0;i<_songs.length;i++) {
            songs.add(_songs[i]);
        }
    }
    public void out_alboms() {
        for (int i=0;i<alboms.size();i++) {
            alboms.get(i).out();
        }
    }
    public void out_songs() {
        song[] songs;
        for (int i=0;i<alboms.size();i++) {
            songs = alboms.get(i).get_songs();
            for (int j=0;j<songs.length;j++) {
                songs[j].out();
            }
        }
    }
    public albom[] get_alboms() {
        albom[] _alboms = new albom[alboms.size()];
        alboms.toArray(_alboms);
        return _alboms;

    }
    public song[] get_songs() {
        song[] _songs = new song[songs.size()];
        songs.toArray(_songs);
        return _songs;
    }

    public song get_song(String name) {
        for (int i=0;i<songs.size();i++) {
            if (songs.get(i).get_name() == name) {
                return songs.get(i);
            }
        }
        return null;
    }

    public song get_song(int ind) {
        if (ind > songs.size() || ind <= 0) { return null; }
        ind--;
        return songs.get(ind);
    }

    public song[] get_songs(String artist) {
        ArrayList<song> _songs = new ArrayList<>();
        song[] songs_res;
        for (int i=0;i<songs.size();i++) {
            if (songs.get(i).get_artist() == artist) {
                _songs.add(songs.get(i));
            }
        }
        if (_songs.size() == 0) return null;
        songs_res = new song[_songs.size()];
        _songs.toArray(songs_res);
        return songs_res;
    }
    public albom get_albom(String name) {
        for (int i=0;i<alboms.size();i++) {
            if (alboms.get(i).get_name() == name) {
                return alboms.get(i);
            }
        }
        return null;
    }
    public albom get_albom(int ind) {
        if (ind > alboms.size() || ind <= 0) { return null; }
        ind--;
        return alboms.get(ind);
    }
}
