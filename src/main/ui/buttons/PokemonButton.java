package ui.buttons;

import model.PokemonTeam;
import ui.windows.TeamBuilderWindow;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.windows.TeamBuilderWindow.FONT;

//Button for manipulating Pokemon Team Builder.
public abstract class PokemonButton extends JButton implements ActionListener {
    protected PokemonTeam pokemonTeam;
    protected TeamBuilderWindow teamBuilderWindow;

    //EFFECTS: Create button meant for their specific purposes.
    public PokemonButton(String label, PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        this.teamBuilderWindow = teamBuilderWindow;
        setBorderPainted(true);
        setFocusPainted(true);
        setContentAreaFilled(true);
        setFont(FONT);
        addActionListener(this);
    }

    @Override
    //EFFECTS: Performs actions that button is required to do.
    public abstract void actionPerformed(ActionEvent e);
}
