package java_player.packages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class playerTest{
    private final song test_song_1 = new song("/music/music.txt");
    private final song test_song_2 = new song("/music/music2.txt");
    private final albom test_albom_1 = new albom("test_album1");
    private final albom test_albom_2 = new albom("test_album2");
    private final player test_player = new player();
    @Test
    public void is_valid_add() {
        test_albom_1.clear();
        test_albom_2.clear();
        test_player.clear();
        test_albom_1.add_song(test_song_1);
        test_albom_1.add_song(test_song_2);
        test_albom_2.add_song(test_song_1);
        test_albom_2.add_song(test_song_2);
        test_player.add_albom(test_albom_1);
        test_player.add_albom(test_albom_2);
        assertEquals(test_player.get_albom(1), test_albom_1);
        assertEquals(test_player.get_albom(2), test_albom_2);

    }
    public void is_valid_remove() {
        test_albom_1.clear();
        test_albom_2.clear();
        test_player.clear();
        test_albom_1.add_song(test_song_1);
        test_albom_1.add_song(test_song_2);
        test_albom_2.add_song(test_song_1);
        test_albom_2.add_song(test_song_2);
        test_player.add_albom(test_albom_1);
        test_player.add_albom(test_albom_2);
        test_player.remove_albom(1);
        assertEquals(test_player.get_albom(1), test_albom_2);
        test_player.remove_albom(1);
        assertNull(test_player.get_albom(1));
        assertNull(test_player.get_albom(15));
    }
    @Test
    public void is_valid_get_alboms() {
        test_albom_1.clear();
        test_albom_2.clear();
        test_player.clear();
        test_albom_1.add_song(test_song_1);
        test_albom_1.add_song(test_song_2);
        test_albom_2.add_song(test_song_1);
        test_albom_2.add_song(test_song_2);
        test_player.add_albom(test_albom_1);
        test_player.add_albom(test_albom_2);
        assertEquals(test_player.get_alboms()[0], test_albom_1);
        assertEquals(test_player.get_alboms()[1], test_albom_2);
    }
    @Test
    public void is_valid_get_song() {
        test_albom_1.clear();
        test_albom_2.clear();
        test_player.clear();
        test_albom_1.add_song(test_song_1);
        test_albom_1.add_song(test_song_2);
        test_albom_2.add_song(test_song_1);
        test_albom_2.add_song(test_song_2);
        test_player.add_albom(test_albom_1);
        test_player.add_albom(test_albom_2);
        assertEquals(test_player.get_song("name1"), test_song_1);
        assertEquals(test_player.get_song("name2"), test_song_2);
    }

}
