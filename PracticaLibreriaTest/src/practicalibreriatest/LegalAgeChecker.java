package practicalibreriatest;

import java.time.LocalDateTime;

public final class LegalAgeChecker {

	private static final int SPAIN_LEGAL_AGE = 18;

	public boolean isOfLegalAge(LocalDateTime birthDate) {
		return LocalDateTime.now().isAfter(birthDate.plusYears(SPAIN_LEGAL_AGE));
	}

}
