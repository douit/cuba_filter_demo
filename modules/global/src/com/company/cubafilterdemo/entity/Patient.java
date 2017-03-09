package com.company.cubafilterdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.OneToOne;

@NamePattern("%s %s|id,name")
@Table(name = "CUBAFILTERDEMO_PATIENT")
@Entity(name = "cubafilterdemo$Patient")
public class Patient extends StandardEntity {
    private static final long serialVersionUID = 7177704078114112213L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DIAGNOSIS_ID")
    protected Diagnosis diagnosis;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SIBLING_ID")
    protected Sibling sibling;

    public void setSibling(Sibling sibling) {
        this.sibling = sibling;
    }

    public Sibling getSibling() {
        return sibling;
    }


    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}