package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;


public class FixedWidthColumnFileParserTest {

    private FixedWidthColumnFileParser subject = new FixedWidthColumnFileParser();

    @Test
    public void parseWeatherLine() throws Exception {
        // given
        ImmutableList<String> lines = ImmutableList.of("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5");

        // when
        Map<Integer, Integer> columnIndexes = ImmutableMap.of(
                3, 2,
                7, 2,
                13, 2);
        List<Map<Integer, String>> result = subject.parse(lines, l -> true, columnIndexes);

        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).get(3)).isEqualTo("1");
        assertThat(result.get(0).get(7)).isEqualTo("88");
        assertThat(result.get(0).get(13)).isEqualTo("59");
    }

    @Test
    public void parseMatchLine() throws Exception {
        // given
        ImmutableList<String> lines = ImmutableList.of("    6. Chelsea         38    17  13   8    66  -  38    64");

        // when
        Map<Integer, Integer> columnIndexes = ImmutableMap.of(
                8, 16,
                44, 2,
                51, 2);
        List<Map<Integer, String>> result = subject.parse(lines, l -> true, columnIndexes);

        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).get(8)).isEqualTo("Chelsea");
        assertThat(result.get(0).get(44)).isEqualTo("66");
        assertThat(result.get(0).get(51)).isEqualTo("38");
    }
}