package de.smartformer.hoang.remotecontroll.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.smartformer.hoang.remotecontroll.models.ConsumerModel;

/**
 * Created by hoang on 26.11.14.
 */
public class Utils {

    public static List<ConsumerModel> parseDeviceJSONArray(JSONArray jArray) throws JSONException {
        List<ConsumerModel> result = new ArrayList<ConsumerModel>();
        for(int i=0;i<jArray.length();i++){
            JSONObject jObj = jArray.getJSONObject(i);
            JSONObject keyJObj = jObj.getJSONObject("Controlls");
            Map<String, Integer> keyMap = toMap(keyJObj);
            result.add(new ConsumerModel(keyMap, jObj.getString("DeviceName"), jObj.getInt("DeviceId")));
        }
        return result;
    }

    public static ConsumerModel parseDeviceJSONObject(JSONObject jObj) throws JSONException {
        JSONObject keyJObj = jObj.getJSONObject("Controlls");
        Map<String, Integer> keyMap = toMap(keyJObj);
        return new ConsumerModel(keyMap, jObj.getString("DeviceName"), jObj.getInt("DeviceId"));
    }

    public static Map toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }


    public static List toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
