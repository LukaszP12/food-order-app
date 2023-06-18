package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Null;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class DelivererDto extends EmployeeDto {

    public static class View {
        public interface Id extends EmployeeDto.View.Id {
        }

        public interface Basic extends EmployeeDto.View.Basic {
        }

        public interface Extended extends Basic, EmployeeDto.View.Extended {
        }
    }

    public interface NewDelivererValidation { }

    @JsonView(View.Extended.class)
    @Nullable
    @Null(groups = NewDelivererValidation.class)
    private List<OrderDto> orderDtos;

    @Nullable
    public List<OrderDto> getOrders() {
        return orderDtos;
    }

    public void setOrderDtos(@Nullable List<OrderDto> orderDtos) {
        this.orderDtos = orderDtos;
    }
}
