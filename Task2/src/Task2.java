import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("<circle.txt> <points.txt>");
            return;
        }
        float x = 0.0f;
        float y = 0.0f;
        float rad = 0.0f;

        try (
                FileReader readerCircle = new FileReader(args[0]);
                Scanner scannerCircle = new Scanner(readerCircle);
        ) {
            if (scannerCircle.hasNextFloat()) {
                x = scannerCircle.nextFloat();
            }
            if (scannerCircle.hasNextFloat()) {
                y = scannerCircle.nextFloat();
            }
            if (scannerCircle.hasNextFloat()) {
                rad = scannerCircle.nextFloat();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            return;
        }

        try (
                FileReader reader = new FileReader(args[1]);
                Scanner console = new Scanner(reader);
        ) {

            while (console.hasNextFloat()) {
                float pointX = console.nextFloat();
                if (!console.hasNextFloat()) break;
                float pointY = console.nextFloat();
                double distance = Math.sqrt((x-pointX) * (x-pointX) + (y-pointY) * (y-pointY));

                if (distance < rad) {
                    System.out.println(1);
                } else if (distance > rad) {
                    System.out.println(2);
                } else {
                    System.out.println(0);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

