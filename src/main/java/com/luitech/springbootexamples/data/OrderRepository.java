package com.luitech.springbootexamples.data;

import com.luitech.springbootexamples.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, String> {
}
