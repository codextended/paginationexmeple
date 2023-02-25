package dev.codextended.paginationexmeple.dto;

import dev.codextended.paginationexmeple.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse {
    private List<Person> data;
    private int pageNumber;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
}
