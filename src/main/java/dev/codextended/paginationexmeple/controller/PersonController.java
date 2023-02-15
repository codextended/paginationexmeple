package dev.codextended.paginationexmeple.controller;

import dev.codextended.paginationexmeple.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PeopleService peopleService;

}
