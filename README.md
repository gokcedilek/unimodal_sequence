CPEN 221: Exercise 8
=========

One should try to finish this task in about 70 minutes.

## Submission Instructions

+ Submit your work to the Github classroom repository that was created for you.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _I would recommend that you get your Git and Github workflow set up at the start._

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person for the purpose of completing this exercise.
+ You did not aid any other person in the class in completing their exercise.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.


## Question: Unimodal Sequences
> The skeleton source code for this question is in the package `unimodal`. You have to implement the required method in the class `UnimodalSequence`. You may import the provided code as a Gradle project in Eclipse.

A sequence a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub> is strongly unimodal if there exists an a<sub>t</sub> (1 < t < n) such that

1. a<sub>1</sub> < a<sub>2</sub> < ... < a<sub>t</sub>,
2. and a<sub>t</sub> > a<sub>t+1</sub> > ... > a<sub>n</sub>.

Given an array of `int`s, `intArray`, determine the length of the longest *consecutive* sequence in `intArray` that is also a strongly unimodal sequence. If there is no such sequence then throw a `NoUnimodalSequenceException` (a checked exception).

### Test Cases

```java
@Test
public void test1() {
	// the entire array is a unimodal sequence
	int[] intArray = new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
	try {
		assertEquals(9, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
	} catch (NoUnimodalSequenceException e) {
		fail("no exception expected");
	}
}

@Test
public void test2() {
	// part of the array is a unimodal sequence
	int[] intArray = new int[] { 2, 3, 2, 4, 6, 8, 10, 5, 3, 1 };
	try {
		assertEquals(8, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
	} catch (NoUnimodalSequenceException e) {
		fail("no exception expected");
	}
}

@Test
public void test3() {
	// no unimodal sequence in a small array
	int[] intArray = new int[] { 3, 2 };
	try {
		UnimodalSequence.getLength_longestUnimodalSequence(intArray);
		fail("should have resulted in an exception");
	} catch (NoUnimodalSequenceException e) {
		// nothing specific to do
	}
}

@Test
public void test4() {
	// longish unimodal sequence -6, 10, 12, 13, 14, 9, 2, 1, 0, -5 in the
	// middle
	int[] intArray = new int[] { -1, 2, -3, -4, -6, 10, 12, 13, 14, 9, 2, 1, 0, -5, -3, 1 };
	try {
		assertEquals(10, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
	} catch (NoUnimodalSequenceException e) {
		fail("no exception expected");
	}
}

@Test
public void test5() {
	// empty array
	int[] intArray = new int[] {};
	try {
		UnimodalSequence.getLength_longestUnimodalSequence(intArray);
		fail("should have resulted in an exception");
	} catch (NoUnimodalSequenceException e) {
		// ...
	}
}

@Test
public void test6() {
	// single entry array
	int[] intArray = new int[] { 11 };
	try {
		UnimodalSequence.getLength_longestUnimodalSequence(intArray);
		fail("should have resulted in an exception");
	} catch (NoUnimodalSequenceException e) {
		// ...
	}
}

@Test
public void test7() {
	// longish non-descending array
	int[] intArray = new int[] { 11, 12, 13, 14, 14, 15, 16 };
	try {
		UnimodalSequence.getLength_longestUnimodalSequence(intArray);
		fail("should have resulted in an exception");
	} catch (NoUnimodalSequenceException e) {
		// ...
	}
}

@Test
public void test8() {
	// smallest unimodal sequence
	int[] intArray = new int[] { 10, 12, 11 };
	try {
		assertEquals(3, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
	} catch (NoUnimodalSequenceException e) {
		fail("no exception expected");
	}
}

@Test
public void test9() {
	// two unimodal sequences, one longer than the other
	// 10, 12, 11 is one sequence
	// 11, 17, 9, 8, 7 is the other sequence (which is also longer)
	int[] intArray = new int[] { 13, 10, 12, 11, 17, 9, 8, 7, 10 };
	try {
		assertEquals(5, UnimodalSequence.getLength_longestUnimodalSequence(intArray));
	} catch (NoUnimodalSequenceException e) {
		fail("no exception expected");
	}
}
```

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

## Answers to FAQs

#### Can I consult Java documentation and other Internet-based sources?

Yes, you can. The point of this test is not to demonstrate mastery over syntax but that you can solve a problem in a reasonable amount of time with reasonable resources.

*If you find useful information online outside the official Java documentation and the course material, you must cite the source. You should do so by adding comments in your source code.*

Naturally you are expected to adhere to all of the course and UBC policies on academic integrity.

#### Isn't one hour too short to produce a working implementation?

The questions are straightforward, and these are not very different from what one might sometimes encounter on a job interview (for example). The difference is that you get less time during an interview (10-15 minutes) with no access to additional resources. So the time allotted is reasonable in that regard and I am expecting that everyone will be able to clear this bar. The goal is that it is possible to say, at a minimal level, what everyone who completes this course can achieve.

#### Why am I not guaranteed full credit if my implementation passes all the provided tests?

It is easy to develop an implementation that passes the provided tests and not much else. A good-faith implementation that passes all the provided tests is very likely to pass other tests too.
