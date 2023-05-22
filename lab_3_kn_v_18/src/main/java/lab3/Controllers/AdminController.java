package lab3.Controllers;


import lab3.Enums.OrderStatus;
import lab3.entity.MenuItem;
import lab3.entity.Order;
import lab3.repository.MenuItemRepository;
import lab3.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private MenuItemRepository menuItemRepository;

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
