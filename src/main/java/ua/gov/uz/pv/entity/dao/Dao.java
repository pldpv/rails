
package ua.gov.uz.pv.entity.dao;

import org.hibernate.Session;
import ua.gov.uz.pv.util.HibernateUtil;

/**
 *
 * @author ���
 */
public class Dao {
   Session session=null;
   public Dao(){
       this.session=HibernateUtil.getSessionFactory().getCurrentSession();
   }
}
