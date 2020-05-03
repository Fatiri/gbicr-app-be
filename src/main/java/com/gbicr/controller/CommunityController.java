package com.gbicr.controller;

import com.gbicr.model.Community;
import com.gbicr.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/community")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @GetMapping("/all")
    public ResponseEntity<List<Community>> getListComunity() {
        List<Community> communities = communityService.getAllCommunity();
        return new ResponseEntity<>(communities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> findById(@PathVariable String id){
        Community communityFindId = communityService.findById(id);
        return new ResponseEntity<>(communityFindId,HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<Community> addCommunity(@Valid @RequestBody Community community) {
        Community addCommunity = communityService.save(community);
        return new ResponseEntity<>(addCommunity, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Community> updateEvent(@PathVariable(value = "id") String id, @Valid @RequestBody Community community) {
        Community community1 = communityService.update(id,community);
        return new ResponseEntity<>(community1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        communityService.deleteById(id);
    }


}
