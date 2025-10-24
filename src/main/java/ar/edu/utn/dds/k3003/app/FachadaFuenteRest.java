package ar.edu.utn.dds.k3003.app;

import ar.edu.utn.dds.k3003.facades.FachadaProcesadorPdI;
import ar.edu.utn.dds.k3003.facades.dtos.ColeccionDTO;
import ar.edu.utn.dds.k3003.facades.dtos.HechoDTO;
import ar.edu.utn.dds.k3003.facades.dtos.PdIDTO;
import ar.edu.utn.dds.k3003.services.FachadaFuente;
import org.springframework.context.annotation.Primary;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Primary
public class FachadaFuenteRest implements FachadaFuente {
    private final RestTemplate restTemplate;
    private final String baseUrl = "https://two025-tp-entrega-2-larasnr.onrender.com";

    public FachadaFuenteRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public HechoDTO buscarHechoXId(String id) throws NoSuchElementException {
        try {
            return restTemplate.getForObject(baseUrl + "/hechos/" + id, HechoDTO.class);
        } catch (Exception e) {
            throw new NoSuchElementException("No se encontró el hecho con id " + id);
        }
    }

    @Override
    public void ocultarHecho(String id) {
        try {
            String url = baseUrl + "/hechos/" + id;

            Map<String, String> body = new HashMap<>();
            body.put("estado", "borrado");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<HechoDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.PATCH,
                    requestEntity,
                    HechoDTO.class
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoSuchElementException("No se puedo actualizar el estado del hecho " + id);
        }
    }
}
