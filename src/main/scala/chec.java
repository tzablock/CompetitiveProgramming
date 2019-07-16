import java.util.Scanner;
import java.util.stream.IntStream;

public class chec {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        IntStream.range(0,t).boxed()
                .map(i -> sc.nextLine())
                .forEach(System.out::println);
    }
}
