package order.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;


    public List<Store> getAllOrders() {
        return storeRepository.findAll();
    }


    public Store getOrderById(Long orderId) {
        return storeRepository.findById(orderId).orElse(null);
    }


    public Store createOrder(Store order) {
        return storeRepository.save(order);
    }


    @Transactional
    public Store updateOrderStatus(Long orderId, String status) {
        Optional<Store> optionalOrder = storeRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Store order = optionalOrder.get();
            order.setStatus(status); 
            return storeRepository.save(order); 
        }
        return null;
    }


    public boolean deleteOrder(Long orderId) {
        if (storeRepository.existsById(orderId)) {
            storeRepository.deleteById(orderId);
            return true;  
        }
        return false; 
    }
}
