package org.lambda.unit4.methodRefAndForEach;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.lambdaBasics.Person;

public class MethodReferenceLambda2 {

	public static void main(String[] args) {
		List people=Arrays.asList(new Person("jiby", "jose", 29),
				new Person("Tinku", "Abraham", 30),
				new Person("Joanna", "Abraham", 1));
		//1. sort list by last name
//		Collections.sort(people, new LastNameComparator());
		System.out.println("print all persons sorted by last mame");
		Collections.sort(people, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		
		
		//2. create a method that prints all elements in the list
		
		//System.out.println is not a static method. Its an instance method.System is a static reference to get the object out. 
		//out is an instance. println is an instance method.inorder to call the instance method println we are using the instance system.out
		printConditionally(people, p->true, System.out::println);//p->method(p)
															//System.out::println == p->System.out.println(p)
		
		//3. create a method that prints all person who have last name beginning with a
		//anonymous class
		System.out.println("print person lastname starting with a ");
		printConditionally(people,p->p.lastName.startsWith("A"), p->System.out.println(p));
		System.out.println("print person firstname starting with J");
		printConditionally(people,p->p.firstName.startsWith("J"), p->System.out.println(p));
	}
	private static void printConditionally(List<Person> people, Predicate<Person> predicate,Consumer<Person> consumer) {
		
		for(Person p:people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
	}}

}
