package pl.mberkan.codekata.kata1;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class FixedWidthColumnFileParser {

    /**
     * Parse files by given columns and its length.
     *
     * @param lines input lines
     * @param validLinePredicate predicate of valid lines
     * @param columnIndexes map with: column index -> column length
     * @return list of parsed data: column index -> column value
     */
    List<Map<Integer, String>> parse(List<String> lines, Predicate<String> validLinePredicate,
                                     Map<Integer, Integer> columnIndexes) {
        return lines.stream()
                .filter(validLinePredicate)
                .map(l -> {
                    Map<Integer, String> result = Maps.newHashMap();
                    columnIndexes.forEach((index, length)
                            -> result.put(index, l.substring(index - 1, index - 1 + length).trim()));
                    return result;
                })
                .collect(Collectors.toList());
    }
}
