package com.example.avaliacao_movieservice.api.service;

import com.example.avaliacao_movieservice.domain.model.Movie;
import com.example.avaliacao_movieservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

	@Autowired
	MovieRepository repository;

	public List<Movie> findByGenre(String genre) {
		return repository.findByGenre(genre);
	}

	public Movie save(Movie movie) {
		return repository.save(movie);
	}
}
