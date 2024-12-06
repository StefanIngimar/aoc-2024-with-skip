import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Day3 {
    public static void main(String[] args) throws Exception {
        String filepath = "input3.txt";
        List<String> lines = Files.readAllLines(Paths.get(filepath));

        int totalSum = multiplyAndSum(lines);
        System.out.println("Total Sum: " + totalSum);
    }

    private static int multiplyAndSum(List<String> lines) {
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)");
        int sum = 0;
        boolean enabled = true;

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String foundMatch = matcher.group();

                if (foundMatch.equals("do()")) {
                    enabled = true;
                } else if (foundMatch.equals("don't()")) {
                    enabled = false;
                }

                if (enabled && foundMatch.startsWith("mul")) {
                    String[] numbers = foundMatch.replaceAll("[^\\d+,]", "").split(",");
                    int num1 = Integer.parseInt(numbers[0]);
                    int num2 = Integer.parseInt(numbers[1]);
                    sum += num1 * num2;
                }
            }
        }

        return sum;
    }
}
