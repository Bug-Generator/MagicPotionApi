package com.magicurology.MagicPotionApi

import com.magicurology.MagicPotionApi.controller.OrdersController
import com.magicurology.MagicPotionApi.model.FulfillmentRequest
import com.magicurology.MagicPotionApi.model.Order
import com.magicurology.MagicPotionApi.model.OrderCreateRequest
import com.magicurology.MagicPotionApi.service.OrderService
import com.mongodb.client.AggregateIterable
import org.junit.experimental.categories.Category
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Subject

@Category(OrdersController.class)
class OrdersControllerSpec extends Specification {

    OrderService mockOrderService

    @Subject
    OrdersController controller

    MockMvc mockMvc

    Order order1
    Order order2
    Order order3
    OrderCreateRequest createRequest

    void setup() {
        mockOrderService = Mock(OrderService)
        controller = new OrdersController(this.mockOrderService)

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()

        createRequest = new OrderCreateRequest([
                firstName: 'James',
                lastName: 'Bond',
                email: 'sample@email.com',
                address: null,
                payment: null,
                total: '49.99',
                quantity: '1'
        ])

        order1 = new Order([
                firstName: 'James',
                lastName: 'Bond',
                email: 'sample@email.com',
                address: null,
                payment: null,
                total: '49.99',
                quantity: '1'
        ])
        order2 = new Order([
                firstName: 'Sam',
                lastName: 'Smith',
                email: 'sample@email.com',
                address: null,
                payment: null,
                total: '49.99',
                quantity: '1'
        ])
        order3 = new Order([
                firstName: 'Perry',
                lastName: 'DaPlatypus',
                email: 'sample@email.com',
                address: null,
                payment: null,
                total: '49.99',
                quantity: '1'
        ])
    }

    void 'create order - happy path'() {
        given:
        def req = new OrderCreateRequest([
                firstName: 'James',
                lastName: 'Bond',
                email: 'sample@email.com',
                address: null,
                payment: null,
                total: '49.99',
                quantity: '1',
                phone: "123456987"
        ])

        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.post('/api/magic',
                req)).andReturn().response

        then:
        0 * this.mockOrderService.createOrder(createRequest)

        and:
        0 * _

    }

    void 'get order - happy path'() {
        given:
        String uid = '123'

        when:
        controller.getOrder(uid)

        then:
        1 * this.mockOrderService.getOrder(uid)

        and:
        0 * _

    }

    void 'get all orders - happy path'() {
        when:
        controller.getAllOrders()

        then:
        1 * this.mockOrderService.getAllOrders()

        and:
        0 * _

    }

    void 'update fulfillment - happy path'() {
        given:
        FulfillmentRequest request = new FulfillmentRequest()
                .setFulfilled(true)
                .setUid('12345')

        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.patch('/api/magic',
                request)).andReturn().response

        then:
        0 * _

    }

    void 'delete order - happy path'() {
        given:
        String uid = '1234'

        when:
        controller.deleteOrder(uid)

        then:
        1 * mockOrderService.deleteOrder(uid)

        and:
        0 * _

    }

}
