package org.lambdaBasics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassExample {

	public static void main(String[] args) {
		List people=Arrays.asList(new Person("jiby", "jose", 29),
				new Person("Tinku", "Abraham", 30),
				new Person("Joanna", "Abraham", 1));
		//1. sort list by last name
//		Collections.sort(people, new LastNameComparator());
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.lastName.compareTo(p2.lastName);
			}
		});
		
		
		
		//2. create a method that prints all elements in the list
		System.out.println("print all persons ");
//		printSortedPersonList(people);
		printConditionally(people, new Condition() {
			
			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				return true;
			}
		});
		
		//3. create a method that prints all person who have last name beginning with a
//		printPersonLastNameA(people);
		//anonymous class
		System.out.println("print person lastname starting with a ");
		printConditionally(people,new Condition() {
			
				@Override
				public boolean test(Person p) {
					// TODO Auto-generated method stub
					return p.lastName.startsWith("A");
				}

				
		
			
		});
		System.out.println("print person firstname starting with J");
		printConditionally(people,new Condition() {
			
			

			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				return p.firstName.startsWith("J");
			}
	
		
	});

			//without anonymous class
//		ConditionImp imp=new ConditionImp();
//		printConditionally(people, imp);
		//3. create a method that prints all person who have first name beginning with J
		

	}
	
	private static void printConditionally(List<Person> people, Condition condition) {
		
		for(Person p:people) {
			if(condition.test(p)) {
				System.out.println(p);
			}
	}
	}

//	private static void printPersonLastNameA(List<Person> people) {
//		for(Person p:people) {
//			if(p.lastName.startsWith("A"))
//				System.out.println("print person lastname starting with a "+p);
//		}
//		
//	}

//	public static void printSortedPersonList(List<Person> people) {
//		for(Person p:people) {
//			
//			System.out.println(p);
//		}
//	}


}
