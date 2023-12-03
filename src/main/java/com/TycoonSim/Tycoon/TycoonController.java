package com.TycoonSim.Tycoon;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class TycoonController {
    private final TycoonRepository tycoonRepository;

    public TycoonController(TycoonRepository tycoonRepository) {
        this.tycoonRepository = tycoonRepository;
    }

    @PostMapping("/saveTycoonRecord")
    @CrossOrigin(origins = "*")
    public String saveTycoonRecord(@RequestBody Tycoon tycoon) {
        if (tycoon == null) {
            return "The book is invalid";
        }
        this.tycoonRepository.save(tycoon);
        return "success";
    }

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

