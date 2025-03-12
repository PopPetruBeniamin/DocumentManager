package Service;

import Domain.Document;
import Domain.Manuscript;
import Domain.Presentation;
import Repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Service {
    private final InMemoryRepository<Manuscript> manuscriptRepository;
    private final InMemoryRepository<Presentation> presentationRepository;

    public Service(InMemoryRepository<Manuscript> manuscriptRepository, InMemoryRepository<Presentation> presentationRepository) {
        this.manuscriptRepository = manuscriptRepository;
        this.presentationRepository = presentationRepository;
    }

    //=======================Manuscript functions===========================

    public void addManuscript(Manuscript manuscript){
        manuscriptRepository.add(manuscript);
    }
    public List<Manuscript> getAllManuscripts(){
        return manuscriptRepository.getAll();
    }
    public List<Manuscript> getAllManuscriptsNotConformed(){
        List<Manuscript> l = new ArrayList<>();
        for(Manuscript manuscript : manuscriptRepository.getAll()){
            if(!manuscript.isConformant()){
                l.add(manuscript);
            }
        }
        l.sort(Comparator.comparing(Manuscript::getAuthor));

        return l;
    }
    public List<Manuscript> getAllManuscriptsConformed(){
        List<Manuscript> l = new ArrayList<>();
        for(Manuscript manuscript : manuscriptRepository.getAll()){
            if(manuscript.isConformant()){
                l.add(manuscript);
            }
        }
        l.sort(Comparator.comparing(Manuscript::getAuthor));

        return l;
    }

    //=======================Presentation functions===========================
    public void addPresentation(Presentation presentation){
        presentationRepository.add(presentation);
    }
    public List<Presentation> getAllPresentations(){
        return presentationRepository.getAll();
    }
    public List<Presentation> getAllPresentationsNotConformed(){
        List<Presentation> l = new ArrayList<>();
        for(Presentation presentation : presentationRepository.getAll()){
            if(presentation.isConformant()){
                l.add(presentation);
            }
        }
        l.sort(Comparator.comparingInt(Presentation::getNumberOfSlides));

        return l;
    }
    public List<Presentation> getAllPresentationsConformed(){
        List<Presentation> l = new ArrayList<>();
        for(Presentation presentation : presentationRepository.getAll()){
            if(!presentation.isConformant()){
                l.add(presentation);
            }
        }
        l.sort(Comparator.comparingInt(Presentation::getNumberOfSlides));

        return l;
    }

}
