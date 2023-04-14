package com.viktor.deviceassignments.entity.dto;

import com.viktor.deviceassignments.entity.Status;
import com.viktor.deviceassignments.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {

  private String title;

  private Status status;

  private Type type;

}
