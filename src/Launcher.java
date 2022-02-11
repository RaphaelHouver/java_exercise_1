import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue !");

        List<Command> commands = List.of(
            new Quit(),
            new Fibo(),
            new Freq()
        );

        Scanner scan = new Scanner(System.in);
        while (true) {
            String input = scan.nextLine();
            boolean found = false;
            for (Command i : commands) {
                if (i.name().equals(input)) {
                    if(i.run(scan)) {
                        scan.close();
                        return;
                    }
                    found = true;
                    break;
                }
            }

            if (!found)
                System.out.println("Unknown command");
        }

        
    }

    
}
