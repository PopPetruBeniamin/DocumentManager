import Config.SettingsManager;
import Domain.Manuscript;
import Domain.ManuscriptConverter;
import Domain.Presentation;
import Domain.PresentationConverter;
import Repository.InMemoryRepository;
import Repository.RepositoryFactory;
import Service.Service;
import Ui.Ui;


public class Main {
    public static void main(String[] args) {
        // Charging settings from a settings file
        SettingsManager settings = new SettingsManager("src\\Config\\settings.properties");
        SettingsManager settingsForConformed = new SettingsManager("src\\Config\\settingsForConformed.properties");

        // Creating the Repository factory
        RepositoryFactory factory = new RepositoryFactory(settings);
        RepositoryFactory factoryForConformed = new RepositoryFactory(settingsForConformed);

        // Instantiation the Repository
        InMemoryRepository<Manuscript> manuscriptRepository = factory.createRepository("Manuscripts", new ManuscriptConverter());
        InMemoryRepository<Presentation> presentationRepository = factory.createRepository("Presentations", new PresentationConverter());
        InMemoryRepository<Manuscript> manuscriptConformedRepository = factory.createRepository("Manuscripts", new ManuscriptConverter());
        InMemoryRepository<Presentation> presentationConformedRepository = factory.createRepository("Presentations", new PresentationConverter());

        // Creating service and user interface
        Service manuscriptPresentationService = new Service(manuscriptRepository, presentationRepository);
        Service manuscriptPresentationConformedService = new Service(manuscriptConformedRepository, presentationConformedRepository);

        Ui ui = new Ui(manuscriptPresentationService, manuscriptPresentationConformedService);

        // Start the user interface
        ui.start();
    }
}