package dev.codextended.paginationexmeple.service;

import dev.codextended.paginationexmeple.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PersonRepository personRepository;
}
