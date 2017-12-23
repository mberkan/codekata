package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class WeatherMeasureParser extends FixedWidthColumnFileParser {

    private static final int INDEX_OF_DAY = 3;
    private static final int INDEX_OF_MAX = 7;
    private static final int INDEX_OF_MIN = 13;

    private static final int COLUMN_LENGTH = 2;

    Predicate<String> validLinePredicate = l -> l.matches("[ ]*\\d+.*");

    private Map<Integer, Integer> columnIndexes = ImmutableMap.of(
            INDEX_OF_DAY, COLUMN_LENGTH,
            INDEX_OF_MAX, COLUMN_LENGTH,
            INDEX_OF_MIN, COLUMN_LENGTH);

    WeatherMeasureParser() {
    }

    private WeatherCheck.Measure getMeasure(Map<Integer, String> values) {
        return new WeatherCheck.Measure(Integer.parseInt(values.get(INDEX_OF_DAY)),
                Integer.parseInt(values.get(INDEX_OF_MAX)),
                Integer.parseInt(values.get(INDEX_OF_MIN)));
    }

    List<WeatherCheck.Measure> parseMeasures(List<String> lines) {
        return parse(lines, validLinePredicate, columnIndexes)
                .stream()
                .map(this::getMeasure)
                .collect(Collectors.toList());
    }
}
