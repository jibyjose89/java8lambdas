package org.lambda.unit5.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.lambdaBasics.Person;

public class StreamsLambda {

	public static void main(String[] args) throws IOException {
		List<Person> people=Arrays.asList(new Person("Jiby", "jose", 29),
				new Person("Tinku", "Abraham", 30),
				new Person("Joanna", "Abraham", 1));
		people.stream().filter(p->p.getFirstName().startsWith("J"))
		.forEach(p->System.out.println(p.getFirstName()));
		
		long count= people.stream().filter(p->p.getFirstName().startsWith("J"))
		.count();
		System.out.println(count);
		
		//parallel processing
		
		people.parallelStream().filter(p->p.getFirstName().startsWith("J"))
		.forEach(p->System.out.println(p.getFirstName()));
		System.out.println();
		String[] names= {"jiby", "anu", "joby", "tinku", "joanna", "jose"};
		Arrays.stream(names).
		filter(x->x.startsWith("j")).
		sorted().
		forEach(System.out::println);
		
		System.out.println();
		Arrays.stream(new int[] {1,2,3,4,5,6,7,8,9,10}).
		map(x-> x * x).
		forEach(System.out::println);
		
		System.out.println();
		Arrays.stream(new int[] {1,2,3,4,5,6,7,8,9,10}).
		map(x-> x * x).
		average().
		ifPresent(System.out::println);
		
		System.out.println();
		people.stream().
		map(Person::getFirstName).
//		map(x->x.firstName.toLowerCase()).
		filter(x->x.startsWith("T")).
		forEach(System.out::println);
		
		System.out.println();
		List<String> malayalis=Arrays.asList("jiby", "anu", "nycil", "tinku", "joanna");
		malayalis.stream().
		map(String::toUpperCase).
		filter(x->x.startsWith("A")).
		forEach(System.out::println);
		
//		System.out.println();
//		String filename="bible.txt";
//	    Path pathToFile = Paths.get(filename);
//	    System.out.println(pathToFile);
//		Stream<String> bible= Files.lines(pathToFile,StandardCharsets.UTF_8);
//		long num=bible.count();
//		System.out.println(num);
		System.out.println();
		Stream<String> bands = Files.lines(Paths.get("c://bands.txt"));
		bands
			.sorted()
			.filter(x -> x.length() > 13)
			.forEach(System.out::println);
		bands.close();
		
		//stream rows from text file and save to list
		System.out.println();
		List<String> bible=Files.lines(Paths.get("c://bands.txt")).
				filter(x->x.contains("sal")).
				collect(Collectors.toList());
		bible.forEach(System.out::println);
		
		System.out.println();
		Stream<String> data=Files.lines(Paths.get("c://data.txt"));
		int rowcount=(int) data.map(x->x.split(",")).filter(x->x.length==3)
				.count();
		System.out.println(rowcount);
		data.close();
		
		System.out.println();
		Stream<String> datz=Files.lines(Paths.get("c://data.txt"));
		datz.map(x->x.split(",")).filter(x->x.length==3).forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));
		datz.close();
		
		System.out.println();
		Stream<String> dat=Files.lines(Paths.get("c://data.txt"));
		dat.map(x->x.split(",")).filter(x->x.length==3).filter(x->Integer.parseInt(x[1])>15).forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));
		dat.close();
		
		//Stream rows from csv file, store fields in hashmap
		System.out.println();
		Stream<String> datacsv= Files.lines(Paths.get("c://data.txt"));
		Map<Object, Object> dataMap=new HashMap();
		dataMap=datacsv.map(x->x.split(",")).filter(x->x.length==3).
				 collect(Collectors.toMap(x->x[0], x->x[1]));
		datacsv.close();
		for(Object key:dataMap.keySet()) {
			System.out.println(key+" "+dataMap.get(key));
		}
		//Reduction-sum
		System.out.println();
		double total=Stream.of(1.1,2.2,3.3,4.4).reduce(0.0, (a,b)->(a+b));
		System.out.println("Total="+total);
		
		//Reduction-Summary statistics-works only for integers
		System.out.println();
		IntSummaryStatistics summaryStat= IntStream.of(1,2,3,4,5,6,7,8,9).summaryStatistics();
		System.out.println(summaryStat);
		
		
	}

}
