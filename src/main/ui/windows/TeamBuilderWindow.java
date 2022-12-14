package ui.windows;

import model.Event;
import model.EventLog;
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
import java.awt.event.WindowAdapter;

//References SimpleDrawingPlayer-Complete
//Pokemon Team Builder GUI Application
public class TeamBuilderWindow extends JFrame implements ActionListener {

    public static final int WIDTH = 2000;
    public static final int HEIGHT = 1400;
    public static final Font FONT = new Font("Comic Sans", Font.BOLD, 20);

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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            //EFFECTS: Print event logged since the start of the application.
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                printLog(EventLog.getInstance());
                System.exit(0);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MODIFIES: This
    // EFFECTS:  Instantiates PokemonTeam with team name Team 1, make null Team Builder display panel.
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
        button.addActionListener(this);
        teamNameLabel = new JLabel(pokemonTeam.getTeamName());
        teamNameField = new JTextField(5);
        button.setFont(FONT);
        teamNameField.setFont(FONT);
        teamNameLabel.setFont(FONT);
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
        pokemonTeamDisplayPanel.setIsRemovingFalse();
    }

    //EFFECTS: Print logs stored.
    public void printLog(EventLog eventLog) {
        for (Event event : eventLog) {
            System.out.println(event.toString());
        }
    }

    public PokemonTeamDisplayPanel getPokemonTeamDisplayPanel() {
        return pokemonTeamDisplayPanel;
    }

    public JLabel getTeamNameLabel() {
        return teamNameLabel;
    }

    // EFFECTS: Changes Team Name on Team Builder Window and in Pokemon Team.
    @Override
    public void actionPerformed(ActionEvent e) {
        teamNameLabel.setText(teamNameField.getText());
        pokemonTeam.changeName(teamNameField.getText());
        pokemonTeamDisplayPanel.setIsRemovingFalse();
    }
}

