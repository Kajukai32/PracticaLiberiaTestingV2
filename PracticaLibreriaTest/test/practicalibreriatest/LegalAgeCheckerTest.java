package practicalibreriatest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LegalAgeCheckerTest {


	@ParameterizedTest
	@MethodSource("shouldBeLegalAgeArguments")
	void shouldBeLegalAge(LocalDateTime fdn, boolean expected) {
		// GIVEN
		LegalAgeChecker legalAgeChecker = new LegalAgeChecker();
		// WHEN
		// THEN

		assertEquals(expected, legalAgeChecker.isOfLegalAge(fdn));


	}

	private static Stream<Arguments> shouldBeLegalAgeArguments() {

		return Stream.of(Arguments.of(LocalDateTime.of(2000, 12, 07, 07, 07), true),
				Arguments.of(LocalDateTime.of(1990, Month.DECEMBER, 07, 07, 07), true),
				Arguments.of(LocalDateTime.of(1995, 12, 07, 07, 07), true),
				Arguments.of(LocalDateTime.of(2010, 12, 07, 07, 07), true),
				Arguments.of(LocalDateTime.of(2020, 12, 07, 07, 07), true),
				Arguments.of(LocalDateTime.of(1956, 12, 07, 07, 07), true));
	}


}
