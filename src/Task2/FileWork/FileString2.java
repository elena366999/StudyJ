package Task2.FileWork;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileString2 {

    public static void main(String[] args) throws IOException {
        String fileName1 = "C:\\Users\\Лена\\IdeaProjects\\StudyJ\\src\\Task2\\FileWork\\File1";
        String fileName2 = "C:\\Users\\Лена\\IdeaProjects\\StudyJ\\src\\Task2\\FileWork\\File2";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value: ");
        int n = sc.nextInt();
        System.out.println("Enter k value: ");
        int k = sc.nextInt();

        int lineWithMaxNumberOfVowels = countVowels(fileName1);
        copy1(fileName1, fileName2, lineWithMaxNumberOfVowels);
        System.out.println("Number of line with max number of vowels is " + lineWithMaxNumberOfVowels);
        write(fileName2, lineWithMaxNumberOfVowels);

        copy2(fileName1, fileName2, n, k);
        System.out.println("Lines " + n + " through " + k + " have been copied to File 2");

        FileString2 FS2 = new FileString2();
        String stringFromFile2 = FS2.read(fileName2);
        countConsonants(stringFromFile2);
    }

    private static int countVowels(String source) throws IOException {
        int vowelCounter = 0;
        int countLine = 0;
        int maxNumberOfVowels = 0;
        int lineWithMaxNumberOfVowels = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(source))) {

            String line;
            while ((line = br.readLine()) != null) {
                countLine++;
                Pattern vocals = Pattern.compile("(?iu)[a-zа-я&&[аеёиоуыэюяyeiaou]]");

                Matcher m = vocals.matcher(line);
                while (m.find()) {
                    vowelCounter++;
                }

                if (vowelCounter > maxNumberOfVowels) {
                    maxNumberOfVowels = vowelCounter;
                    lineWithMaxNumberOfVowels = countLine;
                }
                vowelCounter=0;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineWithMaxNumberOfVowels;
    }

    private static void copy1(String source, String dest, int lineWithMaxVowels2) throws IOException {//to copy all line except the one with most vowels;
        BufferedReader br;
        PrintWriter pw;
        try {
            br = new BufferedReader(new FileReader(source));
            pw =  new PrintWriter(new FileWriter(dest));
            String line;
            int countLine2 = 0;
            while ((line = br.readLine()) != null) {
                countLine2++;
                if (countLine2 !=lineWithMaxVowels2) {
                    pw.println(line);
                }
            }
            br.close();
            pw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void copy2(String source, String dest, int n, int k) throws IOException { // to copy lines n through k;
        BufferedReader br;
        PrintWriter pw;
        try {
            br = new BufferedReader(new FileReader(source));
            pw = new PrintWriter(new FileWriter(dest));
            String line;
            int countLine = 0;
            while ((line = br.readLine()) != null) {
                countLine++;
                if (countLine >= n & countLine <= k) {
                    pw.println(line);
                }
            }
            br.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void countConsonants(String str) {
        Pattern consonants = Pattern.compile("(?iu)[a-zа-я&&[qwrtpsdfghjklzxcvbnmйцкнгшщзхъфвпрлджчсмтьб]]");

        Matcher m = consonants.matcher(str);
        int consonantCounter = 0;
        while (m.find()) {
            consonantCounter++;
        }
        System.out.println("Number of consonants in selected lines is " + consonantCounter);
    }

    private String read(String fileName)throws IOException  {
        StringBuilder s = new StringBuilder();
        Scanner in = new Scanner(new File(fileName));
        while(in.hasNext())
            s.append(in.nextLine());
        in.close();
        return s.toString();
    }

    private static void write(String dest, int i) {
        try(FileWriter writer = new FileWriter(dest, false))
        {
            String s = Integer.toString(i);
            writer.append('\n');
            writer.write(s);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}