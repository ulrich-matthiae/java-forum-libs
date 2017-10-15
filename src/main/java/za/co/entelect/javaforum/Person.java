package za.co.entelect.javaforum;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    private String name;

    public Person(String name) {
        this.name = Preconditions.checkNotNull(name, "name cannot be null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Multiset<Character> getCharacterCounts() {
        Multiset<Character> counts = TreeMultiset.create();

        for (char c : CharMatcher.javaLetter().retainFrom(name).toCharArray()) {
            counts.add(c);
        }
        //Debugging message:
        LOGGER.debug("For '{}', counts are: {}", this, counts);
        return counts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        //Lets pretend this is a really slow tostring method:
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            LOGGER.error("Exception thown in sleep", ex);
        }
        return "Person{name='" + name + "'}";
    }
}
