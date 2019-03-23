package AFK.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, SkillKey> {

    @Query(value = "select * from skill natural join user where user_id = :user", nativeQuery = true)
    List<Skill> findUsersSkills(@Param("user") String userId);
}
