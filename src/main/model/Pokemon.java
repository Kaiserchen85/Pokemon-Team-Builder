package model;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private List<String> moves;
    private String item;
    private String type1;
    private String type2;
    private int baseStatTotal;

    //EFFECTS: name of Pokemon is set to name, Pokemon has no stats, items, moves or typing.
    public Pokemon(String name) {
        this.name = name;
        item = "None";
        type1 = "None";
        type2 = "None";
        baseStatTotal = 1;
        moves = new ArrayList<>();
    }

    //MODIFIES: This
    //EFFECTS: Adds a move into moves if not already present. Up to 4 moves allowed.
    public void addMove(String move) {
        if (!moves.contains(move) && moves.size() < 4) {
            moves.add(move);
        }
    }

    //MODIFIES: This
    //EFFECTS: Adds a move into moves if not already present.
    public void removeMove(String move) {
        if (moves.contains(move)) {
            moves.remove(move);
        }
    }

    //MODIFIES: This
    //EFFECTS: Adds item to the Pokemon, replaces previously held item.
    public void addItem(String item) {
        this.item = item;
    }

    //MODIFIES: This
    //EFFECTS: Removes item from Pokemon.
    public void removeItem() {
        this.item = "None";
    }

    //REQUIRES: Strings must be one of these 19 different strings:
    //          None, Normal, Water, Fire, Grass, Electric, Ground, Rock, Ice, Fighting, Fairy, Ghost
    //          Dark, Bug, Steel, Flying, Poison, Dragon, Psychic
    //          And both input strings cannot be None.
    //MODIFIES: This
    //EFFECTS: Adds typing to Pokemon.
    public void addTyping(String primaryType, String secondaryType) {
        if (primaryType.equals("None") && !secondaryType.equals("None")) {
            type1 = secondaryType;
            type2 = "None";
        } else {
            if (primaryType.equals(secondaryType)) {
                type1 = primaryType;
                type2 = "None";
            } else {
                type1 = primaryType;
                type2 = secondaryType;
            }
        }
    }

    //REQUIRES: integer must be >0.
    //MODIFIES: This
    //EFFECTS: Adds base stat total stat to Pokemon.
    public void setBaseStatTotal(int baseStatTotal) {
        this.baseStatTotal = baseStatTotal;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public List<String> getMoves() {
        return moves;
    }

    public String getPrimaryType() {
        return type1;
    }

    public String getSecondaryType() {
        return type2;
    }

    public int getBaseStatTotal() {
        return baseStatTotal;
    }
}
