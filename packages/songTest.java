package java_player.packages;
import org.junit.jupiter.api.Test;
import java_player.packages.song;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class songTest{
    private final song test_song_1 = new song("/music/music.txt");
    private final song test_song_2 = new song("/music/music2.txt");
    @Test
    public void is_valid_name() {
        assertEquals(test_song_1.get_name(), "name1");
        assertEquals(test_song_2.get_name(), "name2");
    }
    @Test
    public void is_valid_artist() {
        assertEquals(test_song_1.get_artist(), "artist1");
        assertEquals(test_song_2.get_artist(), "artist2");
    }
    @Test
    public void is_valid_duration() {
        assertEquals(test_song_1.get_duration(), 1);
        assertEquals(test_song_2.get_duration(), 2);
    }
    @Test
    public void is_correct_save_duration() {
        test_song_1.save_song("/music/test_save_song");
        song test_song_save = new song("/music/test_save_song");
        assertEquals(test_song_1.get_name(), test_song_save.get_name());
        assertEquals(test_song_1.get_artist(), test_song_save.get_artist());
        assertEquals(test_song_1.get_duration(), test_song_save.get_duration());
    }
    @Test
    public void is_correct_equals() {
        assertTrue(test_song_1.equals(test_song_1));
        assertFalse(test_song_1.equals(test_song_2));
    }
}
