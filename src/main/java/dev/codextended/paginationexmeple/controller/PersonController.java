package dev.codextended.paginationexmeple.controller;

import dev.codextended.paginationexmeple.dto.PageResponse;
import dev.codextended.paginationexmeple.model.Person;
import dev.codextended.paginationexmeple.repository.PersonSpecifications;
import dev.codextended.paginationexmeple.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PeopleService peopleService;

    // find all people. can be found by firstname or lastname query
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getPeople(
            @RequestParam(value = "firstname", required = false) String firstname,
            @RequestParam(value = "lastname", required = false) String lastname
    ) {
        return ResponseEntity.ok(peopleService.getPeople(firstname, lastname));
    }

    // find all people with pagination. can be found by firstname or lastname query
    @GetMapping(value = "pages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse> getPeoplePage(
            @RequestParam(value = "firstname", required = false) String firstname,
            @RequestParam(value = "lastname", required = false) String lastname,
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "30", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ) {
        return ResponseEntity.ok(peopleService.getPeopleWithPage(firstname, lastname, pageNumber, pageSize, sortBy));
    }
}
