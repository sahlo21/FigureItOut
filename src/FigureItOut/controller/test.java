package FigureItOut.controller;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ArrayList<Integer> my_list = new ArrayList<Integer>();
        my_list.add(0);
        my_list.add(1);
        my_list.add(2);
        my_list.add(3);
        my_list.add(4);
        my_list.add(5);
        my_list.add(6);
        my_list.add(7);
        my_list.add(8);
        int i=0;
        int numR=0;
        while (i<my_list.size()){
            System.out.println(numR=(int) ((Math.random() * ((my_list.size()-1 - 0) + 1)) + 0));
            i++;
        }
    }

}
