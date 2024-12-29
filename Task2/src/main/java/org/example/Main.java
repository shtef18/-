package org.example;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        float x = 0.0F;
        float y = 0.0F;
        float z = 0.0F;

        FileReader reader = new FileReader(args[0]);
        Scanner scanner = new Scanner(reader);

        FileReader reader1 = new FileReader(args[1]);
        Scanner console = new Scanner(reader1);

        while(scanner.hasNextLine()) {
            x = scanner.nextFloat();
            y = scanner.nextFloat();
            z = scanner.nextFloat();
        }

        while(console.hasNextLine()) {
            float X = console.nextFloat();
            float Y = console.nextFloat();
            double result = Math.sqrt((double)((x - X) * (x - X) + (y - Y) * (y - Y)));
            if (result < (double)z) {
                System.out.println(1);
            } else if (result > (double)z) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }
    }
}
