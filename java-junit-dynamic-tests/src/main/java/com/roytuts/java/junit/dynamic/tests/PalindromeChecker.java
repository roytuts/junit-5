package com.roytuts.java.junit.dynamic.tests;

public class PalindromeChecker {

	public boolean isPalindrome(final String str) {

		if (str == null || str.length() <= 0) {
			return false;
		}

		if (str.length() == 1) {
			return true;
		}

		final StringBuilder sb = new StringBuilder(str);

		return str.equals(sb.reverse().toString());
	}

}
