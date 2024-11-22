import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        String input = "swiss";

        Character firstNonRepeatedChar = findFirstNonRepeatedCharacter(input);

        if (firstNonRepeatedChar != null) {
            System.out.println("The first non-repeated character is: " + firstNonRepeatedChar);
        } else {
            System.out.println("No non-repeated character found.");
        }
    }

    public static Character findFirstNonRepeatedCharacter(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

       
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

       
        return frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
