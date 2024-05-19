package java_player.packages;
import org.junit.jupiter.api.Test;
import java_player.packages.song;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class albomTest{
    private final song test_song_1 = new song("/music/music.txt");
    private final song test_song_2 = new song("/music/music2.txt");
    private final albom test_albom = new albom("test_album");
    @Test
    public void is_valid_name() {
        assertEquals(test_albom.get_name(), "test_album");
    }
    @Test
    public void is_valid_add() {
        test_albom.add_song(test_song_1);
        assertTrue(test_albom.get_cur_song().equals(test_song_1));
    }
    @Test
    public void is_valid_set_cur_song() {
        test_albom.clear();
        test_albom.add_song(test_song_1);
        test_albom.add_song(test_song_2);
        assertTrue(test_albom.get_cur_song().equals(test_song_1));
        test_albom.set_cur_song(2);
        assertTrue(test_albom.get_cur_song().equals(test_song_2));
    }
    @Test
    public void is_valid_next_prev() {
        test_albom.clear();
        test_albom.add_song(test_song_1);
        test_albom.add_song(test_song_2);
        assertTrue(test_albom.get_cur_song().equals(test_song_1));
        test_albom.next_song();
        assertTrue(test_albom.get_cur_song().equals(test_song_2));
        test_albom.next_song();
        assertTrue(test_albom.get_cur_song().equals(test_song_1));
        test_albom.previous_song();
        assertTrue(test_albom.get_cur_song().equals(test_song_2));
        test_albom.previous_song();
        assertTrue(test_albom.get_cur_song().equals(test_song_1));
    }
    @Test
    public void is_valid_remove() {
        test_albom.clear();
        test_albom.add_song(test_song_1);
        test_albom.add_song(test_song_2);
        test_albom.remove_song("name1");
        assertTrue(test_albom.get_cur_song().equals(test_song_2));
        test_albom.add_song(test_song_1);
        test_albom.remove_song(1);
        assertTrue(test_albom.get_cur_song().equals(test_song_1));
    }
    @Test
    public void is_valid_save_songs() {
        test_albom.clear();
        test_albom.add_song(test_song_1);
        test_albom.add_song(test_song_2);
        test_albom.save_albom();
        song test_song_save_1 = new song("/music/test_album/\"name1\".mp3");
        song test_song_save_2 = new song("/music/test_album/\"name2\".mp3");
        assertTrue(test_albom.get_cur_song().equals(test_song_save_1));
        assertTrue(test_albom.next_song().equals(test_song_save_2));
    }
}
