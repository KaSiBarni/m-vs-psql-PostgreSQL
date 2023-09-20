package telekom.de.postgres.postgres.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import telekom.de.postgres.postgres.domain.Employee;
import telekom.de.postgres.postgres.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(@RequestBody Employee employee){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(employee);
            employee.setBackendOrderIdData(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getAllByIds(){
        return  employeeRepository.findByAllIds();
    }

}
