package roboresumechallengethree.demo.ControlFacade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import roboresumechallengethree.demo.ModelFacade.EducationalAchievements;
import roboresumechallengethree.demo.ModelFacade.Experience;
import roboresumechallengethree.demo.ModelFacade.Resume;
import roboresumechallengethree.demo.ModelFacade.Skills;
import roboresumechallengethree.demo.Repository.DalRepository;
import roboresumechallengethree.demo.Repository.EducationRepository;
import roboresumechallengethree.demo.Repository.ExperienceRepository;
import roboresumechallengethree.demo.Repository.SkillRepository;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    DalRepository resumeRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;


    @GetMapping("/welcomepage")
    public String welcomePage()
    {

        return "welcomepage";
    }

    @GetMapping("/entereducation")
    public String EnterEducation(Model model)
    {
       model.addAttribute("neweduc", new EducationalAchievements());

       return "entereducation";
    }

    @PostMapping("/entereducation")
    public String postEnterEDucation(@Valid @ModelAttribute("neweduc") EducationalAchievements eduction)
    {
        educationRepository.save(eduction);

        return "confirmeducation";
    }

    @GetMapping("/enterexperience")
    public String enterExperience(Model model)
    {
        model.addAttribute("newexp", new Experience());

        return "enterexperience";
    }


    @PostMapping("/enterexperience")
    public String postEnterEXperience(@Valid @ModelAttribute("newexp") Experience experience)
    {
       experienceRepository.save(experience);
       return  "experienceconfirmed";
    }

    @GetMapping("/entersetofskills")
    public String enterSkills(Model model)
    {
       model.addAttribute("newskill" , new Skills());
       return  "entersetofskills";
    }


    @PostMapping("/entersetofskills")
    public String postSkills(@Valid @ModelAttribute("newskill") Skills skills)
    {
        skillRepository.save(skills);
        return "skillsconfirmed";
    }

    @GetMapping("/enterresume")
    public String getResume(Model model)
    {

        model.addAttribute("newres", new Resume());
        return "enterresume";
    }

    @PostMapping("/enterresume")
    public String postResume(@Valid @ModelAttribute("newres") Resume resume)
    {
        resumeRepository.save(resume);
        return "confirmresume";
    }

    @GetMapping("/displayresume")
    public String displayResume(Model model)
    {



        Resume resumeOBject= resumeRepository.findOne(new Long(1));

        ArrayList<EducationalAchievements> educationlist=((ArrayList<EducationalAchievements>) educationRepository.findAll());
        resumeOBject.setEducation(educationlist);

        ArrayList<Experience> worklist=((ArrayList<Experience>)experienceRepository.findAll());
        resumeOBject.setExperience(worklist);

        ArrayList<Skills> skilllist=((ArrayList<Skills>)skillRepository.findAll());
        resumeOBject.setSkillSet(skilllist);

        model.addAttribute("resumeObjects", resumeOBject );

//
        return "displayresume";//


    }

    @GetMapping("/displayexperience")
    public String displayExperience(Model model)
        {
            Iterable<Experience> exprList = experienceRepository.findAll();
            model.addAttribute("experienceLista",exprList);

            return "displayexperience";
        }

        @GetMapping("/displayskills")
        public String displayskills(Model model)
        {
            Iterable<Skills> skllista = skillRepository.findAll();
            model.addAttribute("skillistas", skllista);
            return "displayskills";
        }

        @GetMapping("/displayeducation")
        public String displayEDucation(Model model)
        {
            Iterable<EducationalAchievements> educalista = educationRepository.findAll();
            model.addAttribute("educalistas",educalista );
            return "displayeducation";
        }



}
