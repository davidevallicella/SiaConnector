package it.cs.sia.config;

import java.util.List;

/**
 * Created by Davide Vallicella on 31/05/2017.
 */
public interface Config {
    String get(Key key);

    String get(Key key, String defaultValue);

    List<String> getList(Key key);

    Integer getInt(Key key);

    List<Integer> getIntList(Key key);

    interface Key {
    }
}
