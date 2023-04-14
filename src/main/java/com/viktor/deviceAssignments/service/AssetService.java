package com.viktor.deviceAssignments.service;

import com.viktor.deviceassignments.entity.Asset;
import com.viktor.deviceassignments.entity.dto.AssetDto;

import java.util.Optional;

public interface AssetService {

  void deleteById(Long id);

  Optional<Asset> updateStatus(Long id, AssetDto assetDto);

}
