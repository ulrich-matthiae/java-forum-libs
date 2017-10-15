package za.co.entelect.javaforum;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Preconditions.checkArgument(args.length == 1, "There should be only one argument");

        LOGGER.info("Got args: {}", Lists.newArrayList(args));

        File file = new File(args[0]);

        Multiset<Character> characterCounts = TreeMultiset.create();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                Person person = new Person(line.trim());
                characterCounts.addAll(person.getCharacterCounts());
            }
        } catch (IOException ex) {
            LOGGER.error("Exception!", ex);
        }
        LOGGER.info("Final result: " + characterCounts);
    }

}
