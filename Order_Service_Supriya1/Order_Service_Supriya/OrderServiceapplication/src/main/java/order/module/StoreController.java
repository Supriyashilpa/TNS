package order.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table_data") 
public class StoreController {

    @Autowired
    private StoreService storeService;


    @GetMapping("/{id}")
    public ResponseEntity<Store> getOrderById(@PathVariable Long id) {
        Store order = storeService.getOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }


    @GetMapping
    public ResponseEntity<List<Store>> getAllOrders() {
        List<Store> orders = storeService.getAllOrders();
        return orders.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(orders);
    }


    @PostMapping
    public ResponseEntity<Store> createOrder(@RequestBody Store order) {
        Store savedOrder = storeService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }


    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Store> updateOrderStatus(@PathVariable Long id, @PathVariable String status) {
        Store updatedOrder = storeService.updateOrderStatus(id, status);
        return updatedOrder != null ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        boolean isDeleted = storeService.deleteOrder(id);
        return isDeleted ? ResponseEntity.ok("Order deleted successfully") : ResponseEntity.notFound().build();
    }
}
