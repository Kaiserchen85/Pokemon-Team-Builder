package persistence;

import org.json.JSONObject;

//References JsonSerializationDemo Writable interface.
public interface Writable {

    // EFFECTS: Returns this as JSON object.
    JSONObject toJson();
}
