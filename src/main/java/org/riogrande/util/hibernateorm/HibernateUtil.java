package org.riogrande.util.hibernateorm;

import java.io.IOException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.riogrande.util.IniUtil;
import org.riogrande.util.hibernateorm.entidade.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static IniUtil ini;

    static {
        try {
            ini = new IniUtil("config.ini");

            // Configuração do Hibernate
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // Atualizar a base de dados
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.connection.url", ini.getINI("database", "url"));
            configuration.setProperty("hibernate.connection.username", ini.getINI("database", "user"));
            configuration.setProperty("hibernate.connection.password", ini.getINI("database", "password"));

            // Mapeando a classe de entidade correta
            configuration.addAnnotatedClass(Study.class);
            configuration.addAnnotatedClass(FilesStudy.class);

            // Criação da SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Erro ao inicializar o Hibernate.");
        }
    }

    // Método para obter a SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Método para fechar a SessionFactory (quando a aplicação terminar)
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
