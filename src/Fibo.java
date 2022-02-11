import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Saisissez l'index qui vous souhaitez : ");
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(fibo(n));

        return false;
    }
    public static int fibo(int n) {
        if (n == 0) {
            return n;
        }
        else if (n == 1) {
            return n;
        }
        else {
            return fibo(n-1) + fibo(n-2);
        }
    }
}