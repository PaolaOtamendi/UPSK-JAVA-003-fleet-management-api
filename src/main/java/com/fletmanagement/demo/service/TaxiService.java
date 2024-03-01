package com.fletmanagement.demo.service;
import com.fletmanagement.demo.model.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface TaxiService {
    /*public List<Taxi> findAll();*/
    @Transactional
    Page<Taxi> findAll(Pageable pageable);

    /*public Taxi save(Taxi taxi);
    public Taxi findById(Integer id);
    public void delete(Taxi taxi);*/
}
