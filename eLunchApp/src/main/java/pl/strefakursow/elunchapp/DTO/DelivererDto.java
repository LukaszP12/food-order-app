package pl.strefakursow.elunchapp.DTO;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class DelivererDto extends EmployeeDto {

    private UUID uuid;

    @Nullable
    private List<OrderDto> orderDtos;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Nullable
    public List<OrderDto> getOrderDtos() {
        return orderDtos;
    }

    public void setOrderDtos(@Nullable List<OrderDto> orderDtos) {
        this.orderDtos = orderDtos;
    }

}
