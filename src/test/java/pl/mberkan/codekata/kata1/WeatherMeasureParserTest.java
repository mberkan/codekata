package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Michał Cybulski
 */
public class WeatherMeasureParserTest {

    private WeatherMeasureParser subject = new WeatherMeasureParser();


    @Test
    public void checkValidLine() {
        // given
        String line = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";

        // when
        boolean result = subject.validLinePredicate.test(line);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void parseATypicalLine() {
        // given
        ImmutableList<String> lines = ImmutableList.of("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5");

        // when
        List<WeatherCheck.Measure> measures = subject.parseMeasures(lines);

        // then
        assertThat(measures.size()).isEqualTo(1);
        WeatherCheck.Measure measure = measures.get(0);
        assertThat(measure.numDay).isEqualTo(1);
        assertThat(measure.max).isEqualTo(88);
        assertThat(measure.min).isEqualTo(59);
    }

    @Test
    public void parseALineWithAsterisk() {
        // given
        ImmutableList<String> lines = ImmutableList.of("  26  97*   64    81          70.4       0.00 H       050  5.1 200  12  4.0 107 45 1014.9");

        // when
        List<WeatherCheck.Measure> measures = subject.parseMeasures(lines);

        // then
        assertThat(measures.size()).isEqualTo(1);
        WeatherCheck.Measure measure = measures.get(0);
        assertThat(measure.numDay).isEqualTo(26);
        assertThat(measure.max).isEqualTo(97);
        assertThat(measure.min).isEqualTo(64);
    }
}
