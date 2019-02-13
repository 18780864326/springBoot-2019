package com.example.demo.repository;

import org.baseRepository.first.BaseRepository;

import com.example.demo.entity.LineArea;

public interface LineAreaRepository extends BaseRepository<LineArea,Long>{
	LineArea findBylineAreaId(Long id);
}
