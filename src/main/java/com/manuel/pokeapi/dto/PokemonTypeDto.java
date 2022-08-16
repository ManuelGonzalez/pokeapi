
package com.manuel.pokeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonTypeDto {

  private Integer slot;
  private TypeDto type;
    
}
