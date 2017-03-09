package com.company.cubafilterdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

@NamePattern("%s %s|id,name")
@Table(name = "CUBAFILTERDEMO_SIBLING")
@Entity(name = "cubafilterdemo$Sibling")
public class Sibling extends StandardEntity {
    private static final long serialVersionUID = 3775170757992900525L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIAGNOSIS_ID")
    protected Diagnosis diagnosis;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }


}