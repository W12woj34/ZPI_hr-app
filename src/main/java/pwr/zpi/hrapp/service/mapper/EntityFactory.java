package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;
import pwr.zpi.hrapp.dto.PersistableDto;

/** Klasa wykorzystywana przez MapStruct, odpowiedzialna za dostarczanie obiektu encji */
@Component
@Slf4j
public class EntityFactory {

  @PersistenceContext private EntityManager em;

  /**
   * Metoda zwracająca obiekt encji na podstawie tego, czy istnieje ona w bazie danych pod id
   * dostępnym w dto
   *
   * @param dto Obiekt dto, z którego zostaną pobrane dane
   * @param entityClass Klasa encji
   * @param <T> Typ encji
   * @return
   */
  @ObjectFactory
  public <T extends Persistable<?>> T resolveEntity(
      PersistableDto<?> dto, @TargetType Class<T> entityClass) {
    T entity = null;

    if (dto.getId() != null) {
      entity = em.find(entityClass, dto.getId());
    }

    if (entity == null) {
      try {
        entity = entityClass.getDeclaredConstructor().newInstance();
      } catch (ReflectiveOperationException e) {
        log.error(e.getMessage());
      }
    }

    return entity;
  }
}
