package lab3.Controllers;

import lab3.Enums.OrderStatus;
import lab3.entity.MenuItem;
import lab3.entity.Order;
import lab3.repository.MenuItemRepository;
import lab3.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private OrderRepository orderRepository;


    @PostMapping("/create")
    public void create(@RequestBody Order order){
        order.setBill(0);
        order.setOrderStatus(OrderStatus.WAITING);
        orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id){
        return orderRepository.findById(id).get();
    }

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable Long id){
        orderRepository.deleteById(id);
    }

    @PostMapping("/{id}/add")
    public void addItem (@RequestBody List<Long> orders, @PathVariable Long id){

        Order order = orderRepository.findById(id).get();

        order.getMenuItems().addAll(menuItemRepository.findAllById(orders));
        order.setOrderStatus(OrderStatus.ACCEPTED);

        orderRepository.save(order);
    }

//    @GetMapping("/{id}/pay")
//    public @ResponseBody String pay(@PathVariable Long id){
//        Order order = orderRepository.findById(id).get();
//        if (order.getOrderStatus().equals(OrderStatus.RECEIVED)){
//            order.setOrderStatus(OrderStatus.PAID);
//            orderRepository.save(order);
//            return "Paid successfully";
//        }
//        return "Cant pay now";
//    }

    @PutMapping("/{id}/pay")
    public @ResponseBody String pay(@PathVariable Long id){
        Order order = orderRepository.findById(id).get();
        if (order.getOrderStatus().equals(OrderStatus.RECEIVED)){
            order.setOrderStatus(OrderStatus.PAID);
            orderRepository.save(order);
            return "Paid successfully";
        }
        return "Cant pay now";
    }
}
