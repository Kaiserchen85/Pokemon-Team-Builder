package persistence;

import model.Pokemon;
import model.PokemonTeam;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//References JsonSerializationDemo
public class JsonTest {
    protected void checkThingy(String name, PokemonTeam pokemonTeam) {
        assertEquals(name, pokemonTeam.getTeamName());
    }
}
