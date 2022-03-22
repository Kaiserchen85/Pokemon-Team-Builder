package ui.buttons;

import model.PokemonTeam;
import model.WorkRoom;
import persistence.JsonReader;
import ui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadButton extends PokemonButton {
    private static final String JSON_STORE = "./data/myFile.txt";

    private WorkRoom workRoom;
    private JsonReader jsonReader;

    public LoadButton(String label, PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super(label, pokemonTeam, mainWindow);
        workRoom = new WorkRoom("Work Room");
        jsonReader = new JsonReader(JSON_STORE);
        addActionListener(new LoadTeamListener());
    }

    private class LoadTeamListener implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            // EFFECTS: Saves the workroom to file.
            try {
                workRoom = jsonReader.read();
                workRoom.addPokemonTeam(getPokemonTeam());
                PokemonTeam cloneTeam = workRoom.getPokemonTeamList().get(0);
                pokemonTeam.changeName(cloneTeam.getTeamName());
                pokemonTeam.getPokemonTeam().clear();
                for (int i = 0; i < cloneTeam.getPokemonTeam().size(); i++) {
                    pokemonTeam.addPokemon(cloneTeam.getPokemonTeam().get(i));
                }
                getMainWindow.getTeamNameLabel().setText(pokemonTeam.getTeamName());
                getMainWindow.updatePokemonTeamDisplayPanel();
            } catch (IOException exception) {
                System.out.println("Error!");
            }
        }
    }
}
