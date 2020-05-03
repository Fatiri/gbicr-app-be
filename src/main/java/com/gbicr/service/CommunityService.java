package com.gbicr.service;

import com.gbicr.model.Community;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunityService {
    Community save (Community community);
    List<Community> getAllCommunity();
    Community findById(String id);
    Community update (String id, Community community);
    void deleteById(String id);
}
