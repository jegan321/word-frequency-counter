import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Accepts a piece of text as a CLI argument and outputs each word and the number of times it occurred. The words
 * are printed in order of frequency, highest to lowest. The order of words with the same frequency is not guaranteed.
 */
public class WordFrequencyCounter {

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Please provide the input text as the first argument");
        }

        String input = args[0].trim();
        String[] words = input.split(" ");

        // Two maps are used to keep track of the frequencies as well as the ranking order while the words are iterated
        // the first time.
        // Without keeping track of the rankings it would be inefficient to try to sort by the values of the
        // frequencies map.
        Map<String, Integer> wordFrequencies = new HashMap<>();
        Map<Integer, Set<String>> wordRankings = new HashMap<>();
        int maxCount = 0;

        for (String word : words) {
            int prevCount;
            int newCount;
            if (wordFrequencies.containsKey(word)) {
                prevCount = wordFrequencies.get(word);
                newCount = prevCount + 1;
            } else {
                prevCount = 0;
                newCount = 1;
            }
            maxCount = Math.max(newCount, maxCount);
            wordFrequencies.put(word, newCount);

            if (prevCount != 0) {
                wordRankings.get(prevCount).remove(word);
            }
            if (!wordRankings.containsKey(newCount)) {
                wordRankings.put(newCount, new HashSet<>());
            }
            Set<String> rankSet = wordRankings.get(newCount);
            rankSet.add(word);
        }

        // Print the results
        for (int i = maxCount; i > 0; i--) {
            Set<String> rankSet = wordRankings.get(i);
            for (String word : rankSet) {
                System.out.println(i + " " + word);
            }
        }

    }
}
