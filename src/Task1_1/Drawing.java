package Task1_1;

import java.util.Scanner;

public class Drawing {

   private static final int MIDDLE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите символ: ");
        String s = sc.nextLine();
        int width = 5;
        while(width < MIDDLE){
            for (int i = 0; i < MIDDLE-width; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <= width*2+1; i++) {
                System.out.print(s);
            }
            System.out.println();
            width++;
        }

        while(width >5){
            for (int i = MIDDLE-1; i < MIDDLE*2-width; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < width*2; i++) {
                System.out.print(s);
            }
            System.out.println();
            width--;
        }
    }
}






