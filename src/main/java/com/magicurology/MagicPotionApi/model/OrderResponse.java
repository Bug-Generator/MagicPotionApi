package com.magicurology.MagicPotionApi.model;

import java.util.Date;

public class OrderResponse {

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

    public String getFirstName() {
        return firstName;
    }

    public OrderResponse setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public OrderResponse setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public OrderResponse setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public OrderResponse setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public OrderResponse setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public OrderResponse setTotal(String total) {
        this.total = total;
        return this;
    }

    public CreditCardInfo getPayment() {
        return payment;
    }

    public OrderResponse setPayment(CreditCardInfo payment) {
        this.payment = payment;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public OrderResponse setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public OrderResponse setFulfilled(boolean fulfilledDate) {
        this.fulfilled = fulfilledDate;
        return this;
    }

    public Order toOrder() {
        return new Order()
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
