package persistence;

import model.Pokemon;
import model.PokemonTeam;
import model.WorkRoom;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//References JsonSerializationDemo
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            WorkRoom wr = new WorkRoom("My work room");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            WorkRoom wr = new WorkRoom("My work room");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            wr = reader.read();
            assertEquals("My work room", wr.getName());
            assertEquals(0, wr.numPokemonTeams());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            WorkRoom wr = new WorkRoom("My work room");
            PokemonTeam pokemonTeam = new PokemonTeam("Team A");
            Pokemon jolteon = new Pokemon("Jolteon");
            jolteon.addItem("Life Orb");
            jolteon.addTyping("Fire", "Grass");
            jolteon.setBaseStatTotal(144);
            jolteon.addMove("Thunder");
            jolteon.addMove("Thunderbolt");
            pokemonTeam.addPokemon(jolteon);
            wr.addPokemonTeam(pokemonTeam);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            wr = reader.read();
            assertEquals("My work room", wr.getName());
            List<PokemonTeam> pokemonTeamList = wr.getPokemonTeamList();
            assertEquals(1, wr.numPokemonTeams());
            checkPokemonTeam("Team A", pokemonTeam.getPokemonTeam(), pokemonTeamList.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}