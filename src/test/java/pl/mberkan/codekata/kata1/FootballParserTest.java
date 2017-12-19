package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class FootballParserTest {

    private FootballParser subject = new FootballParser();

    @Test
    public void parseMeasures() throws Exception {
        // given
        ImmutableList<String> lines = ImmutableList.of("1. Arsenal         38    26   9   3    79  -  36    87");

        // when
        List<FootballCheck.Match> measures = subject.parseMeasures(lines);

        // then
        assertThat(measures.size()).isEqualTo(1);
        FootballCheck.Match measure = measures.get(0);
        assertThat(measure.name).isEqualTo("Arsenal");
        assertThat(measure.f).isEqualTo(79);
        assertThat(measure.a).isEqualTo(36);
    }

}