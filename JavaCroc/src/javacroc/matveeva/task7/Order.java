package javacroc.matveeva.task7;

import java.time.Instant;
import java.util.List;

public class Order {

    String name;
    String phoneNumber;
    Instant creationDateTime;
    private String orderNumber;
    OrderStatus orderStatus = OrderStatus.CREATED;


}
