package ui;

import model.Pokemon;
import model.PokemonTeam;
import ui.windows.ChangeStatsWindow;
import ui.windows.TeamBuilderWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.windows.TeamBuilderWindow.FONT;

//Panel for displaying Pokemon.
public class PokemonTeamDisplayPanel extends JPanel implements ActionListener {

    private PokemonTeam pokemonTeam;
    private TeamBuilderWindow teamBuilderWindow;
    private boolean isRemoving;

    //EFFECTS: Create panel for displaying Pokemon Team.
    public PokemonTeamDisplayPanel(PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super();
        this.pokemonTeam = pokemonTeam;
        this.teamBuilderWindow = teamBuilderWindow;
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);
        settingUp();
        isRemoving = false;
    }

    //EFFECTS: Create panel of Pokemon Buttons.
    public void settingUp() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3,2));
        jpanel.setSize(new Dimension(200, 200));
        for (int i = 0; i < pokemonTeam.getPokemonTeam().size(); i++) {
            JButton pokemonButton = setUpPokemon(pokemonTeam.getPokemonTeam().get(i));
            pokemonButton.setActionCommand(Integer.toString(i));
            pokemonButton.addActionListener(this);
            jpanel.add(pokemonButton);
        }
        add(jpanel);
    }

    //EFFECTS: Create button for Pokemon.
    public JButton setUpPokemon(Pokemon pokemon) {
        JButton jbutton = new JButton();
        JPanel jpanel = new JPanel();
        Color color = new Color(214, 248, 255);
        jbutton.setBorderPainted(true);
        jbutton.setFocusPainted(true);
        jbutton.setContentAreaFilled(true);
        jpanel.setLayout(new GridLayout(6, 1));
        jpanel.setBackground(color);
        ImageIcon miniEgg = new ImageIcon("./data/egg.png");
        ImageIcon newEgg = new ImageIcon(miniEgg.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        JLabel egg = new JLabel(newEgg);
        jpanel.add(egg);
        createJLabelText(jpanel, "Pokemon Name: " + pokemon.getName());
        createJLabelText(jpanel, "Item: " + pokemon.getItem());
        createJLabelText(jpanel, "Typing: " + pokemon.getPrimaryType() + "/" + pokemon.getSecondaryType());
        createJLabelText(jpanel, "Moves: " + pokemon.getMoves());
        createJLabelText(jpanel, "Base Stat Total: " + pokemon.getBaseStatTotal());
        jbutton.add(jpanel);
        return jbutton;
    }

    //EFFECTS: Adds text onto window.
    public void createJLabelText(JPanel jpanel, String message) {
        JLabel text = new JLabel(message);
        text.setFont(FONT);
        jpanel.add(text);
    }

    public void setIsRemovingTrue() {
        isRemoving = true;
    }

    public void setIsRemovingFalse() {
        isRemoving = false;
    }

    //MODIFIES: This
    //EFFECTS: Removes Pokemon from panel and Pokemon Team if isRemoving is true,
    //         otherwise open ChangeStatsWindow.
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = Integer.parseInt(e.getActionCommand());
        if (!isRemoving) {
            new ChangeStatsWindow(pokemonTeam.getPokemonTeam().get(index), teamBuilderWindow);
        } else {
            pokemonTeam.removePokemon(index);
            teamBuilderWindow.updatePokemonTeamDisplayPanel();
        }
    }
}
