package com.fletmanagement.demo.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fletmanagement.demo.model.Taxi;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
    Page<Taxi> findAll(Pageable pageable);
}
