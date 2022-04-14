package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import com.dh.catalogservice.domain.repository.MovieFeignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieFeignRepository movieFeignRepository;

	@Autowired
	public CatalogServiceImpl(MovieFeignRepository movieFeignRepository) {
		this.movieFeignRepository = movieFeignRepository;
	}


	@Override
	public CatalogWS getListByGenre(String genre) {
		List<MovieWS> moviesByGenre = movieFeignRepository.getListByGenre(genre);
		return CatalogWS.builder()
				.genre(genre)
				.movies(moviesByGenre)
				.build();
	}
}
