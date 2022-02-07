package model;

import java.util.ArrayList;
import java.util.List;

public class PokemonTeam {
    private String teamName;
    private List<Pokemon> pokemonTeam;

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

    //MODIFIES: This
    //EFFECTS: Removes Pokemon from team if found, otherwise does nothing.
    //         If there are multiple, remove first one found.
    public void removePokemon(String pokemon) {
        for (Pokemon p : pokemonTeam) {
            if (p.getName().equals(pokemon)) {
                pokemonTeam.remove(p);
                break;
            }
        }
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

    public String getTeamName() {
        return teamName;
    }

    public List<Pokemon> getPokemonTeam() {
        return pokemonTeam;
    }
}