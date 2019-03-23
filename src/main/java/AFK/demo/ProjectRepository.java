package AFK.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProjectRepository extends CrudRepository<Project, String> {

    @Query(value="select * from project where exists" +
            " (select skill_id from project_skill where project_id=id and skill_id in " +
            "(select skill_id from skill where user_id = :username))",nativeQuery=true)
    List<Project> getProjectByUser(@Param("username") String username);


    /*
    *
 with Uskills(skillID) as (select skill_id from skill where user_id = 'aka')
 select * from  project where exists ((select skill_id from project_skill where project_id=id) intersect (select * from Uskills))
    * */


}