package pl.mberkan.codekata.kata1;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherParser {
    public WeatherParser() {
    }

    List<WeatherCheck.Measure> parseMeasures(List<String> lines) {
        return lines
                .stream()
                .filter(l -> l.matches("\\s*\\d+.*"))
                .map(l -> l.trim().replaceAll("[*]", "").split(" +"))
                .map(a -> new WeatherCheck.Measure(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2])))
                .collect(Collectors.toList());
    }
}
