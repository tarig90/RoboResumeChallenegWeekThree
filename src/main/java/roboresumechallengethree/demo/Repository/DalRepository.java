package roboresumechallengethree.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import roboresumechallengethree.demo.ModelFacade.Resume;

public interface DalRepository extends CrudRepository<Resume,Long> {


}


