package ru.spb.iac.repository.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import ru.spb.iac.model.entities.EntityWithId;

import java.io.Serializable;

public class UseIdOrGenerate extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if (obj == null) throw new HibernateException(new NullPointerException());

        if ((((EntityWithId) obj).getId()) == null) {
            Serializable id = super.generate(session, obj);
            return id;
        } else {
            return ((EntityWithId) obj).getId();

        }
    }
}