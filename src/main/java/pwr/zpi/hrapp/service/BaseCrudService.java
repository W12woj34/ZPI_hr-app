package pwr.zpi.hrapp.service;

import java.io.Serializable;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.PersistableDto;
import pwr.zpi.hrapp.service.mapper.BaseMapper;

/**
 * Klasa bazowa dla serwisu wspierającego funkcjonalność CRUD z bazą danych oraz wykorzystująca
 * mapowanie pomiędzy dto a encjami
 *
 * @param <T> Typ DTO
 * @param <E> Typ encji
 * @param <ID> Typ ID encji
 */
@Service
@Slf4j
public abstract class BaseCrudService<
        T extends PersistableDto<ID>,
        E extends Persistable<ID>,
        ID extends Serializable,
        R extends JpaRepository<E, ID>>
    extends BaseReadService<T, E, ID, R> implements CrudService<T, ID> {

  public BaseCrudService(R repository, BaseMapper<T, E> mapper) {
    super(repository, mapper);
  }

  @Override
  public T save(T dto) {
    E savedEntity = repository.save(mapper.mapToEntity(dto));

    return mapper.mapToDto(savedEntity);
  }

  @Override
  public void deleteById(ID id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<T> updateById(T dto, ID id) {
    Optional<E> entityOptional = repository.findById(id);

    return entityOptional.map(
        entity -> {
          dto.setId(id);
          repository.save(mapper.mapToEntity(dto));
          return mapper.mapToDto(entity);
        });
  }

  @Override
  public void deleteAll() {
    repository.deleteAll();
  }
}
