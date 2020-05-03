package com.gbicr.serviceimpl;

import com.gbicr.exception.NotFoundException;
import com.gbicr.exception.SuccessException;
import com.gbicr.model.Community;
import com.gbicr.repository.CommunityRepo;
import com.gbicr.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    CommunityRepo communityRepo;

    @Override
    public Community save(Community community) {
        return communityRepo.save(community);
    }

    @Override
    public List<Community> getAllCommunity() {
        return communityRepo.findAll();
    }

    @Override
    public Community findById(String id) {
        List<Community> communities = communityRepo.findAll();
        for (Community community:communities ) {
            if(community.getId().equals(id)){
                return communityRepo.findById(id).get();
            }

        }
        throw new NotFoundException("id " + id + " in community is not found");
    }

    @Override
    public Community update(String id, Community community) {
        Community someCommunity = communityRepo.findById(id).orElseThrow(()-> new NotFoundException("id " + id + " is not found"));
        someCommunity.setId(community.getId());
        someCommunity.setContact(community.getContact());
        someCommunity.setName(community.getName());
        someCommunity.setDetail(community.getDetail());
        someCommunity.setLink_photo(community.getLink_photo());
        return communityRepo.save(someCommunity);
    }

    @Override
    public void deleteById(String id) {
        Community community = findById(id);
        communityRepo.deleteById(community.getId());
        throw new SuccessException("Success");
    }
}
