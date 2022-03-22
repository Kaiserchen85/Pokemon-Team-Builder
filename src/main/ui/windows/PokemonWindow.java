package ui.windows;

import javax.swing.*;
import java.awt.event.ActionListener;

//Panel for manipulating Pokemon Team Builder.
public abstract class PokemonWindow extends JFrame implements ActionListener {

    protected TeamBuilderWindow teamBuilderWindow;
    protected JTextField pokemonName;
    protected JTextField item;
    protected JTextField primaryType;
    protected JTextField secondaryType;
    protected JTextField move1;
    protected JTextField move2;
    protected JTextField move3;
    protected JTextField move4;
    protected JTextField baseStatTotal;

    //EFFECTS: Constructs Pokemon window.
    public PokemonWindow(TeamBuilderWindow teamBuilderWindow) {
        super("Pokemon Editor");
        this.teamBuilderWindow = teamBuilderWindow;
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

    //EFFECTS: Creates text and text fields for window.
    public abstract void createTextFields();
}
