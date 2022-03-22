package ui.buttons;

import model.PokemonTeam;
import model.WorkRoom;
import persistence.JsonWriter;
import ui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SaveButton extends PokemonButton {
    private static final String JSON_STORE = "./data/myFile.txt";

    private WorkRoom workRoom;
    private JsonWriter jsonWriter;

    public SaveButton(String label, PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super(label, pokemonTeam, mainWindow);
        workRoom = new WorkRoom("Work Room");
        jsonWriter = new JsonWriter(JSON_STORE);
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
                workRoom.addPokemonTeam(getPokemonTeam());
                jsonWriter.open();
                jsonWriter.write(workRoom);
                jsonWriter.close();
                getMainWindow().getPokemonTeamDisplayPanel().setIsRemovingFalse();
            } catch (FileNotFoundException exception) {
                System.out.println("Error!");
            }
        }
    }
}
