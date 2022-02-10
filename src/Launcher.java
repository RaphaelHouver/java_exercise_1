import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue !");
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
        while (!input.equals("quit"))
        {
            System.out.println("Unknown command");
            input = scan.nextLine();
        }
        
    }
}