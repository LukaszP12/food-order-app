package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strefakursow.elunchapp.DTO.EmployeeDto;
import pl.strefakursow.elunchapp.repo.EmployeeRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<EmployeeDto> getAll() {
        return deliveryAddressRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, EmployeeDto employeeDto) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<EmployeeDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
