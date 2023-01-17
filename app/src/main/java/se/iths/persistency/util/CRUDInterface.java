package se.iths.persistency.util;

import java.sql.SQLException;
import java.util.Collection;

public interface CRUDInterface<T> {

    public Collection<T> findAll() throws SQLException;
    public T findById(Long id) throws SQLException;
    public T create(T object) throws SQLException;

    public T update(T object, Long id) throws SQLException;

    public boolean delete(T object) throws SQLException;
}
