package ui.buttons;

import model.PokemonTeam;
import ui.windows.AddPokemonWindow;
import ui.windows.TeamBuilderWindow;

import java.awt.event.ActionEvent;

//Button for adding Pokemon.
public class AddPokemonButton extends PokemonButton {

    //EFFECTS: Creates button for adding Pokemon.
    public AddPokemonButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label, pokemonTeam, teamBuilderWindow);
    }

    // EFFECTS: Opens AddPokemonWindow if there are less than 6 Pokemon in the Pokemon Team.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (pokemonTeam.getPokemonTeam().size() < 6) {
            teamBuilderWindow.getPokemonTeamDisplayPanel().setIsRemovingFalse();
            new AddPokemonWindow(pokemonTeam, teamBuilderWindow);
        }
    }
}
