/*package ar.edi.itn.dds.k3003.app;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.FachadaSolicitudes;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoSolicitudBorradoEnum;
import ar.edu.utn.dds.k3003.facades.dtos.SolicitudDTO;

import java.util.List;

public class TestFachada {
    public static void main(String[] args) {
        SolicitudRepository repo = new InMemorySolicitudRepository();  // Solo para test rápido
        Fachada fachada = new Fachada(repo);

        //Crear una solicitud
        SolicitudDTO dto = new SolicitudDTO(null, "Eliminar hecho viejo",
                EstadoSolicitudBorradoEnum.CREADA, "hecho123");
        SolicitudDTO creada = fachada.agregar(dto);
        System.out.println("Creada: " + creada.id());

        //Buscar por ID
        SolicitudDTO encontrada = fachada.buscarSolicitudXId(creada.id());
        System.out.println("Descripción: " + encontrada.descripcion());

        //Buscar por hecho
        List<SolicitudDTO> solicitudes = fachada.buscarSolicitudXHecho(creada.hechoId());
        System.out.println(solicitudes);

        //Modificar
        fachada.modificar(creada.id(), EstadoSolicitudBorradoEnum.ACEPTADA, "Nueva descripción");

        //Verificar estado
        System.out.println("Está activo: " + fachada.estaActivo(creada.id()));
    }
}*/
