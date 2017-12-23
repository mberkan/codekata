package pl.mberkan.codekata.kata1;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class FootballMatchParser extends FixedWidthColumnFileParser {

    private static final int INDEX_OF_NAME = 8;
    private static final int INDEX_OF_FOR = 44;
    private static final int INDEX_OF_AGAINST = 51;

    private static final int NAME_LENGTH = 16;
    private static final int RESULT_LENGTH = 2;

    Predicate<String> validLinePredicate = l -> l.matches("[ ]*\\d+\\..*");

    private Map<Integer, Integer> columnIndexes = ImmutableMap.of(
            INDEX_OF_NAME, NAME_LENGTH,
            INDEX_OF_FOR, RESULT_LENGTH,
            INDEX_OF_AGAINST, RESULT_LENGTH);

    List<FootballCheck.Match> parseMatch(List<String> lines) {
        return parse(lines, validLinePredicate, columnIndexes)
                .stream()
                .map(this::getMatch)
                .collect(Collectors.toList());
    }

    private FootballCheck.Match getMatch(Map<Integer, String> values) {
        return new FootballCheck.Match(values.get(INDEX_OF_NAME),
                Integer.parseInt(values.get(INDEX_OF_FOR)),
                Integer.parseInt(values.get(INDEX_OF_AGAINST)));
    }
}
