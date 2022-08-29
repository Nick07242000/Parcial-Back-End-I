package com.dh.catalogservice.domain.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor
public class Movie {

    private Integer id;
    private String name;
    private String genre;
    private String urlStream;

}
