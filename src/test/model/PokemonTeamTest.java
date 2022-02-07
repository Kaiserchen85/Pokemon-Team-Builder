package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTeamTest {
    private PokemonTeam pokemonTeam;

    @BeforeEach
    public void setup() {
        pokemonTeam = new PokemonTeam("Team 1");
    }

    @Test
    public void constructorTest() {
        assertEquals("Team 1", pokemonTeam.getTeamName());
        assertEquals(0, pokemonTeam.getPokemonTeam().size());
    }

    @Test
    public void changeNameTest() {
        pokemonTeam.changeName("Digimon");
        assertEquals("Digimon", pokemonTeam.getTeamName());
    }

    @Test
    public void addPokemonTest() {
        Pokemon venusaur = new Pokemon("Venusaur");
        pokemonTeam.addPokemon(venusaur);
        assertEquals(1, pokemonTeam.getPokemonTeam().size());
        assertEquals(venusaur, pokemonTeam.getPokemonTeam().get(0));
    }

    @Test
    public void addMultiplePokemonTest() {
        Pokemon venusaur = new Pokemon("Venusaur");
        Pokemon pikachu = new Pokemon("Pikachu");
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(pikachu);
        assertEquals(2, pokemonTeam.getPokemonTeam().size());
        assertEquals(venusaur, pokemonTeam.getPokemonTeam().get(0));
        assertEquals(pikachu, pokemonTeam.getPokemonTeam().get(1));
    }

    @Test
    public void exceedLimitAddPokemonTest() {
        Pokemon venusaur = new Pokemon("Venusaur");
        Pokemon pikachu = new Pokemon("Pikachu");
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(venusaur);
        assertEquals(2, pokemonTeam.getPokemonTeam().size());
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(pikachu);
        assertEquals(6, pokemonTeam.getPokemonTeam().size());
        assertFalse(pokemonTeam.getPokemonTeam().contains(pikachu));
    }

    @Test
    public void removePokemonTest() {
        Pokemon venusaur = new Pokemon("Venusaur");
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon espeon = new Pokemon("Espeon");
        Pokemon lapras = new Pokemon("Lapras");
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(pikachu);
        pokemonTeam.addPokemon(espeon);
        pokemonTeam.addPokemon(lapras);
        pokemonTeam.removePokemon("Pikachu");
        assertEquals(3, pokemonTeam.getPokemonTeam().size());
        assertFalse(pokemonTeam.getPokemonTeam().contains(pikachu));
        assertEquals(venusaur, pokemonTeam.getPokemonTeam().get(0));
        assertEquals(espeon, pokemonTeam.getPokemonTeam().get(1));
        assertEquals(lapras, pokemonTeam.getPokemonTeam().get(2));
    }

    @Test
    public void removePokemonWithDuplicatesTest() {
        Pokemon venusaur = new Pokemon("Venusaur");
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon espeon = new Pokemon("Espeon");
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(pikachu);
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(espeon);
        pokemonTeam.removePokemon("Venusaur");
        assertEquals(3, pokemonTeam.getPokemonTeam().size());
        assertTrue(pokemonTeam.getPokemonTeam().contains(venusaur));
        assertEquals(pikachu, pokemonTeam.getPokemonTeam().get(0));
        assertEquals(venusaur, pokemonTeam.getPokemonTeam().get(1));
        assertEquals(espeon, pokemonTeam.getPokemonTeam().get(2));
    }

    @Test
    public void removeNonexistentTest() {
        Pokemon venusaur = new Pokemon("Venusaur");
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon espeon = new Pokemon("Espeon");
        Pokemon lapras = new Pokemon("Lapras");
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(pikachu);
        pokemonTeam.addPokemon(espeon);
        pokemonTeam.addPokemon(lapras);
        pokemonTeam.removePokemon("Snorlax");
        assertEquals(4, pokemonTeam.getPokemonTeam().size());
        assertEquals(venusaur, pokemonTeam.getPokemonTeam().get(0));
        assertEquals(pikachu, pokemonTeam.getPokemonTeam().get(1));
        assertEquals(espeon, pokemonTeam.getPokemonTeam().get(2));
        assertEquals(lapras, pokemonTeam.getPokemonTeam().get(3));
    }

    @Test
    public void getStatTotalTest() {
        Pokemon venusaur = new Pokemon("Venusaur");
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon espeon = new Pokemon("Espeon");
        Pokemon lapras = new Pokemon("Lapras");
        venusaur.setBaseStatTotal(300);
        pikachu.setBaseStatTotal(100);
        espeon.setBaseStatTotal(256);
        lapras.setBaseStatTotal(151);
        pokemonTeam.addPokemon(venusaur);
        pokemonTeam.addPokemon(pikachu);
        pokemonTeam.addPokemon(espeon);
        pokemonTeam.addPokemon(lapras);
        assertEquals(807, pokemonTeam.getStatTotalOfTeam());
    }
}
