package ui.windows;

import model.PokemonTeam;
import ui.PokemonTeamDisplayPanel;
import ui.buttons.AddPokemonButton;
import ui.buttons.LoadButton;
import ui.buttons.RemovePokemonButton;
import ui.buttons.SaveButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Pokemon Team Builder Application
public class TeamBuilderWindow extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private PokemonTeamDisplayPanel pokemonTeamDisplayPanel;
    private PokemonTeam pokemonTeam;
    private JLabel teamNameLabel;
    private JTextField teamNameField;

    //EFFECTS: Creates Team Builder Window.
    public TeamBuilderWindow() {
        super("Pokemon Team Builder");
        initializeFields();
        initializeGraphics();
    }

    // MODIFIES: This
    // EFFECTS:  Creates the JFrame window where this window will operate, add buttons and panels to JFrame.
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        add(teamNamePanel(), BorderLayout.NORTH);
        createButtons();
        makePokemonTeamDisplayPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS:  sets activeTool, currentDrawing to null, and instantiates drawings and tools with ArrayList
    //           this method is called by the DrawingEditor constructor
    private void initializeFields() {
        pokemonTeamDisplayPanel = null;
        pokemonTeam = new PokemonTeam("Team 1");
    }

    // MODIFIES: This
    // EFFECTS:  Declares and instantiates a Team Builder display panel, and adds it to this.
    public void makePokemonTeamDisplayPanel() {
        PokemonTeamDisplayPanel newDrawing = new PokemonTeamDisplayPanel(pokemonTeam, this);
        pokemonTeamDisplayPanel = newDrawing;
        add(newDrawing, BorderLayout.CENTER);
        validate();
    }

    // MODIFIES: This
    // EFFECTS:  A helper method which declares and instantiates all buttons.
    private void createButtons() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(0,1));
        toolArea.setSize(new Dimension(0, 0));
        JButton addPkmnButton = new AddPokemonButton("Add Pokemon", pokemonTeam, this);
        JButton removePkmnButton = new RemovePokemonButton("Remove Pokemon", pokemonTeam, this);
        JButton saveButton = new SaveButton("Save", pokemonTeam, this);
        JButton loadButton = new LoadButton("Load", pokemonTeam, this);
        toolArea.add(addPkmnButton);
        toolArea.add(removePkmnButton);
        toolArea.add(saveButton);
        toolArea.add(loadButton);
        add(toolArea, BorderLayout.SOUTH);
    }

    //EFFECTS: Create Team Name Panel at top of Team Builder Window.
    private JPanel teamNamePanel() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new FlowLayout());
        JButton button = new JButton("Change Team Name");
        button.addActionListener(new ChangeTeamNameListener());
        teamNameLabel = new JLabel(pokemonTeam.getTeamName());
        teamNameField = new JTextField(5);
        jpanel.add(teamNameField);
        jpanel.add(button);
        jpanel.add(teamNameLabel);
        return jpanel;
    }

    //MODIFIES: This
    //EFFECTS: Remakes Pokemon Team display panel with updated changes.
    public void updatePokemonTeamDisplayPanel() {
        remove(pokemonTeamDisplayPanel);
        makePokemonTeamDisplayPanel();
        revalidate();
        repaint();
        pokemonTeamDisplayPanel.setIsRemovingFalse();
    }

    public PokemonTeamDisplayPanel getPokemonTeamDisplayPanel() {
        return pokemonTeamDisplayPanel;
    }

    public JLabel getTeamNameLabel() {
        return teamNameLabel;
    }

    private class ChangeTeamNameListener implements ActionListener {

        // EFFECTS: Changes Team Name on Team Builder Window and in Pokemon Team.
        @Override
        public void actionPerformed(ActionEvent e) {
            teamNameLabel.setText(teamNameField.getText());
            pokemonTeam.changeName(teamNameField.getText());
            pokemonTeamDisplayPanel.setIsRemovingFalse();
        }
    }
}

