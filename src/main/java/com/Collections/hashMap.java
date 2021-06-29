package com.Collections;

import org.testng.annotations.Test;

import java.util.HashMap;

public class hashMap {

    /*

    A HashMap however, store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).

    One object is used as a key (index) to another object (value).
    It can store different types: String keys and Integer values, or the same type, like: String keys and String values:

     */

    @Test
    public void hashMaps(){

        HashMap<String, Integer> hashings= new HashMap<String, Integer>();
        hashings.put("First", 1);
        hashings.put("Second", 2);
        hashings.put("Third", 3);
        hashings.put("Fourth", 4);
        System.out.println(hashings);

        hashings.get(3);
        System.out.println(hashings.get("third"));

        System.out.print("Size: "); System.out.println(hashings.size());
        System.out.print("Entry size: ");System.out.println(hashings.entrySet());
        System.out.print("Values: "); System.out.println(hashings.values());
        System.out.print("Contains key: ");System.out.println(hashings.containsKey("Third"));
        System.out.print("Is Empty: "); System.out.println(hashings.isEmpty());
        System.out.print("Clone: "); System.out.println(hashings.clone());
        HashMap<String, Integer> clones= (HashMap<String, Integer>) hashings.clone();
        System.out.println("Cloned data:" +clones);

        System.out.print("Replace: "); System.out.println(hashings.replace("Third",3, 33));
        System.out.print("Replace: "); System.out.println(hashings.values());
        System.out.print("Remove: "); System.out.println(hashings.remove("Third"));
        hashings.remove("Third");
        System.out.print("Values: "); System.out.println(hashings.values());
        hashings.clear();
        System.out.print("Values: "); System.out.println(hashings.values());


    }

}
