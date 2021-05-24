package com.roytuts.java.junit.dynamic.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

public class JunitDynamicTests {

	private final PalindromeChecker checker = new PalindromeChecker();

	@TestFactory
	Collection<DynamicTest> dynamicTestsMinMax() {
		return Arrays.asList(
				dynamicTest("Find Max Test",
						() -> assertEquals(4, MinMaxElementFinder.findMax(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Find Min Test",
						() -> assertEquals(1, MinMaxElementFinder.findMin(new int[] { 1, 3, 4, 2 }))));
	}

	@TestFactory
	Collection<DynamicTest> dynamicTestsPalindrome() {
		return Arrays.asList(dynamicTest("Palindrome 1", () -> assertTrue(checker.isPalindrome("madam"))),
				dynamicTest("Palindrome 2", () -> assertFalse(checker.isPalindrome("palindrome"))));
	}

	@TestFactory
	Collection<DynamicTest> dynamicTestsMinMaxPalindromeCollection() {
		return Arrays.asList(
				dynamicTest("Find Max Test",
						() -> assertEquals(4, MinMaxElementFinder.findMax(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Find Min Test",
						() -> assertEquals(1, MinMaxElementFinder.findMin(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Palindrome 1", () -> assertTrue(checker.isPalindrome("madam"))),
				dynamicTest("Palindrome 2", () -> assertFalse(checker.isPalindrome("palindrome"))));
	}

	@TestFactory
	Iterable<DynamicTest> dynamicTestsMinMaxPalindromeIterable() {
		return Arrays.asList(
				dynamicTest("Find Max Test",
						() -> assertEquals(4, MinMaxElementFinder.findMax(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Find Min Test",
						() -> assertEquals(1, MinMaxElementFinder.findMin(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Palindrome 1", () -> assertTrue(checker.isPalindrome("madam"))),
				dynamicTest("Palindrome 2", () -> assertFalse(checker.isPalindrome("palindrome"))));
	}

	@TestFactory
	Iterator<DynamicTest> dynamicTestsMinMaxPalindromeIterator() {
		return Arrays.asList(
				dynamicTest("Find Max Test",
						() -> assertEquals(4, MinMaxElementFinder.findMax(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Find Min Test",
						() -> assertEquals(1, MinMaxElementFinder.findMin(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Palindrome 1", () -> assertTrue(checker.isPalindrome("madam"))),
				dynamicTest("Palindrome 2", () -> assertFalse(checker.isPalindrome("palindrome")))).iterator();
	}

	@TestFactory
	DynamicTest[] dynamicTestsMinMaxPalindromeArray() {
		return new DynamicTest[] {
				dynamicTest("Find Max Test",
						() -> assertEquals(4, MinMaxElementFinder.findMax(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Find Min Test",
						() -> assertEquals(1, MinMaxElementFinder.findMin(new int[] { 1, 3, 4, 2 }))),
				dynamicTest("Palindrome 1", () -> assertTrue(checker.isPalindrome("madam"))),
				dynamicTest("Palindrome 2", () -> assertFalse(checker.isPalindrome("palindrome"))) };
	}

	@TestFactory
	Stream<DynamicTest> dynamicTestsStream() {
		return Stream.of("madam", "mom", "dad")
				.map(str -> dynamicTest(str, () -> assertTrue(checker.isPalindrome(str))));
	}

	@TestFactory
	Stream<DynamicTest> dynamicTestsIntStream() {
		return IntStream.iterate(0, n -> n + 2).limit(5)
				.mapToObj(n -> dynamicTest("Even Test" + n, () -> assertTrue(n % 2 == 0)));
	}

	@TestFactory
	Stream<DynamicTest> dynamicTestsStreamFactoryMethod() {
		Stream<String> inputStream = Stream.of("madam", "mom", "dad");

		Function<String, String> displayNameGenerator = str -> str + " is a palindrome";

		ThrowingConsumer<String> testExecutor = str -> assertTrue(checker.isPalindrome(str));

		return DynamicTest.stream(inputStream, displayNameGenerator, testExecutor);
	}

	@TestFactory
	Stream<DynamicNode> dynamicTestsContainers() {
		return Stream.of("Roytuts", "Soumitra", "Roy").map(input -> dynamicContainer("Container " + input,
				Stream.of(dynamicTest("Not Null", () -> assertNotNull(input)),
						dynamicContainer("Conditional Checks",
								Stream.of(dynamicTest("Empty", () -> assertNull(null)),
										dynamicTest("False", () -> assertFalse(false)),
										dynamicTest("Length Greater Than 0", () -> assertTrue(input.length() > 0)),
										dynamicTest("Not Empty", () -> assertFalse(input.isEmpty())))))));
	}

	@TestFactory
	DynamicNode dynamicNodeSingle() {
		return dynamicTest("'push' is a not palindrome", () -> assertFalse(checker.isPalindrome("push")));
	}

	@TestFactory
	DynamicNode dynamicNodeSingleContainer() {
		return dynamicContainer("Palindromes", Stream.of("madam", "mom", "dad")
				.map(str -> dynamicTest(str, () -> assertTrue(checker.isPalindrome(str)))));
	}

	@TestFactory
	Stream<DynamicTest> checkAllTextFiles() throws Exception {
		return Files.walk(Paths.get("src/test/resources/test"), 1).filter(path -> path.toString().endsWith(".txt"))
				.map(path -> dynamicTest("File: " + path.getFileName(), path.toUri(), () -> checkLineContent(path)));
	}

	private void checkLineContent(Path path) throws Exception {
		List<String> lines = Files.readAllLines(path);

		String expected = lines.get(0);
		String actual = new StringBuilder(lines.get(0)).reverse().toString();

		assertEquals(expected, actual, "String and its reverse should be equal");
	}

}
