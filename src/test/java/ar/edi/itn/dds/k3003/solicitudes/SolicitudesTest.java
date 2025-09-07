/*package ar.edi.itn.dds.k3003.solicitudes;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.FachadaFuente;
import ar.edu.utn.dds.k3003.facades.FachadaProcesadorPdI;
import ar.edu.utn.dds.k3003.facades.FachadaSolicitudes;
import ar.edu.utn.dds.k3003.facades.dtos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SolicitudesTest {

    private FachadaSolicitudes fachada;

    @BeforeEach
    void setUp() {
        fachada = new Fachada();
        fachada.setFachadaFuente(new FachadaFuente() {
            @Override
            public ColeccionDTO agregar(ColeccionDTO coleccionDTO) {
                return null;
            }

            @Override
            public ColeccionDTO buscarColeccionXId(String s) throws NoSuchElementException {
                return null;
            }

            @Override
            public HechoDTO agregar(HechoDTO hechoDTO) {
                return null;
            }

            @Override
            public HechoDTO buscarHechoXId(String s) throws NoSuchElementException {
                return null;
            }

            @Override
            public List<HechoDTO> buscarHechosXColeccion(String s) throws NoSuchElementException {
                return List.of();
            }

            @Override
            public void setProcesadorPdI(FachadaProcesadorPdI fachadaProcesadorPdI) {

            }

            @Override
            public PdIDTO agregar(PdIDTO pdIDTO) throws IllegalStateException {
                return null;
            }

            @Override
            public List<ColeccionDTO> colecciones() {
                return List.of();
            }
        });
    }

    @Test
    void testAgregarYBuscarXId() {
        SolicitudDTO dto = new SolicitudDTO(null, "Solicitud test",
                EstadoSolicitudBorradoEnum.CREADA, "hecho1");
        SolicitudDTO creada = fachada.agregar(dto);

        assertNotNull(creada.id());
        assertEquals("Solicitud test", creada.descripcion());

        SolicitudDTO buscada = fachada.buscarSolicitudXId(creada.id());
        assertEquals(creada.id(), buscada.id());
    }

    @Test
    void testModificar() {
        SolicitudDTO dto = fachada.agregar(new SolicitudDTO(null, "Modificar test",
                EstadoSolicitudBorradoEnum.CREADA, "hecho2"));
        SolicitudDTO modificada = fachada.modificar(dto.id(), EstadoSolicitudBorradoEnum.RECHAZADA, "Sin motivo");
        assertEquals(EstadoSolicitudBorradoEnum.RECHAZADA, modificada.estado());
    }

    @Test
    void testBuscarXHecho() {
        fachada.agregar(new SolicitudDTO(null, "Hecho A", EstadoSolicitudBorradoEnum.CREADA, "h1"));
        fachada.agregar(new SolicitudDTO(null, "Hecho B", EstadoSolicitudBorradoEnum.CREADA, "h1"));

        List<SolicitudDTO> solicitudes = fachada.buscarSolicitudXHecho("h1");
        assertEquals(2, solicitudes.size());
    }

    @Test
    void testEstaActivo() {
        SolicitudDTO dto = fachada.agregar(new SolicitudDTO(null, "Activa", EstadoSolicitudBorradoEnum.CREADA, "h2"));
        assertTrue(fachada.estaActivo(dto.id()));

        fachada.modificar(dto.id(), EstadoSolicitudBorradoEnum.RECHAZADA, "Motivo test");
        assertFalse(fachada.estaActivo(dto.id()));
    }

}*/
