package ar.edu.utn.dds.k3003.model;

import ar.edu.utn.dds.k3003.facades.dtos.EstadoSolicitudBorradoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Solicitud {

    @Id
    private String id;
    private String descripcion;
    private EstadoSolicitudBorradoEnum estado;
    private String hechoId;

    public Solicitud(String id, String descripcion, EstadoSolicitudBorradoEnum estado, String hechoId) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.hechoId = hechoId;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoSolicitudBorradoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitudBorradoEnum estado) {
        this.estado = estado;
    }

    public String getHechoId() {
        return hechoId;
    }

    /*public void setHechoId(String hechoId) {
        this.hechoId = hechoId;
    }*/
}
