package pl.mberkan.codekata.kata1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FixedWidthColumnFileParserTest.class,
        FootballMatchParserTest.class,
        FootballCheckTest.class,
        WeatherMeasureParserTest.class,
        WeatherCheckTest.class
})
public class TestSuite {
}
