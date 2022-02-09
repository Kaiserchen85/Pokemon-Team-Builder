package model;

import java.util.ArrayList;

public class PokemonTeam {
    private String teamName;
    private ArrayList<Pokemon> pokemonTeam;

    //EFFECTS: name of team is set to name, team has no pokemon.
    public PokemonTeam(String teamName) {
        this.teamName = teamName;
        pokemonTeam = new ArrayList<>();
    }

    //MODIFIES: This
    //EFFECTS: Adds new name for team.
    public void changeName(String teamName) {
        this.teamName = teamName;
    }

    //MODIFIES: This
    //EFFECTS: Adds Pokemon to team if there are less than 6 Pokemon. Otherwise, it does not add.
    public void addPokemon(Pokemon pokemon) {
        if (pokemonTeam.size() < 6) {
            pokemonTeam.add(pokemon);
        }
    }

    //REQUIRES: int must be >= 0.
    //MODIFIES: This
    //EFFECTS: Removes Pokemon at given index from team and produces true. Otherwise, do nothing and produce false.
    public boolean removePokemon(int index) {
        if (pokemonTeam.size() > index) {
            pokemonTeam.remove(index);
            return true;
        }
        return false;
    }

    //MODIFIES: This
    //EFFECTS: Outputs the total base stats of all 6 Pokemon.
    public int getStatTotalOfTeam() {
        int statTotal = 0;
        for (Pokemon p : pokemonTeam) {
            statTotal += p.getBaseStatTotal();
        }
        return statTotal;
    }

    //public void swapPokemon(int swap1, int swap2) {

    //}

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Pokemon> getPokemonTeam() {
        return pokemonTeam;
    }
}