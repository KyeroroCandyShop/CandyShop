package product.entity.order;


import product.entity.product.Product;
import product.entity.user.User;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;


    @Column(nullable = false)
    private Long orderNum;

    @DateTimeFormat
    private LocalDateTime orderTime;
    @PrePersist
    public void createDate() {
        this.orderTime = LocalDateTime.now();
    }

    @Column
    private String orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


    public String changeStatus(Order order){
        if (LocalDateTime.now().isBefore(order.getOrderTime().plusDays(7))) {
            this.orderStatus = "배송완료";
        }
        return orderStatus;
    }

    public void cancel(){
        this.orderStatus = "주문취소";
    }

    public Order(Long orderNum, String orderStatus, Product product, User user) {
        this.orderNum = orderNum;
        this.orderStatus = orderStatus;
        this.product = product;
        this.user = user;
    }

    public Order(Long orderNum, String orderStatus, Product product, User user, Long orderId) {
        this.orderId = orderId;
        this.orderNum = orderNum;
        this.orderStatus = orderStatus;
        this.product = product;
        this.user = user;
    }
}
