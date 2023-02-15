package dev.codextended.paginationexmeple.repository;

import dev.codextended.paginationexmeple.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
