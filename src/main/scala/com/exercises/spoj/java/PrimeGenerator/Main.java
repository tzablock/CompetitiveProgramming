package com.exercises.spoj.java.PrimeGenerator;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main
{
    public static void main (String[] args) throws Exception
    {
        Predicate<Integer> isPrime = n -> n != 1 && IntStream.range(2,(int) Math.sqrt(n) + 1).noneMatch(sn -> n%sn == 0);
        Function<String[], List<String>> findPrimesInBounds =
                b -> IntStream.range(Integer.valueOf(b[0]), Integer.valueOf(b[1]) +1).boxed().filter(
                        isPrime
                ).map(Object::toString).collect(Collectors.toList());
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        IntStream.range(0,t).boxed().map(
                                           i -> sc.nextLine()
                                   ).map(
                                           l -> l.split(" ")
                                   ).map(
                                           findPrimesInBounds
                                   ).forEach(
                                           l -> {l.add(" "); l.forEach(System.out::println);}
                                   );
    }
}

