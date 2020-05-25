package pwr.zpi.hrapp.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.PersistableDto;
import pwr.zpi.hrapp.service.mapper.BaseMapper;

/**
 * Klasa bazowa dla serwisu wspierającego odczyt z bazy danych oraz wykorzystująca mapowanie
 * pomiędzy dto a encjami
 *
 * @param <T> Typ DTO
 * @param <E> Typ encji
 * @param <ID> Typ ID encji
 */
@Service
@Slf4j
@RequiredArgsConstructor
public abstract class BaseReadService<
        T extends PersistableDto<ID>,
        E extends Persistable<ID>,
        ID extends Serializable,
        R extends JpaRepository<E, ID>>
    implements ReadService<T, ID> {

  protected final R repository;
  protected final BaseMapper<T, E> mapper;

  @Override
  public Page<T> findAll(Pageable pageable) {
    Page<E> allEntities = repository.findAll(pageable);

    return allEntities.map(mapper::mapToDto);
  }

  @Override
  public List<T> findAll() {
    return repository.findAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
  }

  @Override
  public boolean existsById(ID id) {
    return repository.existsById(id);
  }

  @Override
  public Optional<T> findById(ID id) {
    Optional<E> entityOptional = repository.findById(id);

    return entityOptional.map(mapper::mapToDto);
  }

  @Override
  public long count() {
    return repository.count();
  }
}
