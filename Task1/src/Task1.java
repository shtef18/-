public class Task1 {
    public static void main(String[] args) {

//        int n = 5;
//        int m = 4;

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int one = 1;

        int exit = 0;

        while (exit != 1 ){
            System.out.print(one);
            one = (one + m - 2) % n + 1;
            if (one == 1){
                exit = one;
            }
        }
    }
}