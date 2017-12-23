package pl.mberkan.codekata.kata1;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Kata example:
 * <p>
 * The file football.dat contains the results from the English Premier League for 2001/2. The columns labeled ‘F’
 * and ‘A’ contain the total number of goals scored for and against each team in that season
 * (so Arsenal scored 79 goals against opponents, and had 36 goals scored against them). Write a program to print
 * the name of the team with the smallest difference in ‘for’ and ‘against’ goals.
 */
public class FootballCheck {

    private static final String FOOTBALL_DATA_FILENAME = "football.dat";

    static class Match {
        String name;
        int f;
        int a;

        @Override
        public String toString() {
            return "Match{" +
                    "name='" + name + '\'' +
                    ", f=" + f +
                    ", a=" + a +
                    ", absolute difference= " + getForAndAgainstAbsoluteDifference() +
                    '}';
        }

        Match(String name, int f, int a) {
            this.name = name;
            this.f = f;
            this.a = a;
        }

        int getForAndAgainstAbsoluteDifference() {
            return Math.abs(a - f);
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> linesFromFile = new FileReaderUtil().readFileFromResource(FOOTBALL_DATA_FILENAME);
        List<Match> matches = new FootballMatchParser().parseMatch(linesFromFile);
        new FootballCheck().findMatchWithSmallestForAndAgainstDifference(matches)
                .ifPresent(m -> System.out.println(m.name));
    }

    Optional<Match> findMatchWithSmallestForAndAgainstDifference(List<Match> matches) {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::getForAndAgainstAbsoluteDifference))
                .findFirst();
    }
}
