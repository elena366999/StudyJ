package Task1_5;

import java.util.Scanner;

public class BrickPass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину кирпича а: ");
        int a = sc.nextInt();
        System.out.println("Введите ширину кирпича b: ");
        int b = sc.nextInt();
        System.out.println("Введите высоту кирпича c: ");
        int c = sc.nextInt();
        System.out.println("Введите длину отверстия l: ");
        int l = sc.nextInt();
        System.out.println("Введите высоту отверстия h: ");
        int h = sc.nextInt();

        switch ( (b < l) && (c < h) ? 1 : (a < l) && (c < h) ? 2 : (a < l) && ( b < h) ? 3 : 0 )
        {
            case 1  : {System.out.println("Кирпич пройдет через отверстие"); break; }
            case 2  : {System.out.println("Кирпич пройдет через отверстие"); break; }
            case 3  : {System.out.println("Кирпич пройдет через отверстие"); break; }
            default : {System.out.println("Кирпич не пройдет через отверстие"); break; }
        }
    }
}

