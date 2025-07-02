package service;

public class OrderService {
    private final PaymentGateway gateway;

    public OrderService(PaymentGateway g) {
        this.gateway = g;
    }

    public boolean charge(Order o) {
        return gateway.charge(o.getAmount());
    }
}
