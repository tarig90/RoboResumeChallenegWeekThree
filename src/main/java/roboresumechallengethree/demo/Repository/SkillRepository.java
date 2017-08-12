package roboresumechallengethree.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import roboresumechallengethree.demo.ModelFacade.Skills;

public interface SkillRepository extends CrudRepository<Skills,Long> {
}
