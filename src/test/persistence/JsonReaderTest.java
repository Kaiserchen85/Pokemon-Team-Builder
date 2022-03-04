package persistence;

import model.PokemonTeam;
import model.WorkRoom;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//References JsonSerializationDemo
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.txt");
        try {
            WorkRoom wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.txt");
        try {
            WorkRoom wr = reader.read();
            assertEquals("My work room", wr.getName());
            assertEquals(0, wr.numPokemonTeams());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.txt");
        try {
            WorkRoom wr = reader.read();
            assertEquals("My work room", wr.getName());
            List<PokemonTeam> pokemonTeamList = wr.getPokemonTeamList();
            assertEquals(1, pokemonTeamList.size());
            checkPokemonTeam("Team A", pokemonTeamList.get(0).getPokemonTeam(), pokemonTeamList.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}