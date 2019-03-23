package AFK.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, SkillKey> {

    @Query(value = "select * from skill join user on(username=user_id) where user_id = :user", nativeQuery = true)
    List<Skill> findUsersSkills(@Param("user") String userId);
}
