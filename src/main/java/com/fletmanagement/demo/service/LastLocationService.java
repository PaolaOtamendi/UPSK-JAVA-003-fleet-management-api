package com.fletmanagement.demo.service;

import com.fletmanagement.demo.model.Trajectories;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LastLocationService {

    @Transactional
    public Page<Trajectories> findLatestTaxiLocations(Pageable pageable);
}
