package ui.buttons;

import model.PokemonTeam;
import model.WorkRoom;
import persistence.JsonReader;
import ui.windows.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadButton extends JButton {
    private static final String JSON_STORE = "./data/myFile.txt";

    private PokemonTeam pokemonTeam;
    private MainWindow mainWindow;
    private WorkRoom workRoom;
    private JsonReader jsonReader;

    public LoadButton(String label, PokemonTeam pokemonTeam, MainWindow mainWindow) {
        super(label);
        this.pokemonTeam = pokemonTeam;
        this.mainWindow = mainWindow;
        workRoom = new WorkRoom("Work Room");
        jsonReader = new JsonReader(JSON_STORE);
        setBorderPainted(true);
        setFocusPainted(true);
        setContentAreaFilled(true);
        addActionListener(new LoadTeamListener());
    }

    private class LoadTeamListener implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            // EFFECTS: Saves the workroom to file.
            try {
                workRoom = jsonReader.read();
                workRoom.addPokemonTeam(pokemonTeam);
                PokemonTeam cloneTeam = workRoom.getPokemonTeamList().get(0);
                pokemonTeam.changeName(cloneTeam.getTeamName());
                pokemonTeam.getPokemonTeam().clear();
                for (int i = 0; i < cloneTeam.getPokemonTeam().size(); i++) {
                    pokemonTeam.addPokemon(cloneTeam.getPokemonTeam().get(i));
                }
                mainWindow.remove(mainWindow.getTeamDesign());
                mainWindow.addNewDrawing();
                mainWindow.getTeamNameLabel().setText(pokemonTeam.getTeamName());
                mainWindow.revalidate();
                mainWindow.repaint();
                mainWindow.getTeamDesign().setIsRemovingFalse();
            } catch (IOException exception) {
                System.out.println("Error!");
            }
        }
    }
}
