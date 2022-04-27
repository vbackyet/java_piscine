
package edu.school21.numbers;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;


// package edu.school21.numbers;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvFileSource;
// import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

	NumberWorker nw;

	@BeforeEach
	void init(){
		nw = new NumberWorker();
	}

	@ParameterizedTest
	@ValueSource(ints = {7919, 6553, 11, 3, 5})
    void isPrimeForPrimes(int num) {
        assertTrue(nw.isPrime(num));
    }

	@ParameterizedTest
	@ValueSource(ints = {7920, 6554, 12, 9, 10})
    void isPrimeForNotPrimes(int num) {
        assertFalse(nw.isPrime(num));
    }

	@ParameterizedTest
	@ValueSource(ints = {0, 1, -12, -9, -10})
    void isPrimeForIncorrectNumbers(int num) {
        assertThrows( IllegalNumberException.class ,() -> nw.isPrime(num));
    }

	@ParameterizedTest
	@CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
    void isDigitTest(int num, int sum) {
        assertEquals(sum, nw.digitsSum(num) );
    }
}


// 4. a method to check digitsSum using a set of at least 10 numbers
// Requirements:
// 6
// Module 06 – Piscine Java JUnit/Mockito
// • NumberWorkerTest class must contain at least 4 methods to test NumberWorker
// functionality
// • Use of @ParameterizedTest and @ValueSource is mandatory for methods 1–3.
// • Use of @ParameterizedTest and @CsvFileSource is mandatory for method 4.
// • You need to prepare data.csv file for method 4 where you shall specify at least 10
// numbers and their correct sum of digits. A file content example:
// • 1234, 10
