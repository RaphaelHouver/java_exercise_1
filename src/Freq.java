import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {

        System.out.println("Chemin du fichier texte : ");
        String path = scanner.nextLine();
        String content;
        try {
            content = java.nio.file.Files.readString(Path.of(path));
        }
        catch (IOException e) {
            System.err.println("Unreadable file: " + e.getMessage());
            return false;
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
        

        return false;
    }

}