package com.company.cubafilterdemo;

import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.global.filter.Op;
import com.haulmont.cuba.gui.components.filter.ConditionParamBuilderImpl;
import com.haulmont.cuba.gui.components.filter.Param;
import com.haulmont.cuba.gui.components.filter.condition.AbstractCondition;
import com.haulmont.cuba.gui.components.filter.condition.PropertyCondition;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Primary
@Component(ExtConditionParamBuilderImpl.NAME)
public class ExtConditionParamBuilderImpl extends ConditionParamBuilderImpl {
    public static final String NAME = "demo_ConditionParamBuilder";

    @Override
    @PostConstruct
    public void initCreatingStrategies() {
        super.initCreatingStrategies();
        strategies.put(PropertyCondition.class, new PropertyParameterInstantiationStrategy());
    }

    protected class PropertyParameterInstantiationStrategy extends DefaultParameterInstantiationStrategy {
        @Override
        public Param.Builder getParamBuilder(AbstractCondition condition) {
            Param.Builder builder = super.getParamBuilder(condition);
            MetaProperty metaProperty = condition.getDatasource().getMetaClass().getPropertyPath(condition.getName()).getMetaProperty();
            if (!condition.getUnary())
                builder.setJavaClass(condition.getJavaClass())
                        .setProperty(metaProperty);

            if (condition.getOperator() == Op.DATE_INTERVAL) {
                builder.setIsDateInterval(true);
                builder.setJavaClass(String.class);
            }

            return builder;
        }
    }
}
