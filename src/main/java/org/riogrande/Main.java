package org.riogrande;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.riogrande.util.hibernateorm.HibernateUtil;
import org.riogrande.util.hibernateorm.entidade.Study;

public class Main {
    public static void main(String[] args) {
        // Obter a SessionFactory do Hibernate
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Tentar abrir uma sessão do Hibernate
        try (Session session = sessionFactory.openSession()) {
            // Iniciar uma transação
            session.beginTransaction();

            // Exemplo: Criar um novo objeto Study e salvá-lo no banco de dados
            Study study = new Study();
            study.setNomePaciente("John Doe");
            study.setIdPaciente("12345");
            study.setDthStudy(new java.util.Date());
            study.setUuidStudy("abcd1234");
            study.setStatus("In Progress");

            // Salvar o objeto
            session.save(study);

            // Commit da transação
            session.getTransaction().commit();
        } catch (Exception e) {
            // Caso ocorra algum erro, tratamos a exceção
            e.printStackTrace();
        } finally {
            // Fechar a SessionFactory ao terminar
            HibernateUtil.shutdown();
        }
    }
}
