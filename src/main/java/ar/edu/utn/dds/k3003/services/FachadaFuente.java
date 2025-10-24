package ar.edu.utn.dds.k3003.services;

import ar.edu.utn.dds.k3003.facades.FachadaProcesadorPdI;
import ar.edu.utn.dds.k3003.facades.dtos.ColeccionDTO;
import ar.edu.utn.dds.k3003.facades.dtos.HechoDTO;
import ar.edu.utn.dds.k3003.facades.dtos.PdIDTO;

import java.util.List;
import java.util.NoSuchElementException;

public interface FachadaFuente {

    HechoDTO buscarHechoXId(String var1) throws NoSuchElementException;

     void ocultarHecho(String var1);

}
