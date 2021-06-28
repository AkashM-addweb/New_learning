package com.CoreJava;

abstract class abstact_Example {

    String name;
    String email;
    double phone;
    int id;

    /*
     * An abstract class is a class that is declared abstract
     * It may or may not include abstract methods
     * Abstract classes cannot be instantiated, but they can be subclassed
     *
     */

    //Non Abstract function
    public void abstractAndInterface(){
        System.out.println("This is the Non abstract class");
        System.out.println("email: "+ email);
    }

    //Abstract function
    public abstract void abstractFunction();

}

class extendedClass extends abstact_Example{

    @Override
    public void abstractFunction() {

        System.out.println("This is the Overrided Abstract function");
        System.out.println("email: "+ email);
    }
}

class abstractDemo{

    public static void main(String [] args){

        extendedClass e= new extendedClass();
        e.abstractFunction();
        e.abstractAndInterface();
        e.email= "demo@gmail.com";

    }
}