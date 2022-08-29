package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.ICatalogService;
import com.dh.catalogservice.api.service.MovieFeignClient;
import com.dh.catalogservice.domain.model.dto.Catalog;
import com.dh.catalogservice.domain.model.dto.Movie;
import com.dh.catalogservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CatalogServiceImpl implements ICatalogService {

	private static Logger log = Logger.getLogger(CatalogServiceImpl.class.getName());
	private final MovieFeignClient movieFeignClient;

	@Autowired
	public CatalogServiceImpl(MovieFeignClient movieFeignClient) {
		this.movieFeignClient = movieFeignClient;
	}

	@Override
	public Catalog getCatalogByGenre(String genre) {

		ResponseEntity<List<Movie>> movieResponse = movieFeignClient.findMovieByGenre(genre);
		log.info("movie-service port: " + movieResponse.getHeaders().get("port"));
		if (movieResponse.getStatusCode().is2xxSuccessful())
			return new Catalog(genre, movieResponse.getBody());
		return null;

	}

}
