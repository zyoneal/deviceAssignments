package com.viktor.deviceassignments.service.impl;

import com.viktor.deviceassignments.entity.Asset;
import com.viktor.deviceassignments.entity.dto.AssetDto;
import com.viktor.deviceassignments.repository.AssetRepository;
import com.viktor.deviceassignments.service.AssetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssetServiceImpl implements AssetService {

  private final AssetRepository assetRepository;

  private final ModelMapper modelMapper;

  @Override
  public void deleteById(Long id) {
    try {
      assetRepository.deleteById(id);
    } catch (EmptyResultDataAccessException exception) {
      log.info(exception.getMessage(),exception);
    }
  }

  @Override
  public Optional<Asset> updateStatus(Long id, AssetDto assetDto) {
    return assetRepository.findById(id)
            .map(asset -> {
              Asset assetEntity = modelMapper.map(assetDto, Asset.class);
              assetEntity.setId(id);
              return assetRepository.save(assetEntity);
            });
  }

}