package com.fletmanagement.demo.controller;
import com.fletmanagement.demo.service.TaxiService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fletmanagement.demo.model.Taxi;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/taxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Taxi>> getAllTaxis(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        Page<Taxi> taxis = taxiService.findAll(pageable);
        return  ResponseEntity.ok(taxis);
    }

    /*public ResponseEntity<Page<Taxi>> getAllTaxis(Pageable pageable) {
        try {
            Page<Taxi> taxis = taxiService.findAll(pageable);
            return new ResponseEntity<>(taxis, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error retrieving taxis: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    /*@GetMapping("/all")
    public ResponseEntity<List<Taxi>> getAllTaxis() {
        try {
            List<Taxi> taxis = taxiService.findAll();
            return new ResponseEntity<>(taxis, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error retrieving taxis: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

}
