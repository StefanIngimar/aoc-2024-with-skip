import java.nio.file.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws Exception {
        String filepath = "inputDay1.txt";
        List<String> lines = Files.readAllLines(Paths.get(filepath));// read the file
        List<Integer> left = new ArrayList<>();// create a list for left and one for right
        List<Integer> right = new ArrayList<>();

        for (String line : lines) { // loop through the list and split the numbers into left and right
            String[] parts = line.split("\\s+");// handle whitespace in the list

            if (parts.length > 0) {// add the left side to the left list
                int num = Integer.parseInt(parts[0]);
                left.add(num);
            }

            if (parts.length > 1) {// right side to the right list
                int num2 = Integer.parseInt(parts[1]);
                right.add(num2);
            }
        }
        // System.out.println("Part 1: " + left);
        // System.out.println("Part 2: " + right);
        // Collections.sort(left);
        // Collections.sort(right);

        int totalDistance = 0;
        // loop through both lists and calculate the ABSOLUTE distance between the two
        for (int i = 0; i < left.size(); i++) {
            int distance = Math.abs(right.get(i) - left.get(i));
            totalDistance += distance;
        }
        // hope its right
        System.out.println("total Distance: " + totalDistance);

        // part2 similarity score

        Map<Integer, Integer> rightFrequency = new HashMap<>();
        for (int num : right) {
            rightFrequency.put(num, rightFrequency.getOrDefault(num, 0) + 1);
        }

        int similarityScore = 0;
        for (int num : left) { // for each number in the left list check its frequency in the right list
            int frequency = rightFrequency.getOrDefault(num, 0);
            similarityScore += num * frequency; // multiply the number from the left list by its frequency in the right
                                                // list and add to the score
        }

        // hope its right again
        System.out.println("Similarity Score: " + similarityScore);

    }
}