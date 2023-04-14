package com.viktor.deviceAssignments.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assets")
public class Asset {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  @Enumerated(EnumType.STRING)
  private Status assetStatus;

  @Enumerated(EnumType.STRING)
  private Type assetType;

  private LocalDateTime createdOn;

  private LocalDateTime sentAt;

  @Column(name = "returned", columnDefinition = "boolean default true")
  private boolean returned = true;

  @JoinColumn(name = "employee_id")
  @ManyToOne
  private Employee employee;

}
