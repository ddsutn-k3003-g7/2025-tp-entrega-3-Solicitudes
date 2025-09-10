package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaFuente;
import ar.edu.utn.dds.k3003.facades.FachadaSolicitudes;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoSolicitudBorradoEnum;
import ar.edu.utn.dds.k3003.facades.dtos.SolicitudDTO;
import ar.edu.utn.dds.k3003.model.Solicitud;
import ar.edu.utn.dds.k3003.repository.InMemorySolicitudRepository;
import ar.edu.utn.dds.k3003.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Fachada implements FachadaSolicitudes {

    private final SolicitudRepository solicitudRepository;
    private FachadaFuente fachadaFuente;

    @Autowired
    public Fachada(SolicitudRepository solicitudRepository, FachadaFuente fachadaFuente) {
        this.solicitudRepository = solicitudRepository;
        this.fachadaFuente = fachadaFuente;
    }

    // Constructor que usa el Evaluador
    public Fachada() {
        this.solicitudRepository = new InMemorySolicitudRepository();
    }

    @Override
    public SolicitudDTO agregar(SolicitudDTO solicitudDTO) {
        if (this.fachadaFuente == null) {
            throw new IllegalStateException("FachadaFuente no fue seteada.");
        }

        this.fachadaFuente.buscarHechoXId(solicitudDTO.hechoId());

        String nuevoId = UUID.randomUUID().toString();

        Solicitud solicitud = new Solicitud(
                nuevoId,
                solicitudDTO.descripcion(),
                solicitudDTO.estado(),
                solicitudDTO.hechoId()
        );

        solicitudRepository.save(solicitud);

        return new SolicitudDTO(
                solicitud.getId(),
                solicitud.getDescripcion(),
                solicitud.getEstado(),
                solicitud.getHechoId()
        );
    }

    @Override
    public SolicitudDTO modificar(String id, EstadoSolicitudBorradoEnum nuevoEstado, String nuevaDescripcion) throws NoSuchElementException {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Solicitud con id " + id + " no encontrada."));

        solicitud.setEstado(nuevoEstado);
        solicitud.setDescripcion(nuevaDescripcion);

        solicitudRepository.save(solicitud);

        return new SolicitudDTO(
                solicitud.getId(),
                solicitud.getDescripcion(),
                solicitud.getEstado(),
                solicitud.getHechoId()
        );
    }

    @Override
    public List<SolicitudDTO> buscarSolicitudXHecho(String hechoId) {
        List<Solicitud> solicitudes = solicitudRepository.findByHechoId(hechoId);

        //Transformar lista de entidades a lista de DTOs
        return solicitudes.stream()
                .map(s -> new SolicitudDTO(s.getId(), s.getDescripcion(), s.getEstado(), s.getHechoId()))
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudDTO buscarSolicitudXId(String id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Solicitud con id " + id + " no encontrada."));

        return new SolicitudDTO(
                solicitud.getId(),
                solicitud.getDescripcion(),
                solicitud.getEstado(),
                solicitud.getHechoId()
        );
    }

    @Override
    public boolean estaActivo(String id) {
        return solicitudRepository.findById(id)
                .map(s -> s.getEstado() == EstadoSolicitudBorradoEnum.ACEPTADA)
                .orElse(false);
    }

    @Override
    public void setFachadaFuente(FachadaFuente fachadaFuente) {
        this.fachadaFuente = fachadaFuente;
    }
}
