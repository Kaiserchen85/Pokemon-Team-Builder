package ui.windows;

import model.PokemonTeam;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class PokemonWindow extends JFrame implements ActionListener {

    protected MainWindow mainWindow;
    protected JTextField pokemonName;
    protected JTextField item;
    protected JTextField primaryType;
    protected JTextField secondaryType;
    protected JTextField move1;
    protected JTextField move2;
    protected JTextField move3;
    protected JTextField move4;
    protected JTextField baseStatTotal;

    public PokemonWindow(MainWindow mainWindow) {
        super("Pokemon Editor");
        this.mainWindow = mainWindow;
        pokemonName = new JTextField();
        item = new JTextField();
        primaryType = new JTextField();
        secondaryType = new JTextField();
        move1 = new JTextField();
        move2 = new JTextField();
        move3 = new JTextField();
        move4 = new JTextField();
        baseStatTotal = new JTextField();
    }
}
