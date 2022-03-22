package ui.buttons;

import model.PokemonTeam;
import model.WorkRoom;
import persistence.JsonReader;
import ui.windows.TeamBuilderWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Button for loading Pokemon Team from files.
public class LoadButton extends PokemonButton {
    private static final String JSON_STORE = "./data/myFile.txt";

    private WorkRoom workRoom;
    private JsonReader jsonReader;

    //EFFECTS: Create button for loading Pokemon.
    public LoadButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label, pokemonTeam, teamBuilderWindow);
        workRoom = new WorkRoom("Work Room");
        jsonReader = new JsonReader(JSON_STORE);
        addActionListener(new LoadTeamListener());
    }

    private class LoadTeamListener implements ActionListener {

        // EFFECTS: Load Pokemon Team from WorkRoom and updates Team Builder Window.
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                workRoom = jsonReader.read();
                workRoom.addPokemonTeam(getPokemonTeam());
                PokemonTeam cloneTeam = workRoom.getPokemonTeamList().get(0);
                pokemonTeam.changeName(cloneTeam.getTeamName());
                pokemonTeam.getPokemonTeam().clear();
                for (int i = 0; i < cloneTeam.getPokemonTeam().size(); i++) {
                    pokemonTeam.addPokemon(cloneTeam.getPokemonTeam().get(i));
                }
                getTeamBuilderWindow.getTeamNameLabel().setText(pokemonTeam.getTeamName());
                getTeamBuilderWindow.updatePokemonTeamDisplayPanel();
            } catch (IOException exception) {
                System.out.println("Error!");
            }
        }
    }
}
