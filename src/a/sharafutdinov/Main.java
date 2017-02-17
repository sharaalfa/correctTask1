package a.sharafutdinov;



import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {


    public static void main(String[] args) throws IOException {
        Counter count = new Counter();

        String fileNames[] = {"example.txt","exampl2.txt"};

        for (String fileName: fileNames) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ResourceReader resourceReader = new ResourceReader(count);
                    String textFromFile = null;
                    try {
                        textFromFile = resourceReader.read(fileName);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        resourceReader.onlyRusWords(textFromFile);
                    } catch (IncorrectWordException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }

    }
}


