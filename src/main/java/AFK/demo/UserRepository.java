package AFK.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, String> {

    @Query(value = "select * from user where username in  (select user_username from members where project_id=:proj_id)",nativeQuery = true)
    List<User> findAllByProject(@Param("proj_id")String id);
}