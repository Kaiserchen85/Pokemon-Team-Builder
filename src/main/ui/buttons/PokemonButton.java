package ui.buttons;

import model.PokemonTeam;
import ui.windows.MainWindow;

import javax.swing.*;

public abstract class PokemonButton extends JButton {
    protected PokemonTeam pokemonTeam;
    protected MainWindow getMainWindow;

    public PokemonButton(String label, PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        this.getMainWindow = mainWindow;
        setBorderPainted(true);
        setFocusPainted(true);
        setContentAreaFilled(true);
    }

    public PokemonTeam getPokemonTeam() {
        return pokemonTeam;
    }

    public MainWindow getMainWindow() {
        return getMainWindow;
    }
}
