package ui.windows;

import model.Pokemon;
import model.PokemonTeam;
import model.TeamDesign;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPokemonWindow extends JFrame implements ActionListener {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private PokemonTeam pokemonTeam;
    private MainWindow mainWindow;
    private JTextField pokemonName;
    private JTextField item;
    private JTextField primaryType;
    private JTextField secondaryType;
    private JTextField move1;
    private JTextField move2;
    private JTextField move3;
    private JTextField move4;
    private JTextField baseStatTotal;

    public AddPokemonWindow(PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super("Pokemon Maker");
        this.pokemonTeam = pokemonTeam;
        this.mainWindow = mainWindow;
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
        Pokemon pokemon = new Pokemon(pokemonName.getText());
        pokemon.addItem(item.getText());
        pokemon.addTyping(primaryType.getText(), secondaryType.getText());
        pokemon.addMove(move1.getText());
        pokemon.addMove(move2.getText());
        pokemon.addMove(move3.getText());
        pokemon.addMove(move4.getText());
        pokemon.setBaseStatTotal(Integer.parseInt(baseStatTotal.getText()));
        pokemonTeam.addPokemon(pokemon);
        mainWindow.remove(mainWindow.getTeamDesign());
        mainWindow.setPokemonTeam(pokemonTeam);
        mainWindow.addNewDrawing();
        mainWindow.revalidate();
        mainWindow.repaint();
        dispose();
    }

    public void createTextFields() {
        pokemonName = new JTextField();
        item = new JTextField();
        primaryType = new JTextField();
        secondaryType = new JTextField();
        move1 = new JTextField();
        move2 = new JTextField();
        move3 = new JTextField();
        move4 = new JTextField();
        baseStatTotal = new JTextField();
        add(new JLabel("Pokemon Name:"));
        add(pokemonName);
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
}

