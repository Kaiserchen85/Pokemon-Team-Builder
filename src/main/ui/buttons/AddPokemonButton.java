package ui.buttons;

import model.PokemonTeam;
import ui.windows.AddPokemonWindow;
import ui.windows.TeamBuilderWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Button for adding Pokemon.
public class AddPokemonButton extends PokemonButton {

    //EFFECTS: Creates button for adding Pokemon.
    public AddPokemonButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label, pokemonTeam, teamBuilderWindow);
        addActionListener(new AddPokemonListener());
    }

    private class AddPokemonListener implements ActionListener {

        // EFFECTS: Opens AddPokemonWindow.
        @Override
        public void actionPerformed(ActionEvent e) {
            if (getPokemonTeam().getPokemonTeam().size() < 6) {
                new AddPokemonWindow(getPokemonTeam(), getMainWindow());
            }
        }
    }
}
