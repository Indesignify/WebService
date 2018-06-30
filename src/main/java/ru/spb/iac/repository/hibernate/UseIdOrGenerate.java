package ru.spb.iac.repository.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import ru.spb.iac.model.entities.EntityWithId;

import java.io.Serializable;

public class UseIdOrGenerate extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if (obj == null) throw new HibernateException(new NullPointerException()) ;

        if ((((EntityWithId) obj).getId()) == null) {//id is null it means generate ID
            Serializable id = super.generate(session, obj) ;
            return id;
        } else {
            return ((EntityWithId) obj).getId();//id is not null so using assigned id.

        }
    }
}

//public class UseIdOrGenerate extends IdentityGenerator {
//
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        Serializable id = session.getEntityPersister(null, object).getClassMetadata().getIdentifier(object, session);
//        return id != null ? id : super.generate(session, object);
//    }
//}
