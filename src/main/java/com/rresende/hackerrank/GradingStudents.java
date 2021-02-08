package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class GradingStudents {

	@Test
	public void roundGrades() throws Exception {
		assertThat(roundGrade(84), is(85));
		assertThat(roundGrade(29), is(29));
		assertThat(roundGrade(73), is(75));
		assertThat(roundGrade(67), is(67));
		assertThat(roundGrade(38), is(40));
		assertThat(roundGrade(33), is(33));
		assertThat(roundGrade(51), is(51));
		assertThat(roundGrade(39), is(40));
		assertThat(roundGrade(37), is(37));
	}

	private Integer roundGrade(int grade) {
		if (grade < 38)
			return grade;
		int nextMultiple = getNextMutiple(grade, 5);
		if (nextMultiple < 40)
			return grade;
		int diff = nextMultiple - grade;
		if (diff < 3)
			return nextMultiple;
		return grade;
	}

	private int getNextMutiple(final int grade, final int multiple) {
		int mutableGrade = grade;
		while (mutableGrade % multiple != 0) {
			mutableGrade++;
		}
		return mutableGrade;
	}
}
