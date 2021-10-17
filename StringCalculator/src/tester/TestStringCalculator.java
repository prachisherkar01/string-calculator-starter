package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.core.StringCalculator;

class TestStringCalculator {
	@Test
	void empty_string_should_return_0() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	void string_with_single_number_should_return_number_as_int() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	void string_with_two_numbers_one() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	void string_with_two_numbers_two() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(11, stringCalculator.add("3,8"));
	}

	@Test
	void string_with_more_numbers() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(17, stringCalculator.add("3,5,7,1,1"));
	}

	@Test
	void string_with_new_line() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}

	@Test
	void string_with_invalid_new_line() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(1, stringCalculator.add("1,\n"));
		} catch (Exception e) {
			assertEquals("INVALID input", e.getMessage());
		}
	}

	@Test
	void string_with_different_delimiters() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(3, stringCalculator.add("//;\n1;2"));
		assertEquals(5, stringCalculator.add("//+\n2+3"));
	}

	@Test
	void string_with_negative_number() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(1, stringCalculator.add("//;\n-1;2"));
			throw new Exception("Failed");
		} catch (Exception e) {
			assertEquals("Negatives not allowed : -1", e.getMessage());
		}
	}

	@Test
	void string_with_multiple_negative_number() {
		StringCalculator stringCalculator = new StringCalculator();
		try {
			assertEquals(1, stringCalculator.add("//;\n-1;-2;6"));
			throw new Exception("Failed");
		} catch (Exception e) {
			assertEquals("Negatives not allowed : -1, -2", e.getMessage());
		}
	}

	@Test
	void string_with_greater_than_1000() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(2, stringCalculator.add("2,1001"));
	}

	@Test
	void string_with_variable_length_delimeter() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(6, stringCalculator.add("//[*]\n1**2**3"));
	}

	@Test
	void string_with_multiple_delimeter() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	void string_with_multiple_varying_delimeter() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(6, stringCalculator.add("//[**][%%%]\n1***2%%%%%3"));
	}

}
