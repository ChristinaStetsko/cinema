package com.stetsko.dao.init;

import com.stetsko.dao.orm.init.DAOInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SqlDAOInitializer implements DAOInitializer {

    private static final Logger LOGGER = LogManager.getLogger(SqlDAOInitializer.class);
    private static final String DRIVER = "org.postgresql.Driver";

    private volatile boolean isInit;

    @Override
    public void init() {
        try {
            if (!isInit) {
                Class.forName(DRIVER);
                isInit = true;
                LOGGER.info("DAO initialized");
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("Unable to load JDBC Driver: {}", e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {

    }
}
