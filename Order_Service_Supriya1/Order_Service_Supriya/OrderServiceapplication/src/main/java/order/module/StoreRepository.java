package order.module;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long> {

	List<Store> findByUserId(Long userId);
}
