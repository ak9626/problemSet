import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "kiwi", "orange", "kiwi", "kiwi");

        int k = 2; 
        List<String> topKWords = findTopKFrequentWords(words, k);

        System.out.println("Top " + k + " frequent words: " + topKWords);
    }

    public static List<String> findTopKFrequentWords(List<String> words, int k) {
        if (words == null || words.isEmpty() || k <= 0) {
            return Collections.emptyList();
        }

        Map<String, Long> frequencyMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
