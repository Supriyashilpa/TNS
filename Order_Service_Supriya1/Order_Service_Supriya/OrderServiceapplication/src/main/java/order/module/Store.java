package order.module;

import jakarta.persistence.*;

@Entity
@Table(name = "table_data")
public class Store {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long userId;

	    private String items; // Store as a comma-separated string

	    private Double totalAmount;

	    private String status; // PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED

	    public Store() {}

	    public Store(Long userId, String items, Double totalAmount, String status) {
	        this.userId = userId;
	        this.items = items;
	        this.totalAmount = totalAmount;
	        this.status = status;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getItems() {
	        return items;
	    }

	    public void setItems(String items) {
	        this.items = items;
	    }

	    public Double getTotalAmount() {
	        return totalAmount;
	    }

	    public void setTotalAmount(Double totalAmount) {
	        this.totalAmount = totalAmount;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	
}