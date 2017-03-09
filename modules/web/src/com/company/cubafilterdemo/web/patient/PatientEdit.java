package com.company.cubafilterdemo.web.patient;

import com.company.cubafilterdemo.entity.Patient;
import com.company.cubafilterdemo.entity.Sibling;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;

public class PatientEdit extends AbstractEditor<Patient> {
    @Inject
    Metadata metadata;

    @Inject
    protected Datasource<Sibling> siblingDs;

    @Override
    protected void postInit() {
        if (siblingDs.getItem() == null) siblingDs.setItem(metadata.create(Sibling.class));
    }
}