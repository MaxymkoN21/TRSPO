package item_serv.Controllers;

import item_serv.Helper.OrderRequest;
import item_serv.Helper.OrderResponse;
import item_serv.entity.MenuItem;
import item_serv.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuItemController {

    @Autowired
    MenuItemRepository menuItemRepository;

    @PostMapping("/create")
    public void create(@RequestBody MenuItem menuItem){
        menuItemRepository.save(menuItem);
    }

    @GetMapping("/{id}")
    public MenuItem get(@PathVariable Long id){
        return menuItemRepository.findById(id).get();
    }

    @GetMapping("/all")
    public List<MenuItem> getAll(){
        return menuItemRepository.findAll();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody MenuItem menuItem, @PathVariable Long id){
        menuItem.setId(id);
        menuItemRepository.save(menuItem);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable Long id){
        menuItemRepository.deleteById(id);
    }

    @PostMapping("/find")
    public OrderResponse find(@RequestBody OrderRequest id){
        OrderResponse response = new OrderResponse();
        response.getItems().addAll(menuItemRepository.findAllById(id.getItems()));
        return response;
    }
}
