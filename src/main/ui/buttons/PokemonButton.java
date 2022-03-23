package ui.buttons;

import model.PokemonTeam;
import ui.windows.TeamBuilderWindow;

import javax.swing.*;

import static ui.windows.TeamBuilderWindow.FONT;

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
        setFont(FONT);
    }

    public PokemonTeam getPokemonTeam() {
        return pokemonTeam;
    }

    public TeamBuilderWindow getMainWindow() {
        return getTeamBuilderWindow;
    }
}
