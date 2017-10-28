package hackathonayush.mentor.Model;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

import hackathonayush.mentor.network.ItemResponse;
import hackathonayush.mentor.network.ListResponse;

/**
 * Created by user on 26-Aug-17.
 */

public class JsonParsing {

    private JsonParsing() {
    }

    public static <T> String ToString(ListResponse<T> response) {
        List<T> list = response.getData();
        Gson gson = new Gson();
        String jsonToString = gson.toJson(list);
        return jsonToString;
    }

    public static <T> String ToString(ItemResponse<T> response) {
        T list = response.getData();
        Gson gson = new Gson();
        String jsonToString = gson.toJson(list);
        return jsonToString;
    }

    public static <T> List<T> ToList(String jsonString, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, type);
    }


}
