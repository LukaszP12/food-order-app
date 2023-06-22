package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.EmployeeDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    List<EmployeeDto> getAll();

    void put(UUID uuid, EmployeeDto employeeDto);

    void delete(UUID uuid);

    Optional<EmployeeDto> getByUuid(UUID uuid);
}
