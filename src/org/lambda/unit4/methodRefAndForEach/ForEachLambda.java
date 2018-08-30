package org.lambda.unit4.methodRefAndForEach;

import java.util.Arrays;
import java.util.List;

import org.lambdaBasics.Person;

public class ForEachLambda {

	public static void main(String[] args) {
		List<Person> people=Arrays.asList(new Person("jiby", "jose", 29),
				new Person("Tinku", "Abraham", 30),
				new Person("Joanna", "Abraham", 1));
		System.out.println("using for loop");
		for(int i=0;i<people.size();i++) {
			System.out.println(people.get(i));
		}
		System.out.println("using for each loop");
		for(Person p : people) {
			System.out.println(p);
		}
		System.out.println("using lambda for each loop which is an internal iterator");
		people.forEach(System.out::println);//System.out::println == p->system.out.println(p)
	}

}
	