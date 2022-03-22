package ui.buttons;

import model.PokemonTeam;
import ui.windows.TeamBuilderWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Button for removing Pokemon.
public class RemovePokemonButton extends PokemonButton {

    //EFFECTS: Create button for removing Pokemon.
    public RemovePokemonButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label, pokemonTeam, teamBuilderWindow);
        addActionListener(new AddPokemonListener());
    }

    private class AddPokemonListener implements ActionListener {

        // EFFECTS: Toggle removing Pokemon.
        @Override
        public void actionPerformed(ActionEvent e) {
            getMainWindow().getPokemonTeamDisplayPanel().setIsRemovingTrue();
        }
    }
}
