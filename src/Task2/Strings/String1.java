package Task2.Strings;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String1 {

    public static void main(String[] args) {

        String1 string1 = new String1();
        String s = string1.getString();
        System.out.println("Original string is "+s);

        System.out.println(string1.deleteSymbols(s));

        System.out.println(string1.getMaxLengthOfNonLetterSequence(s));

        deleteAllBs(s);

        System.out.println(string1.getNumberOfVowels(s));

        deleteWordsInEvenPositions(s);

        System.out.println(string1.deletePartsBetweenQuotes(s));
    }

    private String deleteSymbols(String s) {
        String stringtoProcess =s;
        stringtoProcess = stringtoProcess.replaceAll("[^a-zA-Z0-9а-яА-Я]", ""); //\W
        return stringtoProcess;
    }

    private int getMaxLengthOfNonLetterSequence(String s) {
        Pattern p = Pattern.compile("[^a-zа-яa-zA-Z]+");
        Matcher m = p.matcher(s);
        int countMax = 0;

        while (m.find()){
            System.out.println(m.start());
            System.out.println(m.end());
            if (countMax<(m.end()-m.start())){
                countMax=m.end()-m.start();
            }
        }
        return countMax;
    }

    public static void deleteAllBs(String s) {
        String[] arr = s.split("");
        for (int i = 0; i < arr.length - 1; i++) {
        if (Pattern.matches("[b]", arr[i]) & Pattern.matches("\\d+", arr[i + 1])) {
            arr = ArrayUtils.remove(arr, i);
        }
    }
        for (String anArr : arr) {
            System.out.print(anArr + " ");
        }
}

    private int getNumberOfVowels(String s) {
        Pattern vocals = Pattern.compile("(?iu)[a-zа-я&&[аеёиоуыэюяyeiaou]]");
        Matcher m = vocals.matcher(s);
        int vocalCounter = 0;
            while (m.find()) {
            vocalCounter++;
        }
            return vocalCounter;
    }

    public static void deleteWordsInEvenPositions(String s) {
        String[] words = s.split("[\\s]++");//splits the string based on whitespace
             for (int i = 0; i < words.length; i++) {
                    if (i % 2 == 0)
                System.out.print(words[i]+",");
        }
    }

    private String deletePartsBetweenQuotes(String s) {
        String string2;
        string2 = s.replaceAll("\".*?\"", "");
        return string2;
     }

    public Scanner sc = new Scanner(System.in);

    private String getString() {
        System.out.print("Enter your string: ");
        return sc.nextLine();
    }
}
