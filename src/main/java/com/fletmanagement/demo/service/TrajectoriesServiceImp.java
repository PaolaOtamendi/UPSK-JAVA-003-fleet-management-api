package com.fletmanagement.demo.service;

import com.fletmanagement.demo.model.Trajectories;
import com.fletmanagement.demo.repository.TrajectoriesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TrajectoriesServiceImp implements TrajectoriesService {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public TrajectoriesServiceImp(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    @Override
    @Transactional
    /*public Page<Trajectories> findAll(Pageable pageable) {
        return trajectoriesRepository.findAll(pageable);}*/
    public Page<Trajectories> findTaxiHistoryByTaxiIdAndDate(Integer taxiId, String date, Pageable pageable) {
        return trajectoriesRepository.findTaxiHistoryByTaxiIdAndDate(taxiId, date, pageable);
    }
}


