package ar.edu.utn.dds.k3003.controllers.controllers;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoSolicitudBorradoEnum;
import ar.edu.utn.dds.k3003.facades.dtos.SolicitudDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudesController {

    private final Fachada fachada;

    @Autowired
    public SolicitudesController(Fachada fachada) {
        this.fachada = fachada;
    }

    @GetMapping
    public List<SolicitudDTO> buscarPorHecho(@RequestParam("hecho") String hechoId) {
        return fachada.buscarSolicitudXHecho(hechoId);
    }

    @GetMapping("/hecho/{hechoId}/activo")
    public HechoActivoResponse estaActivo(@PathVariable String hechoId) {
        boolean activo = fachada.estaActivo(hechoId);
        return new HechoActivoResponse(hechoId, activo);
    }

    @PostMapping
    public SolicitudDTO agregar(@RequestBody SolicitudDTO solicitud) {
        return fachada.agregar(solicitud);
    }

    @GetMapping("/{id}")
    public SolicitudDTO buscarPorId(@PathVariable String id) {
        return fachada.buscarSolicitudXId(id);
    }

    @PatchMapping
    public SolicitudDTO modificar(@RequestBody ModificacionSolicitudRequest request) {
        return fachada.modificar(request.id(), request.estado(), request.descripcion());
    }

    //Para no modificar en el PatchMapping toda la solicitud sino solamente el estado y la descripcion
    public record ModificacionSolicitudRequest(String id, EstadoSolicitudBorradoEnum estado, String descripcion){}

    public record HechoActivoResponse(String hechoId, boolean activo){}
}
