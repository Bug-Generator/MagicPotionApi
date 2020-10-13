package com.magicurology.MagicPotionApi.model;

public class OrderCreateRequest {

    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phone;
    private String quantity;
    private String total;
    private CreditCardInfo payment;

    public String getFirstName() {
        return firstName;
    }

    public OrderCreateRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public OrderCreateRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderCreateRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public OrderCreateRequest setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public OrderCreateRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public OrderCreateRequest setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public OrderCreateRequest setTotal(String total) {
        this.total = total;
        return this;
    }

    public CreditCardInfo getPayment() {
        return payment;
    }

    public OrderCreateRequest setPayment(CreditCardInfo payment) {
        this.payment = payment;
        return this;
    }

    public Order toUserEntity() {
        return new Order()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setPhone(phone)
                .setQuantity(quantity)
                .setTotal(total)
                .setPayment(payment);
    }
}
