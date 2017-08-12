package roboresumechallengethree.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import roboresumechallengethree.demo.ModelFacade.EducationalAchievements;
import roboresumechallengethree.demo.ModelFacade.Experience;

public interface ExperienceRepository extends CrudRepository<Experience,Long> {
}
