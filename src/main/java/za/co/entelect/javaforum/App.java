package za.co.entelect.javaforum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("There should be only one argument");
        }
        for (String arg : args) {
            LOGGER.info("Got arg: {}", arg);
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
            LOGGER.error("Exception!", ex);
        }
        LOGGER.info("Final result: " + characterCounts);
    }

}
