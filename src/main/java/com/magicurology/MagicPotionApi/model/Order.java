package com.magicurology.MagicPotionApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phone;
    private String quantity;
    private String total;
    private CreditCardInfo payment;
    private Date orderDate;
    private boolean fulfilled;

    public String getId() {
        return id;
    }

    public Order setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Order setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Order setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Order setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Order setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Order setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public Order setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public Order setTotal(String total) {
        this.total = total;
        return this;
    }

    public CreditCardInfo getPayment() {
        return payment;
    }

    public Order setPayment(CreditCardInfo payment) {
        this.payment = payment;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public Order setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
        return this;
    }

    public Order(Order order) {
        this.id = order.id;
        this.firstName = order.firstName;
        this.lastName = order.lastName;
        this.email = order.email;
        this.address = order.address;
        this.phone = order.phone;
        this.quantity = order.quantity;
        this.total = order.total;
        this.payment = order.payment;
        this.orderDate = order.orderDate;
        this.fulfilled = order.fulfilled;
    }
    public Order() {}

    public OrderResponse toOrderResponse() {
        return new OrderResponse()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setPhone(phone)
                .setPayment(payment)
                .setQuantity(quantity)
                .setTotal(total)
                .setOrderDate(orderDate)
                .setFulfilled(fulfilled);
    }
}
