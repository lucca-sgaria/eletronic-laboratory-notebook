package br.com.ucs.eln.project.model;

import br.com.ucs.eln.experiment.model.Experiment;
import br.com.ucs.eln.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "eln_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private String title;

    private String description;

    private int state = ProjectState.CREATED;

    private boolean onlyProjectUsers = false;

    @ManyToMany
    @JoinTable(
            name = "eln_project_user",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;

    @OneToMany(mappedBy = "project")
    private List<Experiment> experiments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isOnlyProjectUsers() {
        return onlyProjectUsers;
    }

    public void setOnlyProjectUsers(boolean onlyProjectUsers) {
        this.onlyProjectUsers = onlyProjectUsers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(List<Experiment> experiments) {
        this.experiments = experiments;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", created=" + created +
                ", number='" + number + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", onlyProjectUsers=" + onlyProjectUsers +
                ", users=" + users +
                ", experiments=" + experiments +
                '}';
    }
}
