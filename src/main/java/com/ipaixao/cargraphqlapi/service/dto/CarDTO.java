package com.ipaixao.cargraphqlapi.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ipaixao.cargraphqlapi.domain.AuditLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

  private Long id;

  @Max(40)
  @NotNull
  private String brand;

  @Max(50)
  @NotNull
  private String model;

  @Max(30)
  @NotNull
  private String color;

  @NotNull
  @Positive(groups = int.class)
  private Integer year;

  @NotNull
  @Positive(groups = BigDecimal.class)
  private BigDecimal price;

  private String description;

  @NotNull private Boolean isNew;

  @JsonIgnore private AuditLog auditLog;
}
