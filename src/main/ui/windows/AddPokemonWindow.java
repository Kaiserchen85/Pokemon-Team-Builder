package ui.windows;

import model.Pokemon;
import model.PokemonTeam;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

//Panel for adding Pokemon.
public class AddPokemonWindow extends PokemonWindow {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private PokemonTeam pokemonTeam;

    //EFFECTS: Creates window for adding Pokemon to Pokemon Team.
    public AddPokemonWindow(PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(teamBuilderWindow);
        this.pokemonTeam = pokemonTeam;
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

    //MODIFIES: TeamBuilderWindow
    //EFFECTS: Add Pokemon to Pokemon Team and reflect changes on Team Builder Window
    public void actionPerformed(ActionEvent e) {
        Pokemon pokemon = new Pokemon(pokemonName.getText());
        pokemon.addItem(item.getText());
        pokemon.addTyping(primaryType.getText(), secondaryType.getText());
        pokemon.addMove(move1.getText());
        pokemon.addMove(move2.getText());
        pokemon.addMove(move3.getText());
        pokemon.addMove(move4.getText());
        pokemon.removeMove("");
        pokemon.setBaseStatTotal(Integer.parseInt(baseStatTotal.getText()));
        pokemonTeam.addPokemon(pokemon);
        teamBuilderWindow.updatePokemonTeamDisplayPanel();
        dispose();
    }

    //EFFECTS: Create text and text field for window.
    public void createTextFields() {
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

