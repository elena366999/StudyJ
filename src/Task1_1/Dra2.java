package Task1_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dra2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите любой символ: ");
        char c = sc.next().charAt(0);
        String s = String.valueOf(c);
        String[] array = new String[7];;
        for (int i = 0; i < array.length; i++) {
            array[i] = s;
        }
        String s2 = Arrays.stream(array).collect(Collectors.joining());
        System.out.printf("%20s\n",s2);
        System.out.printf("%19s%s%s\n",s2, s, s);
        System.out.printf("%18s%s%s%s%s\n",s2, s, s,s,s);
        System.out.printf("%17s%s%s%s%s%s%s\n",s2, s, s,s,s,s,s);
        System.out.printf("%16s%s%s%s%s%s%s%s%s\n",s2, s, s,s,s,s,s,s,s);
        System.out.printf("%17s%s%s%s%s%s%s\n",s2, s, s,s,s,s,s);
        System.out.printf("%18s%s%s%s%s\n",s2, s, s,s,s);
        System.out.printf("%19s%s%s\n",s2, s, s);
        System.out.printf("%20s\n",s2);
    }
    }
