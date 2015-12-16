package br.com.rbarbioni.store.repository;

import br.com.rbarbioni.store.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 10/12/15.
 */
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
