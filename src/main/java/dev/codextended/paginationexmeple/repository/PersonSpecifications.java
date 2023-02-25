package dev.codextended.paginationexmeple.repository;

import dev.codextended.paginationexmeple.model.Person;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PersonSpecifications {

    public static Specification<Person> hasFirstnameLike(String firstname) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.<String>get("firstname"), "%" + firstname + "%");
    }

    public static Specification<Person> hasLastnameLike(String lastname) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("lastname"), "%" + lastname + "%");
    }

    public static Specification<Person> getSpec(String firstname, String lastname) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (firstname != null && !firstname.isEmpty()){
                predicates.add(criteriaBuilder.like(root.get("firstname"), "%" + firstname + "%"));
            }
            if (lastname != null && !lastname.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("lastname"), "%" + lastname + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
