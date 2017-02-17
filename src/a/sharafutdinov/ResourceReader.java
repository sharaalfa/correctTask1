package a.sharafutdinov;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by innopolis on 09.02.17.
 */
public class ResourceReader {
    Counter count;
    public ResourceReader(Counter count) {
        this.count = count;
    }

    public static String read(String fileN) throws FileNotFoundException {
        File file = new File(fileN);
        StringBuilder str = new StringBuilder();
        exists(fileN);
        try {
            BufferedReader in;
            in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    str.append(s);
                    str.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str.toString();
    }

    private static void exists(String file) throws FileNotFoundException {
        File file1 = new File(file);
        if (!file1.exists()) {
            System.out.println("Ресурс не найден!");
            throw new FileNotFoundException(file1.getName());
        }
    }

    public void onlyRusWords(String text) throws IncorrectWordException {
        text = text.replaceAll(",|\\d|\\.|!|\\?", "");
        Pattern pattern = Pattern.compile("[А-яЁё][-А-яЁё]+");
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            Matcher matcher = pattern.matcher(word);

            if (!matcher.matches()) {
                throw new IncorrectWordException(word);
            } else {
                count.printCount(word);
            }
        }
    }
}






