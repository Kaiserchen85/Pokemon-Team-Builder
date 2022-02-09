package ui;

import model.Pokemon;
import model.PokemonTeam;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//Reference code from TellerApp application.

public class TeamBuilderApp {
    private PokemonTeam pokemonTeam;
    private Scanner input;

    //EFFECTS: Runs the team builder application
    public TeamBuilderApp() {
        runTeamBuilder();
    }

    //MODIFIES: This
    //EFFECTS: Processes user input for opening menu.
    private void runTeamBuilder() {
        boolean keepGoing = true;
        String command = null;

        initialize();

        System.out.println("Hello! Welcome to the Pokemon Team Builder App!");
        System.out.println("Let's start by naming your team! Please enter a name for your team:");
        command = input.next();
        pokemonTeam.changeName(command);
        System.out.println("Great! " + pokemonTeam.getTeamName() + " is a wonderful team name!");
        System.out.println("Now that we have a team name...");

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processDisplayMenuCommand(command);
            }
        }

        System.out.println("Thank you for visiting! See you next time!");
    }

    //MODIFIES: This
    //EFFECTS: Initializes Pokemon team
    private void initialize() {
        pokemonTeam = new PokemonTeam("");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //EFFECTS: Displays menu of options for users about the Pokemon Team
    private void displayMenu() {
        System.out.println("Please select and enter:");
        System.out.println("\ta -> Add Pokemon");
        System.out.println("\tr -> Remove Pokemon");
        System.out.println("\tc -> Change Team Name");
        System.out.println("\ti -> Get Info on Team");
        System.out.println("\tq -> Quit");
    }

    //MODIFIES: This
    //EFFECTS: Processes user input to do appropriate tasks.
    private void processDisplayMenuCommand(String command) {
        if (command.equals("a")) {
            addingPokemon();
        } else if (command.equals("r")) {
            removePokemon();
        } else if (command.equals("c")) {
            changingName();
        } else if (command.equals("i")) {
            getInfo();
        } else {
            System.out.println("That wasn't one of the choices I gave...");
            System.out.println("Let's try again!");
        }
    }

    //MODIFIES: This
    //EFFECTS: Adds a Pokemon to Pokemon Team.
    private void addingPokemon() {
        System.out.println("Please enter a Pokemon name (i.e. Snorlax, Vaporeon):");
        String name = input.next();
        Pokemon pokemon = new Pokemon(name);
        addingItem(pokemon);
        System.out.println("Hmm...");
        changingType(pokemon);
        System.out.println("Now let's add the moves! Remember, a Pokemon can only have 4 unique moves!");
        addPokemonMoves(pokemon);
        updateBaseStatTotal(pokemon);
        System.out.println("Great, I think that's it! Pokemon added to the team!");
        pokemonTeam.addPokemon(pokemon);
    }

    //MODIFIES: Pokemon
    //EFFECTS: Adds Item to Pokemon.
    private void addingItem(Pokemon pokemon) {
        System.out.println("Please enter an item:");
        System.out.println("If you don't want to add an item, please enter: None");
        String item = input.next();
        pokemon.addItem(item);
    }

    //REQUIRES:
    //MODIFIES: Pokemon
    //EFFECTS: Adds/Changes Typing of Pokemon.
    private void changingType(Pokemon pokemon) {
        System.out.println("Can you tell what typing it is? If there is only one type, "
                + "type None as one of the options!");
        String type1 = input.next();
        String type2 = input.next();
        pokemon.addTyping(type1, type2);
    }

    //MODIFIES: Pokemon
    //EFFECTS: Adding Moves to Pokemon.
    private void addPokemonMoves(Pokemon pokemon) {
        boolean wantAddMoves = true;
        System.out.println("Please enter a move:");
        String move = input.next();
        pokemon.addMove(move);
        while (pokemon.getMoves().size() < 4 && wantAddMoves) {
            System.out.println("Please enter a move:");
            System.out.println("If you want to stop adding moves now, please input: stop");
            move = input.next();
            if (move.equalsIgnoreCase("stop")) {
                wantAddMoves = false;
            } else {
                if (!pokemon.addMove(move)) {
                    System.out.println("Move has already been added!");
                }
            }
        }
    }

    //MODIFIES: Pokemon
    //EFFECTS: Updates Base Stat Total of Pokemon.
    private void updateBaseStatTotal(Pokemon pokemon) {
        System.out.println("Darn! I forgot, what was it's Base Stat Total again?");
        System.out.println("I know it is a POSITIVE INTEGER, but I can't remember which. Can you tell me?");
        int stats = input.nextInt();
        pokemon.setBaseStatTotal(stats);
    }

    //MODIFIES: This
    //EFFECTS: Removes Pokemon from Pokemon Team.
    private void removePokemon() {
        displayPokemonTeam();
        System.out.println("Which pokemon would you like to remove? Please enter associated integer:");
        int index = input.nextInt();
        if (pokemonTeam.removePokemon(index)) {
            System.out.println("Removed Successfully!");
        } else {
            System.out.println("Removal Failed...");
        }
    }

    //EFFECTS: Displays the Pokemon in Pokemon Team.
    private void displayPokemonTeam() {
        System.out.println(pokemonTeam.getTeamName() + ":");
        int pokemonNumber = 0;
        for (Pokemon p : pokemonTeam.getPokemonTeam()) {
            System.out.println(pokemonNumber + " -> "
                    + p.getName() + " - " + p.getPrimaryType() + "/" + p.getSecondaryType() + ": "
                    + p.getMoves().toString());
            System.out.println("Item: " + p.getItem() + ", BST: " + p.getBaseStatTotal());
            pokemonNumber += 1;
        }
        System.out.println("Total BST: " + pokemonTeam.getStatTotalOfTeam());
    }

    //MODIFIES: This
    //EFFECTS: Change Name of Pokemon Team.
    private void changingName() {
        System.out.println("It seems you dislike your current team name. What would you like to change it to?");
        String name = input.next();
        pokemonTeam.changeName(name);
        System.out.println("That name definitely sounds better! Your new team name is " + pokemonTeam.getTeamName()
                + ".");
    }

    //EFFECTS: Processes uesr input for InfoMenu.
    private void getInfo() {
        boolean keepGoing = true;
        while (keepGoing) {
            infoMenu();
            String command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processInfoMenuCommand(command);
            }
        }
    }

    //EFFECTS: Displays user options for more info on the Pokemon Team.
    private void infoMenu() {
        System.out.println("Please select and enter:");
        System.out.println("\tv -> View Pokemon Team");
        System.out.println("\ti -> Change Pokemon Item");
        System.out.println("\ta -> Add Pokemon Move");
        System.out.println("\tr -> Remove Pokemon Move");
        System.out.println("\tt -> Change Pokemon Typing");
        System.out.println("\ts -> Change Pokemon Stats");
        System.out.println("\tq -> Quit this Menu");
    }

    //EFFECTS: Processes user input for infoMenu.
    private void processInfoMenuCommand(String command) {
        if (command.equals("v")) {
            displayPokemonTeam();
        } else if (command.equals("i")) {
            addingItem(pokemonTeam.getPokemonTeam().get(pickPokemon()));
        } else if (command.equals("a")) {
            int index = pickPokemon();
            if (pokemonTeam.getPokemonTeam().get(index).getMoves().size() == 4) {
                System.out.println("This Pokemon cannot learn any more moves!");
            } else {
                addPokemonMoves(pokemonTeam.getPokemonTeam().get(index));
            }
        } else if (command.equals("r")) {
            removePokemonMove(pokemonTeam.getPokemonTeam().get(pickPokemon()));
        } else if (command.equals("t")) {
            changingType(pokemonTeam.getPokemonTeam().get(pickPokemon()));
        } else if (command.equals("s")) {
            updateBaseStatTotal(pokemonTeam.getPokemonTeam().get(pickPokemon()));
        } else {
            System.out.println("That wasn't one of the choices I gave...");
            System.out.println("Hmph! Let's try again!");
        }
    }

    //EFFECTS: Prompts user to pick a specific Pokemon on the current Pokemon team.
    private int pickPokemon() {
        boolean invalidPokemonIndex = true;
        displayPokemonTeam();
        int pokemonNumber = 0;
        while (invalidPokemonIndex) {
            System.out.println("Which Pokemon would you like to change up?");
            pokemonNumber = input.nextInt();
            if (pokemonNumber >= pokemonTeam.getPokemonTeam().size()) {
                System.out.println("Sorry, that's invalid... try again.");
            } else {
                invalidPokemonIndex = false;
            }
        }
        return pokemonNumber;
    }

    //MODIFIES: This
    //EFFECTS: Removes move from given Pokemon if it knows the move.
    private void removePokemonMove(Pokemon pokemon) {
        System.out.println(pokemon.getMoves().toString());
        System.out.println("Which move do you want to remove?");
        String move = input.next();
        if (pokemon.removeMove(move)) {
            System.out.println("1.. 2.. 3.. Tada! Your Pokemon forgot " + move + "!");
        } else {
            System.out.println("I'm sorry... I don't think your Pokemon even knows this move...");
        }
    }
}