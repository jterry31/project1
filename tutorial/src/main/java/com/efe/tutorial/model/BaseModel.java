package com.efe.tutorial.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;

import java.util.Date;

/**
 * Created by Efe on 18.07.2016.
 */
public class BaseModel implements Persistable<String> {

    @Id
    @Getter
    @Setter
    private String id;

    @CreatedDate
    @Getter
    @Setter
    private Date created;

    @LastModifiedDate
    @Getter
    @Setter
    private Date lastModified;

    @Version
    @Getter
    @Setter
    private long version;


    private boolean isNew = false;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
