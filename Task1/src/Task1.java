public class Task1 {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        printPath(array, m);
    }
    public static void printPath(int[] array, int m) {
        int n = array.length;
        m = m % n;
        if (m == 0) {
            m = n;
        }
        int index = 0;
        System.out.print("Путь:");

        StringBuilder path = new StringBuilder();
        do {
            path.append(array[index]).append(" ");
            index = (index + m - 1) % n;
        } while (index != 0);
        System.out.println(path.toString().trim());
    }
}