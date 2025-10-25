package ar.edu.utn.dds.k3003.repository;

import ar.edu.utn.dds.k3003.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, String> {

    Solicitud save(Solicitud solicitud);
    Optional<Solicitud> findById(String id);
    List<Solicitud> findByHechoId(String hechoId);
    List<Solicitud> findAll();
    @Query("SELECT DISTINCT s.hechoId FROM Solicitud s")
    List<String> findDistinctByHechoId();

}
