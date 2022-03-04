package persistence;

import model.Pokemon;
import model.PokemonTeam;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//References JsonSerializationDemo JsonTest test class.
public class JsonTest {

    protected void checkPokemonTeam(String name, ArrayList<Pokemon> pokemonList, PokemonTeam pokemonTeam) {
        assertEquals(name, pokemonTeam.getTeamName());
        int index = 0;
        for (Pokemon p : pokemonList) {
            Pokemon test = pokemonTeam.getPokemonTeam().get(index);
            assertEquals(p.getName(), test.getName());
            assertEquals(p.getItem(), test.getItem());
            assertEquals(p.getPrimaryType(), test.getPrimaryType());
            assertEquals(p.getSecondaryType(), test.getSecondaryType());
            assertEquals(p.getMoves(), test.getMoves());
            assertEquals(p.getBaseStatTotal(), test.getBaseStatTotal());
            index++;
        }
    }
}
