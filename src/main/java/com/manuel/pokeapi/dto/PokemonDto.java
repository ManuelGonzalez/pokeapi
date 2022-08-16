
package com.manuel.pokeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDto {

  private Integer id;
  private String name;
  private Float weight;
  private List<PokemonTypeDto> types;
  private List<PokemonAbilityDto> abilities;
  private ImageDto sprites;

}
