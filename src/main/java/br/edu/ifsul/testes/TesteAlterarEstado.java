
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20201pf.cc0050
 */

public class TesteAlterarEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = em.find(Estado.class, 2); // Objeto criado.
        
        // Setando os valores nas propriedades/atributos.
        e.setNome("Santa Catarina");
        e.setUf("SC");
        
        em.getTransaction().begin();
        em.merge(e);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }   
}