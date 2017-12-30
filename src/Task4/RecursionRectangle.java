package Task4;

public class RecursionRectangle {

    public static int countSquares(int a, int b, int count) {
        if (a > 0 && b>0) {
            if (a > b)
            {a = a - b;}
            else
            {b =  b - a;}
            count++;
            return countSquares(a, b, count);
        }
        return count;
       }

    public static void main(String[] args) {
        System.out.println(countSquares(10, 3, 0));

    }
}


