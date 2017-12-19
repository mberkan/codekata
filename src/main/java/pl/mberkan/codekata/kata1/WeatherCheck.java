package pl.mberkan.codekata.kata1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Kata example
 */
public class WeatherCheck {

    static class Measure {
        @Override
        public String toString() {
            return "Measure{" +
                    "numDay=" + numDay +
                    ", min=" + min +
                    ", max=" + max +
                    '}';
        }

        public Measure(int numDay, int max, int min) {
            this.numDay = numDay;
            this.min = min;
            this.max = max;
        }

        int numDay;
        int min;
        int max;
    }

    public static void main(String[] args) throws IOException {
        readFile()
                .stream()
                .skip(2)
                .filter(l -> l.matches("\\s*\\d+.*"))
                .map(l -> l.trim().replaceAll("[*]", "").split(" +"))
                .map(a -> new Measure(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2])))
                .sorted((o1, o2) -> {
                    int diff1 = o1.max - o1.min;
                    int diff2 = o2.max - o2.min;
                    return diff2 - diff1;
                })
                .findFirst().
                ifPresent(m -> System.out.println(m.numDay));
    }

    private static List<String> readFile() throws IOException {
        return Files.readAllLines(
                Paths.get("/tmp/weather.dat"),
                Charset.defaultCharset());
    }
}
