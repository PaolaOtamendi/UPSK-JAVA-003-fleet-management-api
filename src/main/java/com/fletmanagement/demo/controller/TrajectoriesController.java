package com.fletmanagement.demo.controller;

import com.fletmanagement.demo.model.Taxi;
import com.fletmanagement.demo.model.Trajectories;
import com.fletmanagement.demo.service.TaxiService;
import com.fletmanagement.demo.service.TrajectoriesService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/trajectories")
public class TrajectoriesController {

    @Autowired
    private TrajectoriesService trajectoriesService;

    public TrajectoriesController (TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }

    @GetMapping("/all")
    /*public ResponseEntity<Page<Trajectories>> getAllTrajectories(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        Page<Trajectories> taxis = trajectoriesService.findAll(pageable);
        return  ResponseEntity.ok(taxis);
    }*/

    public ResponseEntity<Page<Trajectories>> getAllTrajectories(
            @PathVariable Integer taxiId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String date,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Trajectories> locations = trajectoriesService.findAll(taxiId, date, pageable);

        return ResponseEntity.ok(locations);
    }
}

