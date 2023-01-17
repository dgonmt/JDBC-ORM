package se.iths.persistency.util;

import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static final String PROPERTIES_FILE = "application.properties";

    private final String dbUrl;
    private final String dbUser;
    private final String dbPswrd;

    public Configuration() {
        Properties properties = new Properties();

        try {
            properties.load(Configuration.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

        dbUrl = properties.getProperty("db.url");
        dbUser = properties.getProperty("db.user");
        dbPswrd = properties.getProperty("db.password");
    }

    public String getDbUrl() {
        return this.dbUrl;
    }
    public String getDbUser() {
        return this.dbUser;
    }
    public String getDbPswrd() {
        return this.dbPswrd;
    }

}
