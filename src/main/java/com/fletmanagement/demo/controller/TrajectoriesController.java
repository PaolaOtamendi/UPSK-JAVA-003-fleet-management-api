package com.fletmanagement.demo.controller;

import com.fletmanagement.demo.model.Trajectories;
import com.fletmanagement.demo.service.TrajectoriesService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trajectories")
public class TrajectoriesController {

    @Autowired
    private TrajectoriesService trajectoriesService;

    public TrajectoriesController (TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }

    @GetMapping("/history/{taxiId}")

    public ResponseEntity<Page<Trajectories>> getTaxiHistory(
            @PathVariable Integer taxiId,
            @RequestParam(required = false) /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)*/ String date,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Trajectories> locations = trajectoriesService.findTaxiHistoryByTaxiIdAndDate(taxiId, date, pageable);

        return ResponseEntity.ok(locations);
    }
}

