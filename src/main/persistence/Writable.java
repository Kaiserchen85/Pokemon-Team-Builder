package persistence;

import org.json.JSONObject;

//References JsonSerializationDemo
public interface Writable {

    // EFFECTS: Returns this as JSON object
    JSONObject toJson();
}
