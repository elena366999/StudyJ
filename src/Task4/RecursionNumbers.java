package Task4;

public class RecursionNumbers {

        public static int PartitionCount(int number, int limit) {
            if (limit == 0) {
                if (number == 0)
                    return 1;
                return 0;
            }
            if (limit <= number)
                return PartitionCount(number, limit - 1) +
                        PartitionCount(number - limit, limit);
            return PartitionCount(number, number);
        }

       public static void main(String[] args) {
            System.out.println(PartitionCount(5, 5));

       }
}


