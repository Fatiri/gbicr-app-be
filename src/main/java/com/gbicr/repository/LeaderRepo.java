package com.gbicr.repository;

import com.gbicr.model.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaderRepo extends JpaRepository<Leader, String> {

    @Query("Select a from Leader a where a.name LIKE  %?1%")
    List<Leader> searchLeaderByName(String name);
}
