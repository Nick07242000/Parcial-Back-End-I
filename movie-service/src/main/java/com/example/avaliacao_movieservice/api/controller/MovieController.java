package com.example.avaliacao_movieservice.api.controller;

import com.example.avaliacao_movieservice.api.service.MovieService;
import com.example.avaliacao_movieservice.domain.model.Movie;
import com.example.avaliacao_movieservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService service;

	@GetMapping("/{genre}")
	ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(service.findByGenre(genre));
	}

	@PostMapping("/save")
	ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok().body(service.save(movie));
	}
}
