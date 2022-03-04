package persistence;

import model.Pokemon;
import model.PokemonTeam;
import model.WorkRoom;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//References JsonSerializationDemo JsonWriterTest test class.
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            WorkRoom wr = new WorkRoom("My work room");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.txt");
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
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.txt");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.txt");
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
            Pokemon flareon = new Pokemon("Flareon");
            flareon.addItem("Leftovers");
            flareon.addTyping("Water", "Grass");
            flareon.setBaseStatTotal(144);
            flareon.addMove("Flamethrower");
            flareon.addMove("Ember");
            pokemonTeam.addPokemon(flareon);
            wr.addPokemonTeam(pokemonTeam);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.txt");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.txt");
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