package ui;

import model.Pokemon;
import model.PokemonTeam;
import ui.windows.ChangeStatsWindow;
import ui.windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonTeamDisplayPanel extends JPanel {
    private PokemonTeam pokemonTeam;
    private MainWindow mainWindow;
    private boolean isRemoving;

    public PokemonTeamDisplayPanel(PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super();
        this.pokemonTeam = pokemonTeam;
        this.mainWindow = mainWindow;
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);
        settingUp();
        isRemoving = false;
    }

    public void settingUp() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3,2));
        jpanel.setSize(new Dimension(200, 200));
        for (int i = 0; i < pokemonTeam.getPokemonTeam().size(); i++) {
            JButton pokemonButton = setUpPokemon(pokemonTeam.getPokemonTeam().get(i));
            pokemonButton.setActionCommand(Integer.toString(i));
            pokemonButton.addActionListener(new AdjustPokemonListener());
            jpanel.add(pokemonButton);
        }
        add(jpanel);
    }

    public JButton setUpPokemon(Pokemon pokemon) {
        JButton jbutton = new JButton();
        JPanel jpanel = new JPanel();
        Color color = new Color(214, 248, 255);
        jbutton.setBorderPainted(true);
        jbutton.setFocusPainted(true);
        jbutton.setContentAreaFilled(true);
        jpanel.setLayout(new GridLayout(6, 1));
        jpanel.setBackground(color);
        jpanel.add(new JLabel(new ImageIcon("./data/egg.png")));
        jpanel.add(new JLabel("Pokemon Name: " + pokemon.getName()));
        jpanel.add(new JLabel("Item: " + pokemon.getItem()));
        jpanel.add(new JLabel("Typings: " + pokemon.getPrimaryType() + "/" + pokemon.getSecondaryType()));
        jpanel.add(new JLabel("Moves: " + pokemon.getMoves()));
        jpanel.add(new JLabel("Base Stat Total: " + pokemon.getBaseStatTotal()));
        jbutton.add(jpanel);
        return jbutton;
    }

    public void setIsRemovingTrue() {
        isRemoving = true;
    }

    public void setIsRemovingFalse() {
        isRemoving = false;
    }

    private class AdjustPokemonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = Integer.parseInt(e.getActionCommand());
            if (!isRemoving) {
                new ChangeStatsWindow(pokemonTeam.getPokemonTeam().get(index), mainWindow);
            } else {
                pokemonTeam.removePokemon(index);
                mainWindow.updatePokemonTeamDisplayPanel();
            }
        }
    }
}
