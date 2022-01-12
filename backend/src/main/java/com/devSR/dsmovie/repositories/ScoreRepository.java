package com.devSR.dsmovie.repositories;

import com.devSR.dsmovie.entities.Score;
import com.devSR.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
    
}
