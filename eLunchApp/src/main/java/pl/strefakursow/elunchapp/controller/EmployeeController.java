package pl.strefakursow.elunchapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.elunchapp.DTO.EmployeeDto;
import pl.strefakursow.elunchapp.DTO.LogginDataDto;
import pl.strefakursow.elunchapp.DTO.PersonalDataDto;
import pl.strefakursow.elunchapp.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/employees",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    interface EmployeeListView extends EmployeeDto.View.Basic, PersonalDataDto.View.Basic {}
    interface EmployeeView extends EmployeeDto.View.Extended, PersonalDataDto.View.Extended, LogginDataDto.View.Basic {}

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


}
