import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue !");
        Scanner scan = new Scanner(System.in);
        
        String input = scan.nextLine();
        while (!input.equals("quit") && !input.equals("fibo") && !input.equals("freq"))
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

        else if (input.equals("freq"))
        {
            System.out.println("Chemin du fichier texte : ");
            String path = scan.nextLine();
            String content;
            try {
                content = java.nio.file.Files.readString(Path.of(path));
            }
            catch (IOException e) {
                System.err.println("Unreadable file: " + e.getMessage());
                return;
            }

            content = content.toLowerCase().replaceAll("^[-a-z\n ]", "");

            Map<String, Integer> freq = new HashMap<>();

            for (var word : content.split(" ")) {
                if (word.isBlank()) continue;

                freq.putIfAbsent(word, 0);
                freq.put(word, freq.get(word) + 1);
            }

            List<String> words = new ArrayList<>();

            while(words.size() < 3 && freq.keySet().size() > 0) {
                int max = Collections.max(freq.values());
                var keys = freq.keySet().stream().filter(k -> freq.get(k) == max).collect(Collectors.toList());
                var last = keys.get(keys.size() - 1);
                words.add(last);
                freq.remove(last);
            }

            System.out.println(String.join(" ", words));
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
