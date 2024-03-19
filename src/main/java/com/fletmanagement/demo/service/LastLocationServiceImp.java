package com.fletmanagement.demo.service;

import com.fletmanagement.demo.model.Trajectories;
import com.fletmanagement.demo.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class LastLocationServiceImp implements LastLocationService {

    @Autowired
    private TrajectoriesRepository trajectoriesRepository;

    public LastLocationServiceImp(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }

    @Override
    @Transactional
    public Page<Trajectories> findLatestTaxiLocations(Pageable pageable) {
        return trajectoriesRepository.findLatestTaxiLocations(pageable);
    }
}
