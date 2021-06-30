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
//        numbers.addAll();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.remove(3);
        System.out.println(numbers.get(2));
        System.out.println(numbers);

        ArrayList<Integer> integers3= new ArrayList<Integer>();
        integers3.addAll(numbers);
        System.out.println("Add All() Functionality:" + integers3);
        integers3.addAll(3,numbers);
        System.out.println(integers3);
        System.out.println( integers3.addAll(3,numbers));

        System.out.println("<-=--=====------------------------------>-");
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

    @Test
    public void arrayListPrograms(){

        ArrayList<Integer> listElements= new ArrayList<Integer>();
        Boolean checkList= listElements.isEmpty();
        System.out.println(checkList);

        listElements.ensureCapacity(5);

        listElements.add(0);
        listElements.add(1);
        listElements.add(2);
        listElements.add(3);
        listElements.add(4);
        listElements.add(5);
        listElements.add(6);
        listElements.add(7);
        listElements.add(8);
        listElements.add(9);
        listElements.add(10);
        List<Integer> subList= listElements.subList(4,8);
        System.out.println(subList);

        int codes= listElements.hashCode();
        listElements.ensureCapacity(15);
        System.out.println(listElements);

    }
    }