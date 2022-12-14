package com.dh.catalogservice.api.service;

import com.dh.catalogservice.domain.model.dto.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "movie-service")
public interface MovieFeignClient {

    @GetMapping("/movies/{genre}")
    ResponseEntity<List<Movie>> findMovieByGenre(@PathVariable("genre") String genre);
}