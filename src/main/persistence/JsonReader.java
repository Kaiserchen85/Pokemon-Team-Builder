package persistence;

import model.Pokemon;
import model.PokemonTeam;
import model.WorkRoom;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//References JsonSerializationDemo
// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: Constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: Reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkRoom read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: Reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: Parses workroom from JSON object and returns it
    private WorkRoom parseWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WorkRoom wr = new WorkRoom(name);
        addPokemonTeams(wr, jsonObject);
        return wr;
    }

    // MODIFIES: wr
    // EFFECTS: Parses Pokemon Teams from JSON object and adds them to workroom
    private void addPokemonTeams(WorkRoom wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("pokemon team list");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addPokemonTeam(wr, nextThingy);
        }
    }

    // MODIFIES: wr
    // EFFECTS: Parses Pokemon Team from JSON object and adds it to workroom
    private void addPokemonTeam(WorkRoom wr, JSONObject jsonObject) {
        String name = jsonObject.getString("team name");
        PokemonTeam pokemonTeam = new PokemonTeam(name);
        JSONArray jsonArray = jsonObject.getJSONArray("pokemon team");
        for (Object j : jsonArray) {
            JSONObject nextPokemon = (JSONObject) j;
            String pokemonName = nextPokemon.getString("name");
            String item = nextPokemon.getString("item");
            String primaryType = nextPokemon.getString("primaryType");
            String secondaryType = nextPokemon.getString("secondaryType");
            int baseStatTotal = nextPokemon.getInt("baseStatTotal");
            JSONArray moves = nextPokemon.getJSONArray("moves");
            Pokemon pokemon = new Pokemon(pokemonName);
            for (Object o : moves) {
                String move = o.toString();
                pokemon.addMove(move);
            }
            pokemon.addItem(item);
            pokemon.addTyping(primaryType, secondaryType);
            pokemon.setBaseStatTotal(baseStatTotal);
            pokemonTeam.addPokemon(pokemon);
        }
        wr.addPokemonTeam(pokemonTeam);
    }
}
