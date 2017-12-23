package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FootballMatchParserTest {

    private FootballMatchParser subject = new FootballMatchParser();

    @Test
    public void parseMatch() throws Exception {
        // given
        ImmutableList<String> lines = ImmutableList.of("    1. Arsenal         38    26   9   3    79  -  36    87");

        // when
        List<FootballCheck.Match> measures = subject.parseMatch(lines);

        // then
        assertThat(measures.size()).isEqualTo(1);
        FootballCheck.Match measure = measures.get(0);
        assertThat(measure.name).isEqualTo("Arsenal");
        assertThat(measure.f).isEqualTo(79);
        assertThat(measure.a).isEqualTo(36);
    }

    @Test
    public void checkValidLine() {
        // given
        String line = "    1. Arsenal         38    26   9   3    79  -  36    87";

        // when
        boolean result = subject.validLinePredicate.test(line);

        // then
        assertThat(result).isTrue();
    }
}