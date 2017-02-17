package a.sharafutdinov;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by innopolis on 08.02.17.
 */
public class Counter {
    private String text;

    private volatile HashMap<String, Integer> map = new HashMap<String, Integer>();

    public synchronized void printCount(String word) {


        if(!map.containsKey(word)){
            map.put(word,0);
        }
        map.put(word, map.get(word) +1 );

        System.out.println(map);
        System.out.println("---");



        }
}
