package com.devSR.dsmovie.repositories;

import com.devSR.dsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepositorie extends JpaRepository<Movie, Long> {
    
}
