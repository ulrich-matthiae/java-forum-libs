package za.co.entelect.javaforum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("There should be only one argument");
        }
        for (String arg : args) {
            System.out.println("Got arg: "+ arg);
        }

        File file = new File(args[0]);

        Map<Character, Integer> characterCounts = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                Person person = new Person(line.trim());

                for (Map.Entry<Character, Integer> entry : person.getCharacterCounts().entrySet()) {
                    int existingCount = 0;
                    if (characterCounts.containsKey(entry.getKey())) {
                        existingCount = characterCounts.get(entry.getKey());
                    }
                    characterCounts.put(entry.getKey(), existingCount + entry.getValue());
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Final result: " + characterCounts);
    }

}
