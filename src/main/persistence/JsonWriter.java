package persistence;

import model.WorkRoom;
import org.json.JSONObject;


import java.io.*;

//References JsonSerializationDemo JsonWriter Class.
// Represents a writer that writes JSON representation of workroom to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: Constructs writer to write to destination file.
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: This
    // EFFECTS: Opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing.
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: This
    // EFFECTS: Writes JSON representation of workroom to file.
    public void write(WorkRoom wr) {
        JSONObject json = wr.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: This
    // EFFECTS: Closes writer.
    public void close() {
        writer.close();
    }

    // MODIFIES: This
    // EFFECTS: Writes string to file.
    private void saveToFile(String json) {
        writer.print(json);
    }
}
