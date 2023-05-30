package restaurant_serv.Controllers;


import org.springframework.web.reactive.function.client.WebClient;
import restaurant_serv.Enums.OrderStatus;
import restaurant_serv.entity.MenuItem;
import restaurant_serv.entity.Order;
import restaurant_serv.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private WebClient webClient;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{order_id}/sent")
    public @ResponseBody String sent(@PathVariable Long order_id){
        Order order = orderRepository.findById(order_id).get();
        order.setOrderStatus(OrderStatus.INPROGRESS);
        orderRepository.save(order);
        return "Order send to the kitchen";
    }

    @GetMapping("/{order_id}/receive")
    public @ResponseBody String receive(@PathVariable Long order_id){
        Order order = orderRepository.findById(order_id).get();
        order.setOrderStatus(OrderStatus.RECEIVED);
        order.setBill(
                order.getMenuItems().stream()
                        .mapToDouble(MenuItem::getPrice)
                        .sum()
        );
        orderRepository.save(order);
        return "Order received";
    }

}
