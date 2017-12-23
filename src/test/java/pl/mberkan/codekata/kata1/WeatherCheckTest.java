package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherCheckTest {

    private WeatherCheck subject = new WeatherCheck();

    @Test
    public void testSmallestMeasureSpread() {
        // given
        WeatherCheck.Measure m1 = new WeatherCheck.Measure(1, 10, 1);
        WeatherCheck.Measure m2 = new WeatherCheck.Measure(2, 2, 1);
        ImmutableList<WeatherCheck.Measure> measures = ImmutableList.of(m1, m2);

        // when
        Optional<WeatherCheck.Measure> result = subject.findMeasureWithSmallestSpread(measures);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().numDay).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongArguments() {
        // given
        WeatherCheck.Measure m1 = new WeatherCheck.Measure(1, 1, 2);
    }

    @Test
    public void testOtherOrder() {
        // given
        WeatherCheck.Measure m1 = new WeatherCheck.Measure(2, 2, 1);
        WeatherCheck.Measure m2 = new WeatherCheck.Measure(1, 10, 1);
        ImmutableList<WeatherCheck.Measure> measures = ImmutableList.of(m1, m2);

        // when
        Optional<WeatherCheck.Measure> result = subject.findMeasureWithSmallestSpread(measures);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().numDay).isEqualTo(2);
    }
}