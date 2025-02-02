package com.fletmanagement.demo.service;

import com.fletmanagement.demo.model.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface TaxiService {
    @Transactional
    Page<Taxi> findAll(Pageable pageable);
}
