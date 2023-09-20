package telekom.de.postgres.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import telekom.de.postgres.postgres.domain.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value= "select * from json_test where boi_data @@ '$.productOrderId == \"backend666666.2\"" +
            " || $.publicIdentifier == \"backend666666.2\"" +
            " || $.externalId == \"backend666666.2\"" +
            " || $.backendOrderIdData[*].backendOrderIds[*].backendOrderId == \"backend666666.2\"'", nativeQuery = true)
    List<Employee> findByAllIds();
}
