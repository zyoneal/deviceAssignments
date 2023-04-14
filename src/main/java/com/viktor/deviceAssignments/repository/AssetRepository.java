package com.viktor.deviceAssignments.repository;

import com.viktor.deviceassignments.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
