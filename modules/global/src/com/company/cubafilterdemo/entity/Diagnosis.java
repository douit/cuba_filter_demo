package com.company.cubafilterdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import java.util.UUID;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|label")
@Table(name = "CUBAFILTERDEMO_DIAGNOSIS")
@Entity(name = "cubafilterdemo$Diagnosis")
public class Diagnosis extends BaseIntegerIdEntity implements HasUuid {
    private static final long serialVersionUID = 8694382443269498561L;

    @Column(name = "LABEL", nullable = false)
    protected String label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    protected Diagnosis parent;

    @Column(name = "UUID")
    private UUID uuid;

    public void setParent(Diagnosis parent) {
        this.parent = parent;
    }

    public Diagnosis getParent() {
        return parent;
    }


    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}