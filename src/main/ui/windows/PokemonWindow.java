package ui.windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static ui.windows.TeamBuilderWindow.FONT;

//Panel for manipulating Pokemon Team Builder.
public abstract class PokemonWindow extends JFrame implements ActionListener {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

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
        settingFont();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new GridLayout(0, 1));
    }

    //EFFECTS: Set font for all text fields.
    public void settingFont() {
        pokemonName.setFont(FONT);
        item.setFont(FONT);
        primaryType.setFont(FONT);
        secondaryType.setFont(FONT);
        move1.setFont(FONT);
        move2.setFont(FONT);
        move3.setFont(FONT);
        move4.setFont(FONT);
        baseStatTotal.setFont(FONT);
    }

    //EFFECTS: Adds text onto window.
    public void createJLabelText(String message) {
        JLabel text = new JLabel(message);
        text.setFont(FONT);
        add(text);
    }

    //EFFECTS: Creates text and text fields for window.
    public abstract void createTextFields();
}
