package Repository;

import Domain.Document;

public abstract class AbstractFileRepository<T extends Document> extends InMemoryRepository<T> {
    protected String file;

    public AbstractFileRepository(String fileName) {
        this.file = fileName;
    }

    // Métodos abstractos para que las subclases definan el formato específico
    @Override
    public void add(T entity) {
        super.add(entity);
        writeToFile();
    }

    protected abstract void writeToFile();

    protected abstract void loadFromFile();
}

