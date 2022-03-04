package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//References JsonSerializationDemo WorkRoom model class.
// Represents a workroom having a collection of Pokemon Teams.
public class WorkRoom implements Writable {
    private String name;
    private List<PokemonTeam> pokemonTeamList;

    // EFFECTS: Constructs workroom with a name and empty list of Pokemon Teams.
    public WorkRoom(String name) {
        this.name = name;
        pokemonTeamList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // MODIFIES: This
    // EFFECTS: Adds Pokemon Team to this workroom.
    public void addPokemonTeam(PokemonTeam pokemonTeam) {
        pokemonTeamList.add(pokemonTeam);
    }

    // MODIFIES: This
    // EFFECTS: Clears list of Pokemon Teams.
    public void resetPokemonTeam() {
        pokemonTeamList.clear();
    }

    // EFFECTS: Returns an unmodifiable list of Pokemon Teams in this workroom.
    public List<PokemonTeam> getPokemonTeamList() {
        return Collections.unmodifiableList(pokemonTeamList);
    }

    // EFFECTS: Returns number of Pokemon Teams in this workroom.
    public int numPokemonTeams() {
        return pokemonTeamList.size();
    }

    //EFFECTS: Returns workroom as a JSONObject.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("pokemon team list", pokemonTeamsToJson());
        return json;
    }

    // EFFECTS: Returns Pokemon Teams in this workroom as a JSON array.
    private JSONArray pokemonTeamsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (PokemonTeam p : pokemonTeamList) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}

