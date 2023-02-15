package dev.codextended.paginationexmeple;

import com.github.javafaker.Faker;
import dev.codextended.paginationexmeple.model.Address;
import dev.codextended.paginationexmeple.model.Person;
import dev.codextended.paginationexmeple.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
@RequiredArgsConstructor
public class PaginationexmepleApplication {

	private final PersonRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(PaginationexmepleApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner() {
//		Faker faker = new Faker();
//		return args -> {
//			List<Person> people = IntStream.rangeClosed(1, 1000)
//					.mapToObj(i -> new Person(
//							faker.name().firstName(),
//							faker.name().lastName(),
//							faker.phoneNumber().cellPhone(),
//							new Address(
//									faker.address().city(),
//									faker.address().streetAddress()
//							)
//					))
//					.toList();
//
//			personRepository.saveAll(people);
//		};
//	}

}
