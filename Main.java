import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(prime_recursive(5));
        System.out.println(prime(5));
        System.out.println(fib(5));
        System.out.println(fib_recursive(5));
    }

    static ArrayList<Integer> prime_recursive(int n){
        if(n <= 1){
            throw new IllegalArgumentException("Number should be higher than 1");
        }
        if(n==2){
            return new ArrayList<Integer>(List.of(2));
        }
        ArrayList<Integer> list = prime_recursive(n-1);
        for (int i : list){
            if (n%i == 0){
                return list;
            }
        }
        list.add(n);
        return list;
    }
    static ArrayList<Integer> prime(int n){
        if(n <= 1){
            throw new IllegalArgumentException("Number should be higher than 1");
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int flg;
        for (int i = 2; i <= n; i++){
            flg = 1;
            for (int j : list){
                if (i%j == 0){
                    flg = 0;
                    break;
                }
            }
            if (flg == 1){
                list.add(i);
            }
        }
        return list;
    }

    static int fib_recursive(int n){
        if(n < 0){
            throw new IllegalArgumentException("Number should be positive");
        }
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        return fib_recursive(n-1) + fib_recursive(n-2);
    }

    static int fib(int n){
        if(n < 0){
            throw new IllegalArgumentException("Number should be positive");
        }
        if (n == 1){
            return 1;
        }
        int result = 0;
        int first = 0;
        int second = 1;
        for (int i = 1; i < n; i ++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}