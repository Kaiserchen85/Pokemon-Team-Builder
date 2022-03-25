package ui.windows;

import model.Pokemon;
import model.PokemonTeam;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static ui.windows.TeamBuilderWindow.FONT;

//Panel for adding Pokemon.
public class AddPokemonWindow extends PokemonWindow {

    private PokemonTeam pokemonTeam;

    //EFFECTS: Creates window for adding Pokemon to Pokemon Team.
    public AddPokemonWindow(PokemonTeam pokemonTeam, TeamBuilderWindow teamBuilderWindow) {
        super(teamBuilderWindow);
        this.pokemonTeam = pokemonTeam;
        createTextFields();
        JButton button = new JButton("Ok");
        button.addActionListener(this);
        button.setFont(FONT);
        add(button);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //EFFECTS: Create text and text field for window.
    public void createTextFields() {
        createJLabelText("Pokemon Name: ");
        add(pokemonName);
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
}

