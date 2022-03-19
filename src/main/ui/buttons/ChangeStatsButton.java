package ui.buttons;

import model.PokemonTeam;
import ui.windows.AddPokemonWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeStatsButton extends JButton {
    private PokemonTeam pokemonTeam;

    public ChangeStatsButton(String label, PokemonTeam pokemonTeam) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        setBorderPainted(true);
        setFocusPainted(true);
        setContentAreaFilled(true);
        addActionListener(new AddPokemonListener());
    }

    private class AddPokemonListener implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pokemonTeam.getPokemonTeam().size() < 6) {
                //stub
            }
        }
    }
}
