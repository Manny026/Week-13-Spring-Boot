package com.promineotech.jeeps.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeeps {

  private Long modelPK;
  
  private JeepModel modelId;
  
  private String trimLevel;
  
  private int numDoors;
  
  private int wheelSize;
  
  private BigDecimal basePrice;
  
}
