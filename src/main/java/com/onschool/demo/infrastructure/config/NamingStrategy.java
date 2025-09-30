package com.onschool.demo.infrastructure.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class NamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final String PREFIX = "mdl_";

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
        if(logicalName == null) {
            return null;
        }
        String newName = PREFIX + logicalName.getText();
        return Identifier.toIdentifier(newName, logicalName.isQuoted());
    }
}
