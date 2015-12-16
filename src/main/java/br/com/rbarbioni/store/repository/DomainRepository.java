package br.com.rbarbioni.store.repository;

import br.com.rbarbioni.application.core.models.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by renan on 14/12/15.
 */
@NoRepositoryBean
public interface DomainRepository<T extends DomainEntity> extends JpaRepository<T, Long> {

    @Query("SELECT o FROM #{#entityName} o WHERE o.uuid=?1")
    public DomainEntity findByuUID (String uuid);
}
