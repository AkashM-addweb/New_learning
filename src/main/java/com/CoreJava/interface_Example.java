package com.CoreJava;

interface interface_Example {


            /*

    - Declare constant fields
    - Declare methods that abstract
    - By default.

 */


    String name = null;
    String email = null;
    double phone = 0;
    int id = 0;

    public void interface_Method_1();
    public void interface_Method_2();

}

class implemented implements interface_Example{


    @Override
    public void interface_Method_1() {

        System.out.println("This is the Implemented Method 1");


    }

    @Override
    public void interface_Method_2() {

        System.out.println("This is the implemented Method 2");

    }
}

class callOut{

    public static void main(String[] args){

        implemented impl= new implemented();
        impl.interface_Method_1();
        impl.interface_Method_2();

    }
}