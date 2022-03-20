package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeamDesign extends JPanel {
    private PokemonTeam pokemonTeam;

    public TeamDesign(PokemonTeam pokemonTeam) {
        super();
        this.pokemonTeam = pokemonTeam;
        setBackground(Color.darkGray);
        settingUp();
    }

    public void settingUp() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3,2));
        jpanel.setSize(new Dimension(200, 200));
        for (int i = 0; i < pokemonTeam.getPokemonTeam().size(); i++) {
            jpanel.add(setUpPokemon(pokemonTeam.getPokemonTeam().get(0)));
        }
        add(jpanel);
    }

    public JButton setUpPokemon(Pokemon pokemon) {
        JButton jbutton = new JButton();
        jbutton.setBorderPainted(true);
        jbutton.setFocusPainted(true);
        jbutton.setContentAreaFilled(true);
        jbutton.add(new JLabel("Pokemon Name: " + pokemon.getName()));
        jbutton.add(new JLabel("Item: " + pokemon.getItem()));
        jbutton.add(new JLabel("Typings: " + pokemon.getPrimaryType() + "/" + pokemon.getSecondaryType()));
        jbutton.add(new JLabel("Moves: " + pokemon.getMoves()));
        jbutton.add(new JLabel("Base Stat Total: " + pokemon.getBaseStatTotal()));
        return jbutton;
    }
}
