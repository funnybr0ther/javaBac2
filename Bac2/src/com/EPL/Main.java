package com.EPL;

public class Main {
    public static int variable = 0;

    public static int[] squares;

    public static void attribute (int value){
        variable=value;
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static boolean equalsIntegers(int a, int b){
        return a == b;
    }
    public static int middleValue(int a, int b, int c){
        if ((a<b && b<c) || (a>b && b>c)){
            return b;
        }
        else if((a<c && c<b) || (a>c && c>b)){
            return c;
        }
        else if((b<a && a<c) || (b>a && a>c)){
            return a;
        }
        else {
            return -1;
        }
    }
    public static int max(int a, int b){
        return a>b ? a:b;
    }

    public static String greetings(String str){
        switch(str){
            case "Morning":
                return "Good morning, sir!";
            case "Evening":
                return "Good evening, sir!";
            default:
                return "Hello, sir!";
        }
    }

    public static int[] lastFirstMiddle(int[] a){
        int[] hey = {a[0],a[a.length/2],a[a.length-1]};
        return hey;
    }

    public static int sum(int[] array){
        int summ = 0;
        for (int item:array){
            summ += item;
        }
        return summ;
    }
    public static int maxArray(int[] array){
        int max = array[0];
        int i = 0;
        int lent = array.length;
        while (i<=lent-1){
            if (array[i]>=max){
                max=array[i];
            }
        }
        return max;
    }

    public static void main(String[] val) {
//        squares = new int[val.length];
//        for (int i = 0; i<= squares.length; i++){
//            try {
//                int key_value= Integer.parseInt(val[i]);
//                squares[i] = key_value*key_value;
//            } catch (NumberFormatException e) {
//            }
//
//        }
        int[] list = {1,2,3,4,5,6};
        for(int item:list){
            list[1] = item;
            for(int item1:list){
                list[0]=item1;
            }
        }
    }

}
