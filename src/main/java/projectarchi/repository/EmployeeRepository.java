package projectarchi.repository;

import projectarchi.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*
 @Repository: repository in the persistence layer and makes it eligible for Spring’s exception translation mechanism.

*/
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    //NOTE: the FROM field should be the CLASS NAME that maps the entities
    @Query(value = "SELECT e FROM Employee e where e.lastName=:name")
    List<Employee> findByLastName(@Param("name") String lastName);
}

