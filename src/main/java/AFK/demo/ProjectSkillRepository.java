package AFK.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProjectSkillRepository extends CrudRepository<ProjectSkill, ProjectSkillKey> {

    @Modifying
    @Transactional
    @Query(value = "delete from project_skill where project_id = :p",nativeQuery = true)
    void deleteByProject(@Param("p") String p);
}
