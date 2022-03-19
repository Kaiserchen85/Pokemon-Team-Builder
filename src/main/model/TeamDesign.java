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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        add(settingUp());
    }

    public JPanel settingUp() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3,2));
        jpanel.setSize(new Dimension(0, 0));
        for (int i = 0; i < pokemonTeam.getPokemonTeam().size(); i++) {
            setUpPokemon(pokemonTeam.getPokemonTeam().get(0));
            jpanel.add(setUpPokemon(pokemonTeam.getPokemonTeam().get(0)));
        }
        return jpanel;
    }

    public JPanel setUpPokemon(Pokemon pokemon) {
        JPanel jpanel = new JPanel();
        jpanel.add(new JLabel("Pokemon Name: " + pokemon.getName()));
        jpanel.add(new JLabel("Item: " + pokemon.getItem()));
        jpanel.add(new JLabel("Typings: " + pokemon.getPrimaryType() + "/" + pokemon.getSecondaryType()));
        jpanel.add(new JLabel("Moves: " + pokemon.getMoves()));
        jpanel.add(new JLabel("Base Stat Total: " + pokemon.getBaseStatTotal()));
        return jpanel;
    }
}
