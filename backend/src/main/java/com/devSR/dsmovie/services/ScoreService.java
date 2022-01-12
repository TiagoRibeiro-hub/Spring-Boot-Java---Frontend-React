package com.devSR.dsmovie.services;

import com.devSR.dsmovie.dto.MovieDTO;
import com.devSR.dsmovie.dto.ScoreDTO;
import com.devSR.dsmovie.entities.Movie;
import com.devSR.dsmovie.entities.Score;
import com.devSR.dsmovie.entities.User;
import com.devSR.dsmovie.repositories.MovieRepository;
import com.devSR.dsmovie.repositories.ScoreRepository;
import com.devSR.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScoreService {
    
    @Autowired // instancia
    private MovieRepository movieRepository;

    @Autowired // instancia
    private UserRepository userRepository;

    @Autowired // instancia
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDto){

        User user = userRepository.findByEmail(scoreDto.getEmail());

        if(user == null){
            user = new User();
            user.setEmail(scoreDto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();

        Score score = new Score();
        score.setUser(user);
        score.setMovie(movie);
        score.setValue(scoreDto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum = sum + s.getValue();
        }
        double avg = sum / movie.getScores().size();
        
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        movie = movieRepository.saveAndFlush(movie);

        return new MovieDTO(movie);
    }
}
