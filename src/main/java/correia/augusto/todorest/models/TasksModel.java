package correia.augusto.todorest.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Tasks")
public class TasksModel {
    @GeneratedValue
    @Id
    private Integer id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDateTime creationDate = LocalDateTime.now();
    @Column
    @JsonFormat(pattern="dd-MM-yyyy'T'HH:mm")
    private Date taskDate;
    @Column
    private Integer status;
    @Column
    private Integer timeSpent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Integer timeSpent) {
        this.timeSpent = timeSpent;
    }
    public void clone(TasksModel nTask){
        this.title = nTask.getTitle();
        this.description = nTask.getDescription();
        this.status = nTask.getStatus();
        this.taskDate = nTask.getTaskDate();
        this.timeSpent = nTask.getTimeSpent();
    }

    @Override
    public String toString() {
        return "TasksModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", taskDate=" + taskDate +
                ", status='" + status + '\'' +
                ", timeSpent=" + timeSpent +
                '}';
    }
}
