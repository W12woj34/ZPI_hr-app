package pwr.zpi.hrapp.service;

import java.io.Serializable;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.PersistableDto;
import pwr.zpi.hrapp.service.mapper.BaseMapper;

/**
 * Klasa bazowa dla serwisu wspierającego funkcjonalność CRUD z bazą danych, wyszukiwanie encji przy
 * użyciu springowych specyfikacji, oraz wykorzystująca mapowanie pomiędzy dto a encjami
 *
 * @param <T> Typ DTO
 * @param <E> Typ encji
 * @param <ID> Typ ID encji
 */
@Service
@Slf4j
public abstract class BaseSpecificationCrudService<
        T extends PersistableDto<ID>,
        E extends Persistable<ID>,
        ID extends Serializable,
        R extends JpaRepository<E, ID> & JpaSpecificationExecutor<E>>
    extends BaseCrudService<T, E, ID, R> implements SpecificationCrudService<T, E, ID> {

  public BaseSpecificationCrudService(R repository, BaseMapper<T, E> mapper) {
    super(repository, mapper);
  }

  @Override
  public List<T> findAll(Specification<E> specification) {
    return mapper.mapToDtoList(repository.findAll(specification));
  }

  @Override
  public Page<T> findAll(Specification<E> specification, Pageable pageable) {
    return repository.findAll(specification, pageable).map(mapper::mapToDto);
  }

  @Override
  public List<T> findAll(Specification<E> specification, Sort sort) {
    return mapper.mapToDtoList(repository.findAll(specification, sort));
  }
}
