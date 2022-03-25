package ui.buttons;

import model.PokemonTeam;
import model.WorkRoom;
import persistence.JsonWriter;
import ui.windows.TeamBuilderWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//Button for saving Pokemon Team to file.
public class SaveButton extends PokemonButton {
    private static final String JSON_STORE = "./data/myFile.txt";

    private WorkRoom workRoom;
    private JsonWriter jsonWriter;

    //EFFECTS: Create button for saving Pokemon.
    public SaveButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label, pokemonTeam, teamBuilderWindow);
        workRoom = new WorkRoom("Work Room");
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    // EFFECTS: Saves Pokemon Team to file.
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            workRoom.resetPokemonTeam();
            workRoom.addPokemonTeam(pokemonTeam);
            jsonWriter.open();
            jsonWriter.write(workRoom);
            jsonWriter.close();
            teamBuilderWindow.getPokemonTeamDisplayPanel().setIsRemovingFalse();
        } catch (FileNotFoundException exception) {
            System.out.println("Error!");
        }
    }
}
