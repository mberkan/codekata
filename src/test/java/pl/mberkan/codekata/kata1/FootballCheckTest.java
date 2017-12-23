package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FootballCheckTest {

    private FootballCheck subject = new FootballCheck();

    @Test
    public void findMatchWithSmallestForAndAgainstDifference() throws Exception {
        // given
        FootballCheck.Match m1 = new FootballCheck.Match("a", 20, 1);
        FootballCheck.Match m2 = new FootballCheck.Match("b", 3, 3);
        ImmutableList<FootballCheck.Match> matches =  ImmutableList.of(m1, m2);

        // when
        Optional<FootballCheck.Match> result = subject.findMatchWithSmallestForAndAgainstDifference(matches);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().name).isEqualTo("b");
    }

    @Test
    public void findWithAnotherOrder() throws Exception {
        // given
        FootballCheck.Match m1 = new FootballCheck.Match("b", 3, 3);
        FootballCheck.Match m2 = new FootballCheck.Match("a", 20, 1);
        ImmutableList<FootballCheck.Match> matches =  ImmutableList.of(m1, m2);

        // when
        Optional<FootballCheck.Match> result = subject.findMatchWithSmallestForAndAgainstDifference(matches);

        // then
        assertThat(result).isPresent();
        assertThat(result.get().name).isEqualTo("b");
    }

}