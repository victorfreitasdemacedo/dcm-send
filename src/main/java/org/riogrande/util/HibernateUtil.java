package org.riogrande.util;

import java.io.IOException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // A variável sessionFactory será inicializada uma vez, para ser reutilizada.
    private static SessionFactory sessionFactory;
    private static IniUtil ini;

    // O bloco estático será executado quando a classe for carregada, garantindo
    // que a SessionFactory seja configurada uma única vez.
    static {
        try {
            ini = new IniUtil("config.ini");

            // Configuração do Hibernate
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.FirebirdDialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // Atualizar a base de dados
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.connection.driver_class", "org.firebirdsql.jdbc.FBDriver");
            configuration.setProperty("hibernate.connection.url", ini.getINI("database", "url"));
            configuration.setProperty("hibernate.connection.username", ini.getINI("database", "user"));
            configuration.setProperty("hibernate.connection.password", ini.getINI("database", "password"));

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
