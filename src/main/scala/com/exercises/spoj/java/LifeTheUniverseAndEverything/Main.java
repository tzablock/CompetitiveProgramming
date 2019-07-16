package com.exercises.spoj.java.LifeTheUniverseAndEverything;

import java.util.*;
import java.lang.*;

class Main // OK
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int in = 0;
        while (in != 42){
            in = sc.nextInt();
            if (in != 42){
                System.out.println(in);
            }
        }
    }
}
