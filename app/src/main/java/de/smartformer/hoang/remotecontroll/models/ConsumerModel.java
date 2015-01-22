package de.smartformer.hoang.remotecontroll.models;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hoang on 26.11.14.
 */
public class ConsumerModel implements Serializable{


    private Map<String, Integer> keyCodeMap;
    private String name;
    private int id;

    public ConsumerModel(Map<String, Integer> keyCodeMap, String name, int id) {
        this.keyCodeMap = keyCodeMap;
        this.name = name;
        this.id = id;
    }

    public Map<String, Integer> getKeyCodeMap() {
        return keyCodeMap;
    }

    public void setKeyCodeMap(Map<String, Integer> keyCodeMap) {
        this.keyCodeMap = keyCodeMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
