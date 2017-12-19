package pl.mberkan.codekata.kata1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FootballCheck {

    static class Match {
        String name;
        int f;
        int a;

        @Override
        public String toString() {
            return "Match{" +
                    "name='" + name + '\'' +
                    ", f=" + f +
                    ", a=" + a +
                    '}';
        }

        Match(String name, int f, int a) {
            this.name = name;
            this.f = f;
            this.a = a;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> linesFromFile = readFile();
        List<Match> matches = new FootballParser().parseMeasures(linesFromFile);
        matches
                .stream()
                .sorted((o1, o2) -> {
                    int diffA = o1.a - o2.a;
                    int diffF = o1.f - o2.f;
                    return diffF - diffA;
                })
                .findFirst().
                ifPresent(m -> System.out.println(m.name));
    }

    private static List<String> readFile() throws IOException {
        return Files.readAllLines(
                Paths.get("/tmp/football.dat"),
                Charset.defaultCharset());
    }
}
