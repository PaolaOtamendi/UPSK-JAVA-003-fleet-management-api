package com.fletmanagement.demo.service;

import com.fletmanagement.demo.model.Taxi;
import com.fletmanagement.demo.repository.TaxiRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class TaxiServiceImplement implements TaxiService{

    @Autowired
    private TaxiRepository taxiRepository;

    public TaxiServiceImplement(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    @Override
    @Transactional
    public Page<Taxi> findAll(Pageable pageable) {
        return taxiRepository.findAll(pageable);
    }
}
