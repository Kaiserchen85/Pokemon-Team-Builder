package ui.windows;

import model.Pokemon;
import model.PokemonTeam;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeStatsWindow extends JFrame implements ActionListener {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private Pokemon pokemon;
    private MainWindow mainWindow;
    private JTextField item;
    private JTextField primaryType;
    private JTextField secondaryType;
    private JTextField move1;
    private JTextField move2;
    private JTextField move3;
    private JTextField move4;
    private JTextField baseStatTotal;

    public ChangeStatsWindow(Pokemon pokemon, MainWindow mainWindow) {
        super("Pokemon Maker");
        this.pokemon = pokemon;
        this.mainWindow = mainWindow;
        item = new JTextField();
        primaryType = new JTextField();
        secondaryType = new JTextField();
        move1 = new JTextField();
        move2 = new JTextField();
        move3 = new JTextField();
        move4 = new JTextField();
        baseStatTotal = new JTextField();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new GridLayout(0, 1));
        createTextFields();
        JButton btn = new JButton("Ok");
        btn.addActionListener(this);
        add(btn);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        pokemon.addItem(item.getText());
        pokemon.addTyping(primaryType.getText(), secondaryType.getText());
        pokemon.getMoves().clear();
        pokemon.addMove(move1.getText());
        pokemon.addMove(move2.getText());
        pokemon.addMove(move3.getText());
        pokemon.addMove(move4.getText());
        pokemon.setBaseStatTotal(Integer.parseInt(baseStatTotal.getText()));
        mainWindow.remove(mainWindow.getTeamDesign());
        mainWindow.addNewDrawing();
        mainWindow.revalidate();
        mainWindow.repaint();
        dispose();
    }

    public void createTextFields() {
        item.setText(pokemon.getItem());
        primaryType.setText(pokemon.getPrimaryType());
        secondaryType.setText(pokemon.getSecondaryType());
        setMove(move1, 0);
        setMove(move2, 1);
        setMove(move3, 2);
        setMove(move4, 3);
        baseStatTotal.setText(Integer.toString(pokemon.getBaseStatTotal()));
        add(new JLabel("Pokemon Name: " + pokemon.getName()));
        add(new JLabel("Item:"));
        add(item);
        add(new JLabel("Typing:"));
        add(primaryType);
        add(secondaryType);
        add(new JLabel("Moves:"));
        add(move1);
        add(move2);
        add(move3);
        add(move4);
        add(new JLabel("Base Stat Total:"));
        add(baseStatTotal);
    }

    public void setMove(JTextField move, int index) {
        if (index < pokemon.getMoves().size()) {
            move.setText(pokemon.getMoves().get(index));
        }
    }
}

