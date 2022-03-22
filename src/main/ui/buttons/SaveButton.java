package ui.buttons;

import model.PokemonTeam;
import model.WorkRoom;
import persistence.JsonWriter;
import ui.windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SaveButton extends JButton {
    private static final String JSON_STORE = "./data/myFile.txt";

    private PokemonTeam pokemonTeam;
    private MainWindow mainWindow;
    private WorkRoom workRoom;
    private JsonWriter jsonWriter;

    public SaveButton(String label, PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        this.mainWindow = mainWindow;
        workRoom = new WorkRoom("Work Room");
        jsonWriter = new JsonWriter(JSON_STORE);
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
                workRoom.resetPokemonTeam();
                workRoom.addPokemonTeam(pokemonTeam);
                jsonWriter.open();
                jsonWriter.write(workRoom);
                jsonWriter.close();
                mainWindow.getTeamDesign().setIsRemovingFalse();
            } catch (FileNotFoundException exception) {
                System.out.println("Error!");
            }
        }
    }
}
