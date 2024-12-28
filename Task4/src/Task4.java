import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        if (args.length > 0) {
            filePath = args[0];
        }

        List<Integer> numbers = readFile(filePath);
        if (numbers.isEmpty()) {
            System.out.println("Нет чисел для обработки.");
            return;
        }
        double median = calculateMedian(numbers);
        double sumOfDeviations = calculateSumOfAbsoluteDeviations(numbers, median);

        System.out.printf("Медиана: %.2f%n", median);
        System.out.printf("Сумма абсолютных отклонений от медианы: %.2f%n", sumOfDeviations);
    }

    private static List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Преобразование строки в число: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return numbers;
    }

    private static double calculateMedian(List<Integer> numbers) {
        Collections.sort(numbers);
        int size = numbers.size();
        if (size % 2 == 0) {
            return (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2.0;
        } else {
            return numbers.get(size / 2);
        }
    }

    private static double calculateSumOfAbsoluteDeviations(List<Integer> numbers, double median) {
        double sum = 0;
        for (int number : numbers) {
            sum += Math.abs(number - median);
        }
        return sum;
    }
}