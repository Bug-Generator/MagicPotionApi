package com.magicurology.MagicPotionApi.service;

import com.magicurology.MagicPotionApi.exception.BadRequestException;
import com.magicurology.MagicPotionApi.exception.NotFoundException;
import com.magicurology.MagicPotionApi.model.Address;
import com.magicurology.MagicPotionApi.model.FulfillmentRequest;
import com.magicurology.MagicPotionApi.model.Order;
import com.magicurology.MagicPotionApi.model.OrderCreateRequest;
import com.magicurology.MagicPotionApi.model.OrderCreateResponse;
import com.magicurology.MagicPotionApi.model.OrderResponse;
import com.magicurology.MagicPotionApi.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderRepository ordersRepo;

    public OrderCreateResponse createOrder(OrderCreateRequest orderRequest) {
        // check order is not empty
        if (orderRequest == null) {
            LOGGER.error("message=" + INVALID_ORDER);
            throw new BadRequestException(INVALID_ORDER);
        }
        // check that order quantity is less than 3
        if (orderRequest.getQuantity() == null ||
            Integer.parseInt(orderRequest.getQuantity()) > 3) {
            LOGGER.error("message=" + BAD_QUANTITY);
            throw new BadRequestException(BAD_QUANTITY);
        }

        // check that quantity entered is valid
        if (Integer.parseInt(orderRequest.getQuantity()) < 1) {
            LOGGER.error("message=" + INVALID_QUANTITY);
            throw new BadRequestException(INVALID_QUANTITY);
        }

        // validate against duplicate order
        validateOrder(
                orderRequest.getFirstName(), orderRequest.getLastName(),
                orderRequest.getAddress());

        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();

        Order orderToCreate = orderRequest.toUserEntity();
        orderToCreate.setOrderDate(now);

        ordersRepo.save(orderToCreate);
        Order createdOrder = ordersRepo.findByName(
                orderRequest.getFirstName(),orderRequest.getLastName());
        return new OrderCreateResponse().setId(createdOrder.getId());
    }

    public OrderResponse getOrder(String id) {
        LOGGER.info("message=getting order for id={}", id);
        // Get order from db else throw exception with lambda
        Order order = ordersRepo.findById(id).orElseThrow(() -> new NotFoundException(RESOURCE_NOT_FOUND));
        return order.toOrderResponse();
    }

    public ResponseEntity<String> updateOrder(FulfillmentRequest fulfillmentRequest) {
        // use get method to verify that order exists
        // method will throw exception if not
        Order currentOrder = ordersRepo.findById(fulfillmentRequest.getUid())
                .orElseThrow(() -> new NotFoundException(RESOURCE_NOT_FOUND));
        Order orderToUpdate = new Order(currentOrder);
        orderToUpdate.setFulfilled(fulfillmentRequest.isFulfilled());
        LOGGER.info("message=updating order with id={}", fulfillmentRequest.getUid());
        LOGGER.info(RESOURCE_UPDATED);
        ordersRepo.save(orderToUpdate);
        return ResponseEntity.ok(RESOURCE_UPDATED);
    }

    public ResponseEntity<String> deleteOrder(String id) {
        // use get method to verify that order exists
        // method will throw exception if not
        getOrder(id);
        LOGGER.info("message=deleting order with id={}", id);
        ordersRepo.deleteById(id);
        return ResponseEntity.ok(RESOURCE_DELETED);
    }



    private void validateOrder(String firstName, String lastName, Address address) {
        // check that order exists, if so throw bad request exception
        // prevents a user from creating another order with same name
        Order orderExists = ordersRepo.findByNameAndAddress(firstName,lastName,address);
        if (orderExists != null) {
            LOGGER.error("message=" + USER_EXISTS);
            throw new BadRequestException(USER_EXISTS);
        }
    }




    private final String USER_EXISTS = "An oder with the same name at this address already exists";
    private final String BAD_QUANTITY = "Quantity cannot exceed 3 for a given month";
    private final String INVALID_QUANTITY = "Invalid quantity provided";
    private final String INVALID_ORDER = "Invalid order provided";
    private final String RESOURCE_DELETED = "resource deleted successfully";
    private final String RESOURCE_UPDATED = "resource updated successfully";
    private final String RESOURCE_NOT_FOUND = "resource not found";


}
