package com.magicurology.MagicPotionApi.repository;

import com.magicurology.MagicPotionApi.model.Address;
import com.magicurology.MagicPotionApi.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{'firstName': ?0 , 'lastName' : ?1, 'address' : ?2}")
    Order findByNameAndAddress(String firstName, String lastName, Address address);

    @Query("{'firstName': ?0 , 'lastName' : ?1}")
    Order findByName(String firstName, String lastName);

}
