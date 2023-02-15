package dev.codextended.paginationexmeple.repository;

import dev.codextended.paginationexmeple.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
