package ar.edu.utn.dds.k3003.repository;

import ar.edu.utn.dds.k3003.model.Solicitud;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

public class InMemorySolicitudRepository implements SolicitudRepository {

    private final Map<String, Solicitud> solicitudes;

    public InMemorySolicitudRepository() {
        this.solicitudes = new HashMap<>();
    }

    @Override
    public Solicitud save(Solicitud solicitud) {
        solicitudes.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    @Override
    public Optional<Solicitud> findById(String id) {
        return Optional.ofNullable(solicitudes.get(id));
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Solicitud> findByHechoId(String hechoId) {
        List<Solicitud> resultado = new ArrayList<>();
        for (Solicitud solicitud : solicitudes.values()) {
            if (solicitud.getHechoId().equals(hechoId)) {
                resultado.add(solicitud);
            }
        }
        return resultado;
    }

    @Override
    public <S extends Solicitud> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public List<Solicitud> findAll() {
        return new ArrayList<>(solicitudes.values());
    }

    @Override
    public List<Solicitud> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Solicitud entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Solicitud> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Solicitud> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Solicitud> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Solicitud> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Solicitud getOne(String s) {
        return null;
    }

    @Override
    public Solicitud getById(String s) {
        return null;
    }

    @Override
    public Solicitud getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Solicitud> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Solicitud> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Solicitud> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Solicitud> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Solicitud> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Solicitud> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Solicitud, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Solicitud> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Solicitud> findAll(Pageable pageable) {
        return null;
    }
}
