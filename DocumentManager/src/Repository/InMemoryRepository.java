package Repository;

import Domain.Document;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<T extends Document> implements GenericRepository<T> {
    protected final List<T> items = new ArrayList<>();

    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}
