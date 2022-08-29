package com.dh.catalogservice.domain.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder @Data @NoArgsConstructor
public class Catalog {

	private String genre;
	private List<Movie> movies;

	public Catalog(String genre, List<Movie> movies) {
		this.genre = genre;
		this.movies = movies;
	}

}
