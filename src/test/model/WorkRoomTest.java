package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkRoomTest {
    private WorkRoom wr;

    @BeforeEach
    public void setup() {
        wr = new WorkRoom("A");
    }

    @Test
    public void workRoomResetTest() {
        PokemonTeam pokemonTeam = new PokemonTeam("R");
        PokemonTeam pokemonTeam1 = new PokemonTeam("B");
        wr.addPokemonTeam(pokemonTeam);
        wr.addPokemonTeam(pokemonTeam1);
        assertEquals(2, wr.numPokemonTeams());
        wr.resetPokemonTeam();
        assertEquals(0, wr.numPokemonTeams());
    }
}
