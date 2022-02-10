import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue !");
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
        while (!input.equals("quit") && !input.equals("fibo"))
        {
            System.out.println("Unknown command");
            input = scan.nextLine();
        }
        
        if (input.equals("fibo"))
        {
            System.out.println("Saisissez l'index qui vous souhaitez : ");
            int n = Integer.parseInt(scan.nextLine());
            System.out.println(fibo(n));
        }

        
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
