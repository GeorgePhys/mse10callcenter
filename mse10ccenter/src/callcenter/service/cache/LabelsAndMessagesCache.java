package callcenter.service.cache;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class LabelsAndMessagesCache {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void init() {

    }
}
