package ar.edu.utn.dds.k3003.controllers.controllers;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoSolicitudBorradoEnum;
import ar.edu.utn.dds.k3003.facades.dtos.SolicitudDTO;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudesController {

    private final Fachada fachada;
    private final MeterRegistry meterRegistry;

    @Autowired
    public SolicitudesController(Fachada fachada, MeterRegistry meterRegistry) {
        this.fachada = fachada;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping
    public List<SolicitudDTO> buscarPorHecho(@RequestParam("hecho") String hechoId) {
        Timer.Sample sample = Timer.start(meterRegistry);
        List<SolicitudDTO> solicitudes = fachada.buscarSolicitudXHecho(hechoId);
        sample.stop(Timer.builder("Solicitudes.consultaXHecho.tiempo")
                .description("Tiempo en que tarda en realizar la consulta por hecho")
                .register(meterRegistry));
        return solicitudes;
    }

    @GetMapping("/hecho/{hechoId}/activo")
    public HechoActivoResponse estaActivo(@PathVariable String hechoId) {
        boolean activo = !fachada.estaActivo(hechoId);
        return new HechoActivoResponse(hechoId, activo);
    }

    @GetMapping("/hechos")
    public List<String> hechosConSolicitudes() {
        return fachada.obtenerHechoIdsUnicos();
    }

    @PostMapping
    public SolicitudDTO agregar(@RequestBody SolicitudDTO solicitud) {
        meterRegistry.counter("Solicitudes.POST.usos").increment();
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

    public record HechoId(String hechoId){}
}
