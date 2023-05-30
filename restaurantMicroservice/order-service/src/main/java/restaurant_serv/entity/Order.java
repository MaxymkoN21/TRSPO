package restaurant_serv.entity;

import jakarta.persistence.*;
import restaurant_serv.Enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_status", columnDefinition = "ENUM('WAITING','ACCEPTED','INPROGRESS','RECEIVED','PAID')")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "customer")
    private String customerName;

    @Column(name = "bill")
    private double bill;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<MenuItem> menuItems = new ArrayList<>();
}

