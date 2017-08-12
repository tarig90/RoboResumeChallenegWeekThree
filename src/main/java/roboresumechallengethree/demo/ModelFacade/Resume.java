package roboresumechallengethree.demo.ModelFacade;

import org.hibernate.hql.internal.ast.tree.Statement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Entity
public class Resume {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String emailAddress;
    private ArrayList<Skills> skillSet;
    private ArrayList<Experience> experience;
    private ArrayList<EducationalAchievements> education;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public ArrayList<Skills> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(ArrayList<Skills> skillSet) {
        this.skillSet = skillSet;
    }

    public ArrayList<Experience> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<Experience> experience) {
        this.experience = experience;
    }

    public ArrayList<EducationalAchievements> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<EducationalAchievements> education) {
        this.education = education;
    }





}
