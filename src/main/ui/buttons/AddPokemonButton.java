package ui.buttons;

import model.PokemonTeam;
import ui.windows.AddPokemonWindow;
import ui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPokemonButton extends PokemonButton {

    public AddPokemonButton(String label, PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super(label, pokemonTeam, mainWindow);
        addActionListener(new AddPokemonListener());
    }

    private class AddPokemonListener implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            if (getPokemonTeam().getPokemonTeam().size() < 6) {
                new AddPokemonWindow(getPokemonTeam(), getMainWindow());
            }
        }
    }
}
