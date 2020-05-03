package com.gbicr.service;

import com.gbicr.model.Leader;

import java.util.List;

public interface LeaderService {
    Leader save (Leader leader);
    List<Leader> getAllLeader();
    Leader findById(String id);
    List<Leader> searchLeaderByName(String name);
    Leader update (String id, Leader leader);
    void deleteById(String id);
}
