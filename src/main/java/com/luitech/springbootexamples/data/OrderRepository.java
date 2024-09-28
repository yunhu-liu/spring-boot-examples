package com.luitech.springbootexamples.data;

import com.luitech.springbootexamples.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
    TacoOrder save(TacoOrder order);

    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
