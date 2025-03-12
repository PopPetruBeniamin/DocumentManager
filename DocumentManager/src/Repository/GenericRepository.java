package Repository;

import java.util.List;

public interface GenericRepository<T> {
    void add(T t);
    List<T> getAll();
}
