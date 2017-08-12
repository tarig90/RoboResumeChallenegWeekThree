package roboresumechallengethree.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import roboresumechallengethree.demo.ModelFacade.EducationalAchievements;
import roboresumechallengethree.demo.ModelFacade.Resume;

public interface EducationRepository extends CrudRepository<EducationalAchievements,Long> {
}
