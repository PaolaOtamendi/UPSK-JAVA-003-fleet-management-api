package com.fletmanagement.demo.service;

import com.fletmanagement.demo.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface TrajectoriesService {

    @Transactional
    /*Page<Trajectories> findAll(Pageable pageable);*/
    public Page<Trajectories> findTaxiHistoryByTaxiIdAndDate(Integer taxiId, String date, Pageable pageable);
}
