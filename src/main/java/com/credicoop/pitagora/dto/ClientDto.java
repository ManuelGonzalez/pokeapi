
package com.credicoop.pitagora.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

  public String idPersona;
  public String claveBUP;
  public String restricciones;
  public String motivoDesvinculacion;
  public String tipoCaptura;
  public String tipoDoc;
  public String nroDoc;
  public String emisor;
  public String tipoDoc2;
  public String nroDoc2;
  public String emisor2;
  public String tipoCUI;
  public String nroCUI;
  public String nroCUIAnt;
  public String nroInterno;
  public String nroDeInscEnte;
  public String apellidoRazonSocial;
  public String apellidoCasadaNombFantasia;
  public String nombre;
  public String tipoPersona;
  public String provinciaDomic;
  public String localidadDomic;
  public String idVigEnUnificacion;
    
}
