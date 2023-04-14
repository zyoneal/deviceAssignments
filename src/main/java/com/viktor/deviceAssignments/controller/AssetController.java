package com.viktor.deviceAssignments.controller;

import com.viktor.deviceassignments.entity.dto.AssetDto;
import com.viktor.deviceassignments.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assets")
@RequiredArgsConstructor
public class AssetController {

  private final AssetService assetService;

  private final ModelMapper modelMapper;

  // TODO remove assignment
  @DeleteMapping("/{id:[\\d]+}")
  public ResponseEntity<AssetDto> delete(@PathVariable Long id) {
    assetService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  // TODO update assignment status / mark asset as (lost/broken)
  @PutMapping("/{id:[\\d]+}")
  public ResponseEntity<AssetDto> updateStatus(@PathVariable Long id, @RequestBody AssetDto assetDto) {
    return assetService.updateStatus(id, assetDto)
            .map(asset -> ResponseEntity.ok(modelMapper.map(asset, AssetDto.class)))
            .orElseThrow(RuntimeException::new);
  }

}
