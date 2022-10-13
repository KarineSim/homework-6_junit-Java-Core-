import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TaxChoiceTest {

    TaxChoice sut;

    @BeforeEach
    public void initEachTest() {
        sut = new TaxChoice();
    }

    @Test
    public void testTaxEarningsMinusSpendings() {
        int earnings = 15000;
        int spendings = 7000;
        int expected = 1200;

        int actual = sut.taxEarningsMinusSpendings(earnings, spendings);

        assertEquals(expected, actual);
    }

    @Test
    public void testTaxEarnings() {
        int earnings = 15000;
        int expected = 900;

        int actual = sut.taxEarnings(earnings);

        assertEquals(expected, actual);
    }

    @Test
    public void testTaxEarningsMinusInsurancePremiums() {
        int earnings = 15000;
        int premiums = 12000;
        int expected = 450;

        int actual = sut.taxEarningsMinusSpendings(earnings, premiums);

        assertEquals(expected, actual);

    }

    @MethodSource("source")
    @ParameterizedTest
    public void testTaxSelfEmployed(int earnings, String contractor, int expected) {
        int actual = sut.taxSelfEmployed(earnings, contractor);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(15000, "Физическое лицо", 600), Arguments.of(15000, "Юридическое лицо", 900));
    }
}