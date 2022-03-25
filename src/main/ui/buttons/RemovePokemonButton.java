package ui.buttons;

import model.PokemonTeam;
import ui.windows.TeamBuilderWindow;

import java.awt.event.ActionEvent;

//Button for removing Pokemon.
public class RemovePokemonButton extends PokemonButton {

    //EFFECTS: Create button for removing Pokemon.
    public RemovePokemonButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label, pokemonTeam, teamBuilderWindow);
    }

    // EFFECTS: Toggles Team Builder Window for removing Pokemon.
    public void actionPerformed(ActionEvent e) {
        teamBuilderWindow.getPokemonTeamDisplayPanel().setIsRemovingTrue();
    }
}
