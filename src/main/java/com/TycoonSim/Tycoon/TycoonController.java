package com.TycoonSim.Tycoon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller class for handling Tycoon-related requests.
 */
@RestController
public class TycoonController {

    private final TycoonRepository tycoonRepository;

    /**
     * Constructor for TycoonController.
     *
     * @param tycoonRepository the repository for Tycoon entities
     */
    public TycoonController(TycoonRepository tycoonRepository) {
        this.tycoonRepository = tycoonRepository;
    }

    /**
     * Handles the POST request to save a TycoonRecord.
     *
     * @param tycoon the Tycoon object to be saved
     * @return a string indicating the result of the save operation
     */
    @PostMapping("/saveTycoonRecord")
    @CrossOrigin(origins = "*")
    public String saveTycoonRecord(@RequestBody Tycoon tycoon) {
        if (tycoon == null) {
            return "The Tycoon record is invalid";
        }
        this.tycoonRepository.save(tycoon);
        return "success";
    }

    /**
     * Handles the GET request to find all TycoonRecords.
     *
     * @return a list of Tycoon objects representing all TycoonRecords
     */
    @GetMapping("/findAllTycoonRecord")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<Tycoon> findAllTycoonRecord() {
        Iterable<Tycoon> tycoonRecords = this.tycoonRepository.findAll();
        List<Tycoon> tycoonList = new ArrayList<>();
        tycoonRecords.forEach(tycoonList::add);
        return tycoonList;
    }
}
