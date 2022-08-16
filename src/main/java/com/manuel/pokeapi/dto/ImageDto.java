
package com.manuel.pokeapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

  @JsonProperty("front_default")
  private String icon;

  @JsonProperty("other")
  private Map<String,Object> other;
    
}
