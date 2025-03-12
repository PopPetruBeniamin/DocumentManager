package Repository;

import Config.SettingsManager;
import Domain.Document;
import Domain.DocumentConverter;

public class RepositoryFactory {
    private final SettingsManager settings;

    public RepositoryFactory(SettingsManager settings) {
        this.settings = settings;
    }

    public <T extends Document> InMemoryRepository<T> createRepository(String key, DocumentConverter<T> converter) {
        String repositoryType = settings.getProperty("Repository");
        String fileName = settings.getProperty(key); // e.g., "Products" or "Orders"

        if ("text".equalsIgnoreCase(repositoryType)) {
            return new TextFileRepository<>(fileName, converter); // Text repository (optional)
        } else {
            throw new UnsupportedOperationException("Repository type not supported: " + repositoryType);
        }
    }
}
