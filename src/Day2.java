import java.nio.file.*;
import java.util.*;

public class Day2 {
    public static void main(String[] args) throws Exception {
        String filepath = "reportInputDay2.txt";
        List<String> lines = Files.readAllLines(Paths.get(filepath));
        int safeCount = 0;
        for (String line : lines) {
            String[] parts = line.split(" ");
            List<Integer> levels = new ArrayList<>();

            for (String part : parts) {
                levels.add(Integer.parseInt(part));
            }

            if (isSafe(levels) || canBeSafeWithOneRemoval(levels)) {
                safeCount++;
            }
        }
        System.out.println("Safe Count: " + safeCount);
    }

    private static boolean isSafe(List<Integer> levels) {
        int[] numbers = new int[levels.size()];
        for (int i = 0; i < levels.size(); i++) {
            numbers[i] = levels.get(i);
        }

        if (numbers.length < 2) {
            return true;
        }

        boolean decreasing = numbers[0] > numbers[1];

        for (int i = 1; i < numbers.length; i++) {
            int diff = Math.abs(numbers[i] - numbers[i - 1]);
            if (diff < 1 || diff > 3) {
                return false;
            }
            if (decreasing && numbers[i] > numbers[i - 1]) {
                return false;
            }
            if (!decreasing && numbers[i] < numbers[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean canBeSafeWithOneRemoval(List<Integer> levels) {
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> modifiedLevels = new ArrayList<>(levels);
            modifiedLevels.remove(i);
            if (isSafe(modifiedLevels)) {
                return true;
            }
        }
        return false;
    }
}
