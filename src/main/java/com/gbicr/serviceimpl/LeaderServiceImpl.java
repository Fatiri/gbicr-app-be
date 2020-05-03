package com.gbicr.serviceimpl;

import com.gbicr.exception.NotFoundException;
import com.gbicr.exception.SuccessException;
import com.gbicr.model.Leader;
import com.gbicr.repository.LeaderRepo;
import com.gbicr.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    LeaderRepo leaderRepo;
    @Override
    public Leader save(Leader leader) {
        return leaderRepo.save(leader);
    }

    @Override
    public List<Leader> getAllLeader() {
        return leaderRepo.findAll();
    }

    @Override
    public Leader findById(String id) {
        List<Leader> leaders = leaderRepo.findAll();
        for (Leader leader:leaders ) {
            if(leader.getId().equals(id)){
                return leaderRepo.findById(id).get();
            }

        }
        throw new NotFoundException("id " + id + " in leader is not found");
    }

    @Override
    public List<Leader> searchLeaderByName(String name) {
        List<Leader> leaders = leaderRepo.searchLeaderByName(name);
        if(leaders.size() == 0){
            throw new NotFoundException("leader " + name + " is not found");
        }else {
            return leaders;
        }
    }

    @Override
    public Leader update(String id, Leader leader) {
        Leader someLeader = leaderRepo.findById(id).orElseThrow(()-> new NotFoundException("id " + id + " is not found"));
        someLeader.setId(leader.getId());
        someLeader.setPosition(leader.getPosition());
        someLeader.setName(leader.getName());
        someLeader.setLink_photo(leader.getLink_photo());
        return leaderRepo.save(someLeader);
    }

    @Override
    public void deleteById(String id) {
        Leader leader = findById(id);
        leaderRepo.deleteById(leader.getId());
        throw new SuccessException("Success");
    }
}
