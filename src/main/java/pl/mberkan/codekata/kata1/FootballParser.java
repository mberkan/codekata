package pl.mberkan.codekata.kata1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class FootballParser {

    private Pattern p = Pattern.compile(".*?([a-zA-Z_]+).*?(\\d+)  -  (\\d+).*");

    List<FootballCheck.Match> parseMeasures(List<String> lines) {
        return lines
                .stream()
                .filter(l -> l.matches(p.pattern()))
                .map(this::getMatch)
                .collect(Collectors.toList());
    }

    private FootballCheck.Match getMatch(String l) {
        Matcher matcher = p.matcher(l);
        matcher.matches();
        return new FootballCheck.Match(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
    }
}
