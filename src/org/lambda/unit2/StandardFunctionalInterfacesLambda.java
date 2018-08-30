package org.lambda.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.lambdaBasics.Condition;
import org.lambdaBasics.Person;

public class StandardFunctionalInterfacesLambda {
	public static void main(String[] args) {
		List people=Arrays.asList(new Person("jiby", "jose", 29),
				new Person("Tinku", "Abraham", 30),
				new Person("Joanna", "Abraham", 1));
		//1. sort list by last name
//		Collections.sort(people, new LastNameComparator());
		Collections.sort(people, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		
		
		//2. create a method that prints all elements in the list
		System.out.println("print all persons ");
//		printSortedPersonList(people);
		printConditionally(people, p->true, p->System.out.println(p));
		
		//3. create a method that prints all person who have last name beginning with a
		//anonymous class
		System.out.println("print person lastname starting with a ");
		printConditionally(people,p->p.lastName.startsWith("A"), p->System.out.println(p));
		System.out.println("print person firstname starting with J");
		printConditionally(people,p->p.firstName.startsWith("J"), p->System.out.println(p));

			//without anonymous class
//		ConditionImp imp=new ConditionImp();
//		printConditionally(people, imp);
		//3. create a method that prints all person who have first name beginning with J
		

	}
	
	private static void printConditionally(List<Person> people, Predicate<Person> predicate,Consumer<Person> consumer) {
		
		for(Person p:people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
	}
	}



//	public static void printSortedPersonList(List<Person> people) {
//		for(Person p:people) {
//			
//			System.out.println(p);
//		}
//	}

}
