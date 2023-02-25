package dev.codextended.paginationexmeple.service;

import dev.codextended.paginationexmeple.dto.PageResponse;
import dev.codextended.paginationexmeple.model.Person;
import dev.codextended.paginationexmeple.repository.PersonRepository;
import dev.codextended.paginationexmeple.repository.PersonSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PeopleService {

    private final PersonRepository personRepository;

    public List<Person> getPeople(String firstname, String lastname) {
        Specification<Person> specifications = PersonSpecifications.hasFirstnameLike("m")
                .and(PersonSpecifications.hasLastnameLike("d"));

        Specification<Person> specification = PersonSpecifications.getSpec(firstname, lastname);
        return personRepository.findAll(specification);
    }

    public PageResponse getPeopleWithPage(String firstname, String lastname, int pageNumber, int pageSize, String sortBy) {
        Specification<Person> specification = PersonSpecifications.getSpec(firstname, lastname);

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Person> peoplePage = personRepository.findAll(specification, pageRequest);
        List<Person> people = peoplePage.getContent();

        return new PageResponse(
                people,
                peoplePage.getNumber(),
                peoplePage.getSize(),
                peoplePage.getTotalElements(),
                peoplePage.getTotalPages()
        );
    }
}
