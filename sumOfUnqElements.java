import java.util.*;
import java.util.stream.Collectors;

public class SumOfUniqueElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5);

        int sumOfUnique = findSumOfUniqueElements(numbers);

        System.out.println("Sum of unique elements: " + sumOfUnique);
    }

    public static int findSumOfUniqueElements(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        return numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .mapToInt(Map.Entry::getKey)
                .sum();
    }
}
