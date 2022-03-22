package ui.buttons;

import model.PokemonTeam;
import ui.windows.TeamBuilderWindow;

import javax.swing.*;

//Button for manipulating Pokemon Team Builder.
public abstract class PokemonButton extends JButton {
    protected PokemonTeam pokemonTeam;
    protected TeamBuilderWindow getTeamBuilderWindow;

    //EFFECTS: Create buttons.
    public PokemonButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        this.getTeamBuilderWindow = teamBuilderWindow;
        setBorderPainted(true);
        setFocusPainted(true);
        setContentAreaFilled(true);
    }

    public PokemonTeam getPokemonTeam() {
        return pokemonTeam;
    }

    public TeamBuilderWindow getMainWindow() {
        return getTeamBuilderWindow;
    }
}
