package com.example.wokers_machines_l2.entitymessages;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
// Сущность для таблицы с информацией об изменениях
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String changeType ;

    private String entity;

    private Long idEntity;

    private String fieldName;

    private String fieldNewValue;

    private Date updateDate;

    private String emailСharacter;

    public Message() {
    }

    public Message(String changeType, String entity, Long idEntity, String fieldName, String fieldNewValue, Date updateDate, String emailСharacter) {
        this.changeType = changeType;
        this.entity = entity;
        this.idEntity = idEntity;
        this.fieldName = fieldName;
        this.fieldNewValue = fieldNewValue;
        this.updateDate = updateDate;
        this.emailСharacter = emailСharacter;
    }

    public Long getId() {
        return id;
    }

    public String getChangeType() {
        return changeType;
    }

    public String getEntity() {
        return entity;
    }

    public Long getIdEntity() {
        return idEntity;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldNewValue() {
        return fieldNewValue;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getEmailСharacter() {
        return emailСharacter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public void setIdEntity(Long idEntity) {
        this.idEntity = idEntity;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldNewValue(String fieldNewValue) {
        this.fieldNewValue = fieldNewValue;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setEmailСharacter(String emailСharacter) {
        this.emailСharacter = emailСharacter;
    }
}
