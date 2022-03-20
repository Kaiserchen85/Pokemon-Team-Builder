package ui.buttons;

import model.Pokemon;
import model.PokemonTeam;
import ui.windows.AddPokemonWindow;
import ui.windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPokemonButton extends JButton {
    private PokemonTeam pokemonTeam;
    private MainWindow mainWindow;

    public AddPokemonButton(String label, PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        this.mainWindow = mainWindow;
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
                new AddPokemonWindow(pokemonTeam, mainWindow);
            }
        }
    }
}
