package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    private Pokemon pokemon;

    @BeforeEach
    public void setup() {
        pokemon = new Pokemon("Venusaur");
    }

    @Test
    public void constructorTest() {
        assertEquals("Venusaur", pokemon.getName());
        assertEquals("None", pokemon.getItem());
        assertEquals("None", pokemon.getPrimaryType());
        assertEquals("None", pokemon.getSecondaryType());
        assertEquals(1, pokemon.getBaseStatTotal());
        assertEquals(0, pokemon.getMoves().size());
    }

    @Test
    public void addMoveTest() {
        pokemon.addMove("SolarBeam");
        assertEquals(1, pokemon.getMoves().size());
        assertEquals("SolarBeam", pokemon.getMoves().get(0));
    }

    @Test
    public void addSameMoveTwiceTest() {
        pokemon.addMove("SolarBeam");
        pokemon.addMove("SolarBeam");
        assertEquals(1, pokemon.getMoves().size());
        assertEquals("SolarBeam", pokemon.getMoves().get(0));
    }

    @Test
    public void addMoveToAndPastLimitTest() {
        pokemon.addMove("SolarBeam");
        pokemon.addMove("Leech Seed");
        pokemon.addMove("Magnitude");
        pokemon.addMove("Tackle");
        assertEquals(4, pokemon.getMoves().size());
        assertEquals("SolarBeam", pokemon.getMoves().get(0));
        assertEquals("Leech Seed", pokemon.getMoves().get(1));
        assertEquals("Magnitude", pokemon.getMoves().get(2));
        assertEquals("Tackle", pokemon.getMoves().get(3));
        pokemon.addMove("Flamethrower");
        assertEquals(4, pokemon.getMoves().size());
        assertEquals("SolarBeam", pokemon.getMoves().get(0));
        assertEquals("Leech Seed", pokemon.getMoves().get(1));
        assertEquals("Magnitude", pokemon.getMoves().get(2));
        assertEquals("Tackle", pokemon.getMoves().get(3));
    }

    @Test
    public void removeMoveTest() {
        pokemon.addMove("SolarBeam");
        pokemon.addMove("Leech Seed");
        pokemon.addMove("Magnitude");
        pokemon.addMove("Tackle");
        pokemon.removeMove("Leech Seed");
        assertEquals(3, pokemon.getMoves().size());
        assertEquals("SolarBeam", pokemon.getMoves().get(0));
        assertEquals("Magnitude", pokemon.getMoves().get(1));
        assertEquals("Tackle", pokemon.getMoves().get(2));
    }

    @Test
    public void removeNonexistentTest() {
        pokemon.addMove("SolarBeam");
        pokemon.addMove("Leech Seed");
        pokemon.addMove("Magnitude");
        pokemon.addMove("Tackle");
        pokemon.removeMove("Flamethrower");
        assertEquals(4, pokemon.getMoves().size());
        assertEquals("SolarBeam", pokemon.getMoves().get(0));
        assertEquals("Leech Seed", pokemon.getMoves().get(1));
        assertEquals("Magnitude", pokemon.getMoves().get(2));
        assertEquals("Tackle", pokemon.getMoves().get(3));
    }

    @Test
    public void addItemTest() {
        pokemon.addItem("Life Orb");
        assertEquals("Life Orb", pokemon.getItem());
    }

    @Test
    public void addItemTwiceTest() {
        pokemon.addItem("Life Orb");
        assertEquals("Life Orb", pokemon.getItem());
        pokemon.addItem("Choice Band");
        assertEquals("Choice Band", pokemon.getItem());
    }

    @Test
    public void removeItemTest() {
        pokemon.addItem("Life Orb");
        pokemon.removeItem();
        assertEquals("None", pokemon.getItem());
    }

    @Test
    public void addTypingTest() {
        pokemon.addTyping("Grass", "Poison");
        assertEquals("Grass", pokemon.getPrimaryType());
        assertEquals("Poison", pokemon.getSecondaryType());
    }

    @Test
    public void addSameTypingTest() {
        pokemon.addTyping("Grass", "Grass");
        assertEquals("Grass", pokemon.getPrimaryType());
        assertEquals("None", pokemon.getSecondaryType());
    }

    @Test
    public void addNoneThenTypeTypingTest() {
        pokemon.addTyping("None", "Poison");
        assertEquals("Poison", pokemon.getPrimaryType());
        assertEquals("None", pokemon.getSecondaryType());
    }

    @Test
    public void addStatsTest() {
        pokemon.setBaseStatTotal(450);
        assertEquals(450, pokemon.getBaseStatTotal());
    }
}