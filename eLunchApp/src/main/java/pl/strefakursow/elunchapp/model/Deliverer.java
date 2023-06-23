package pl.strefakursow.elunchapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
@Entity
@DiscriminatorValue("deliverer")
public class Deliverer extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @Nullable
    @OneToMany(mappedBy = "deliverer")
    private List<Order> orders;

    @Nullable
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(@Nullable List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
