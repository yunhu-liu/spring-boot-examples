package com.luitech.springbootexamples.data;

import com.luitech.springbootexamples.domain.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
