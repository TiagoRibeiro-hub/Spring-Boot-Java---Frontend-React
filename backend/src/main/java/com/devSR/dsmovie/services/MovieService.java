package com.devSR.dsmovie.services;

import com.devSR.dsmovie.dto.MovieDTO;
import com.devSR.dsmovie.entities.Movie;
import com.devSR.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
    
    @Autowired // instancia
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){

        Page<Movie> movieList = repository.findAll(pageable);
        Page<MovieDTO> page = movieList.map(x -> new MovieDTO(x));     
        return page;
    }

    
    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){

        Movie movie = repository.findById(id).get();
        MovieDTO movieDto = new MovieDTO(movie);
        return movieDto;
    }
}
