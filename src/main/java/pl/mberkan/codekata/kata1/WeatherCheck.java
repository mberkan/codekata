package pl.mberkan.codekata.kata1;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Kata example:
 *
 * In weather.dat you’ll find daily weather data for Morristown, NJ for June 2002. Download this text file, then
 * write a program to output the day number (column one) with the smallest temperature spread (the maximum temperature
 * is the second column, the minimum the third column).
 */
public class WeatherCheck  {

    private static final String WEATHER_DATA_FILENAME = "weather.dat";

    static class Measure {
        int numDay;
        int min;
        int max;

        Measure(int numDay, int max, int min) {
            Preconditions.checkArgument(max >= min, "Max is not greater or equals min");
            this.numDay = numDay;
            this.min = min;
            this.max = max;
        }

        int getSpread() {
            return max - min;
        }

        @Override
        public String toString() {
            return "Measure{" +
                    "numDay=" + numDay +
                    ", min=" + min +
                    ", max=" + max +
                    ", spread=" + getSpread() +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> linesFromFile = new FileReaderUtil().readFileFromResource(WEATHER_DATA_FILENAME);
        List<Measure> measures = new WeatherMeasureParser().parseMeasures(linesFromFile);
        new WeatherCheck().findMeasureWithSmallestSpread(measures).
                ifPresent(m -> System.out.println(m.numDay));
    }

    Optional<Measure> findMeasureWithSmallestSpread(List<Measure> measures) {
        return measures
                .stream()
                .sorted(Comparator.comparingInt(Measure::getSpread))
                .findFirst();
    }
}
