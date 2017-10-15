package za.co.entelect.javaforum;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Person {

    @NonNull
    private final String name;

    public Multiset<Character> getCharacterCounts() {
        Multiset<Character> counts = TreeMultiset.create();

        for (char c : CharMatcher.javaLetter().retainFrom(name).toCharArray()) {
            counts.add(c);
        }
        //Debugging message:
        log.debug("For '{}', counts are: {}", this, counts);
        return counts;
    }

}
