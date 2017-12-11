package Task2.TaskUserArray;

import java.util.Scanner;

public class UserArray1 {

    private static int num;
    private static int c;
    private static int numB;
    private static int numMax;

        public static void main (String ... arg){

            Scanner s = new Scanner(System.in);

            int n = s.nextInt();
            int [] a = new int [n];
            int [] b = new int [n];

            for(int i=0;i<a.length;i++) {
                a[i]=s.nextInt();
            }
            for(int i=0;i<a.length;i++) {
                for(int j=i;j<a.length;j++) {
                    if(a[i]==a[j]) num++;
                }b[i]=num; num=0;
            }

            for (int aB : b) {

                if (aB == 1) numB++;
            }

            if(numB==b.length) System.out.println("Повторяющиеся элементы отсутствуют");

            else {
                int max = b[0];
                for(int i=0;i<b.length;i++) {
                    if(max <b[i]) {
                        max =b[i]; c=i;}
                }
                for (int aB : b) {
                    if (max == aB) {
                        numMax++;
                    }
                }
                if(numMax==1) {
                    System.out.println("Число "+a[c]+" встречается " + max +" раза");
                }

            }
        }
}

