package za.co.entelect.javaforum;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
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

        LineIterator iterator = null;
        try {
            iterator = FileUtils.lineIterator(file, "UTF-8");
            while (iterator.hasNext()) {
                Person person = new Person(iterator.nextLine().trim());
                characterCounts.addAll(person.getCharacterCounts());
            }
        } catch (IOException ex) {
            LOGGER.error("Exception!", ex);
        } finally {
            LineIterator.closeQuietly(iterator);
        }
        LOGGER.info("Final result: " + characterCounts);
    }

}
