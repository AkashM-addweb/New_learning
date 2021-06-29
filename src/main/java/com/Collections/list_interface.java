package com.Collections;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class list_interface {

//    List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack.

    @Test
    public void arrayList() {

        ArrayList<String> strings = new ArrayList<String>();

        strings.add("Volvo");
        strings.add("Cars");
        strings.add("are the best");

        System.out.println(strings);

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.remove(3);
        System.out.println(numbers.get(2));

        System.out.println(numbers);

        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        for(int i=30; i<50 ; i++){
            numbers2.add(i);
        }

        System.out.println(numbers2);
    }


    @Test
    public void linkedList(){

        LinkedList<String> listStrings= new LinkedList<String>();

        listStrings.add("1st");
        listStrings.add("2nd");
        listStrings.addFirst("0th");
        listStrings.addLast("6th");
        listStrings.add("3rd");
        listStrings.add("4th");
        System.out.println(listStrings);

    }
}
