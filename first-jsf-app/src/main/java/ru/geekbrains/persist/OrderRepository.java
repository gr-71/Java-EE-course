package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.util.List;

@Named
@ApplicationScoped
public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @PostConstruct
    public void init() throws Exception {
        if (countAll() == 0) {
            try {
                ut.begin();
                saveOrUpdate(new Order(null, "Client  1", "Description of order 1", new BigDecimal(10_000));
                saveOrUpdate(new Order(null, "Client  2", "Description of order 2", new BigDecimal(20_000));
                saveOrUpdate(new Order(null, "Client  3", "Description of order 3", new BigDecimal(30_000));
                ut.commit();
            } catch (Exception ex) {
                logger.error("", ex);
                ut.rollback();
            }
        }
    }

    public List<Order> findAll() {
        return em.createNamedQuery("findAll", Order.class)
                .getResultList();
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public Long countAll() {
        return em.createNamedQuery("countAll", Long.class)
                .getSingleResult();
    }

    @Transactional
    public void saveOrUpdate(Order order) {
        if (order.getId() == null) {
            em.persist(order);
        }
        em.merge(order);
    }

    @Transactional
    public void deleteById(Long id) {
        em.createNamedQuery("deleteById")
                .setParameter("id", id)
                .executeUpdate();
    }


}
