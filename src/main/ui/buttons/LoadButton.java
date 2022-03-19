package ui.buttons;

import model.PokemonTeam;
import model.WorkRoom;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadButton extends JButton {
    private static final String JSON_STORE = "./data/myFile.txt";

    private PokemonTeam pokemonTeam;
    private WorkRoom workRoom;
    private JsonReader jsonReader;

    public LoadButton(String label, PokemonTeam pokemonTeam) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        workRoom = new WorkRoom("Work Room");
        jsonReader = new JsonReader(JSON_STORE);
        setBorderPainted(true);
        setFocusPainted(true);
        setContentAreaFilled(true);
        addActionListener(new SaveTeamListener());
    }

    private class SaveTeamListener implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            // EFFECTS: Saves the workroom to file.
            try {
                workRoom = jsonReader.read();
                workRoom.addPokemonTeam(pokemonTeam);
                pokemonTeam = workRoom.getPokemonTeamList().get(0);
            } catch (IOException exception) {
                System.out.println("Error!");
            }
        }
    }
}
