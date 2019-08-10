package service;

import entity.Phone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneService {
    private static Logger LOGGER = Logger.getLogger(PhoneService.class.getSimpleName());
    public boolean save(Phone phone){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(phone);
            transaction.commit();
            LOGGER.log(Level.INFO, "Save Phone success!");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, "Save phone fail", e);
        }
        return false;
    }

    public List<Phone> findAll(){
        List<Phone> phones = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            phones = session.createQuery("from Phone", Phone.class).list();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("Can not findAll phone"), e);
        }
        return phones;
    }
}
