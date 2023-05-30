package restaurant_serv.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import restaurant_serv.Enums.OrderStatus;
import restaurant_serv.Helper.OrderRequest;
import restaurant_serv.Helper.OrderResponse;
import restaurant_serv.entity.Order;
import restaurant_serv.repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private WebClient webClient;

    @Autowired
    private OrderRepository orderRepository;


    @PostMapping("/create")
    public void create(@RequestBody Order order) {
        order.setBill(0);
        order.setOrderStatus(OrderStatus.WAITING);
        orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return orderRepository.findById(id).get();
    }

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @PostMapping("/{id}/add")
    public void addItem(@RequestBody List<Long> orders, @PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.getItems().addAll(orders);

        OrderResponse orderResponse = webClient.post()
                .uri("http://localhost:8082/api/menu/find")
                .body(Mono.just(orderRequest), OrderRequest.class)
                .retrieve()
                .bodyToMono(OrderResponse.class)
                .block();


        order.getMenuItems().addAll(orderResponse.getItems());
        order.setOrderStatus(OrderStatus.ACCEPTED);
        orderRepository.save(order);
    }

    @PutMapping("/{id}/pay")
    public @ResponseBody
    String pay(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        if (order.getOrderStatus().equals(OrderStatus.RECEIVED)) {
            order.setOrderStatus(OrderStatus.PAID);
            orderRepository.save(order);
            return "Paid successfully";
        }
        return "Cant pay now";
    }
}
