package ru.spb.iac.model.entities;

import java.io.Serializable;

public interface EntityWithId<T extends Serializable> {
    T getId();
}
