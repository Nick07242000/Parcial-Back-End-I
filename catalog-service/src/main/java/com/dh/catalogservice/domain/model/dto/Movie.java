package com.dh.catalogservice.domain.model.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class Movie {

    private Integer id;
    private String name;
    private String genre;
    private String urlStream;
}
