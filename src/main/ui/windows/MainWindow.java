package ui.windows;

import model.PokemonTeam;
import model.TeamDesign;
import ui.buttons.AddPokemonButton;
import ui.buttons.LoadButton;
import ui.buttons.RemovePokemonButton;
import ui.buttons.SaveButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private TeamDesign teamDesign;
    private PokemonTeam pokemonTeam;
    private JLabel teamNameLabel;
    private JTextField teamNameField;

    public MainWindow() {
        super("Pokemon Team Builder");
        initializeFields();
        initializeGraphics();
    }

    // getters
    public TeamDesign getTeamDesign() {
        return teamDesign;
    }

    public JLabel getTeamNameLabel() {
        return teamNameLabel;
    }

    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this DrawingEditor will operate, and populates the tools to be used
    //           to manipulate this drawing
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        add(teamNamePanel(), BorderLayout.NORTH);
        createButtons();
        addNewDrawing();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS:  sets activeTool, currentDrawing to null, and instantiates drawings and tools with ArrayList
    //           this method is called by the DrawingEditor constructor
    private void initializeFields() {
        teamDesign = null;
        pokemonTeam = new PokemonTeam("Team 1");
    }

    // MODIFIES: this
    // EFFECTS:  declares and instantiates a Drawing (newDrawing), and adds it to drawings
    public void addNewDrawing() {
        TeamDesign newDrawing = new TeamDesign(pokemonTeam, this);
        teamDesign = newDrawing;
        add(newDrawing, BorderLayout.CENTER);
        validate();
    }

    // MODIFIES: this
    // EFFECTS:  a helper method which declares and instantiates all tools
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

    private class ChangeTeamNameListener implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            teamNameLabel.setText(teamNameField.getText());
            pokemonTeam.changeName(teamNameField.getText());
            teamDesign.setIsRemovingFalse();
        }
    }
}

