package com.gbicr.controller;

import com.gbicr.model.Leader;
import com.gbicr.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/leader")
public class LeaderController {

    @Autowired
    LeaderService leaderService;

    @GetMapping("/all")
    public ResponseEntity<List<Leader>> getAllLeader(){
        List<Leader> leaderList = leaderService.getAllLeader();
        return new ResponseEntity<>(leaderList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Leader> addLeader(@Valid @RequestBody Leader leader){
        Leader someLeader = leaderService.save(leader);
        return new ResponseEntity<>(someLeader, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leader> getDetailLeader(@PathVariable String id){
        Leader leader = leaderService.findById(id);
        return new ResponseEntity<>(leader, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leader> updateLeader(@PathVariable(value = "id") String id, @Valid @RequestBody Leader leader){
        Leader leaderUpdate = leaderService.update(id, leader);
        return new ResponseEntity<>(leaderUpdate, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public void deleteLeader(@PathVariable String id) {
        leaderService.deleteById(id);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Leader>> findLeaderByName(@PathVariable String name){
        List<Leader> leaders = leaderService.searchLeaderByName(name);
        return new ResponseEntity<>(leaders, HttpStatus.OK);
    }


}
