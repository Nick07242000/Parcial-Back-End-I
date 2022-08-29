package com.dh.catalogservice.api.controller;

import com.dh.catalogservice.api.service.ICatalogService;
import com.dh.catalogservice.domain.model.dto.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

	@Qualifier("CatalogServiceImpl")
	private final ICatalogService catalogService;

	@Value("${server.port}")
	private String port;

	@Autowired
	public CatalogController(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<Catalog> getCatalogByGenre(@PathVariable String genre, HttpServletResponse response) {
		Catalog playlistDTO = catalogService.getCatalogByGenre(genre);
		response.addHeader("port", port);
		return Objects.isNull(playlistDTO)
				? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(playlistDTO, HttpStatus.OK);
	}

}
