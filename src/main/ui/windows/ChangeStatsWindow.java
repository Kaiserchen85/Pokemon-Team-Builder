package ui.windows;

import model.Pokemon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

import static ui.windows.TeamBuilderWindow.FONT;

//Panel for changing the stats of Pokemon.
public class ChangeStatsWindow extends PokemonWindow {

    private Pokemon pokemon;

    //EFFECTS: Create Pokemon Window for changing stats.
    public ChangeStatsWindow(Pokemon pokemon, TeamBuilderWindow teamBuilderWindow) {
        super(teamBuilderWindow);
        this.pokemon = pokemon;
        createTextFields();
        JButton btn = new JButton("Ok");
        btn.addActionListener(this);
        btn.setFont(FONT);
        add(btn);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //EFFECTS: Changes Pokemon and updates on Team Builder Window.
    public void actionPerformed(ActionEvent e) {
        pokemon.addItem(item.getText());
        pokemon.addTyping(primaryType.getText(), secondaryType.getText());
        pokemon.getMoves().clear();
        pokemon.addMove(move1.getText());
        pokemon.addMove(move2.getText());
        pokemon.addMove(move3.getText());
        pokemon.addMove(move4.getText());
        pokemon.removeMove("");
        pokemon.setBaseStatTotal(Integer.parseInt(baseStatTotal.getText()));
        teamBuilderWindow.updatePokemonTeamDisplayPanel();
        dispose();
    }

    //EFFECTS: Create text and text field for window.
    public void createTextFields() {
        item.setText(pokemon.getItem());
        primaryType.setText(pokemon.getPrimaryType());
        secondaryType.setText(pokemon.getSecondaryType());
        setMove(move1, 0);
        setMove(move2, 1);
        setMove(move3, 2);
        setMove(move4, 3);
        baseStatTotal.setText(Integer.toString(pokemon.getBaseStatTotal()));
        createJLabelText("Pokemon Name: " + pokemon.getName());
        createJLabelText("Item: ");
        add(item);
        createJLabelText("Typing: ");
        add(primaryType);
        add(secondaryType);
        createJLabelText("Moves: ");
        add(move1);
        add(move2);
        add(move3);
        add(move4);
        createJLabelText("Base Stat Total: ");
        add(baseStatTotal);
    }

    //EFFECTS: Adds moves from inputted string.
    public void setMove(JTextField move, int index) {
        if (index < pokemon.getMoves().size()) {
            move.setText(pokemon.getMoves().get(index));
        }
    }
}

