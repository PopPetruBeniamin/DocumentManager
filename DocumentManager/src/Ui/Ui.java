package Ui;

import Domain.Manuscript;
import Domain.Presentation;
import Service.Service;

import java.util.Scanner;

public class Ui {
    private final Service manuscriptPresentationService;
    private final Service manuscriptPresentationConformedService;
    private final Scanner scanner;

    public Ui(Service manuscriptPresentationService, Service manuscriptPresentationConformedService) {
        this.manuscriptPresentationService = manuscriptPresentationService;
        this.manuscriptPresentationConformedService = manuscriptPresentationConformedService;
        this.scanner = new Scanner(System.in);
    }

    private Presentation readingPresentation() {
        System.out.print("The name of the author:");
        String name = scanner.nextLine();
        System.out.print("Number of slides:");
        int nrSlides = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Text:");
        String text = scanner.nextLine();

        return new Presentation(name, nrSlides, text);
    }

    private Manuscript readingManuscript() {
        System.out.print("The name of the author:");
        String name = scanner.nextLine();
        System.out.print("Number of words:");
        int nrWords = scanner.nextInt();
        System.out.print("Number of pages:");
        int pages = scanner.nextInt();

        return new Manuscript(name, nrWords, pages);
    }

    public void printMenu(){
        System.out.println("=====Manuscript functions=====");
        System.out.println("1. Add Manuscript");
        System.out.println("2. Print All Manuscripts");
        System.out.println("3. Get All Manuscripts which are not Conformed (ordered by author)");
        System.out.println("4. Save All Manuscripts which are Conformed (ordered by author)");
        System.out.println("=====Presentation functions=====");
        System.out.println("5. Add Presentation");
        System.out.println("6. Print All Presentations");
        System.out.println("7. Get All Presentations which are not Conform (ordered by author)");
        System.out.println("8. Save All Presentations which are Conform (ordered by author)");
        System.out.println("0. Exit");
        System.out.print("Type your option:");
    }

    public void start(){
        while(true){
            printMenu();
            int option = scanner.nextInt();

            switch(option){
                case 1 -> addManuscript();
                case 2 -> printAllManuscripts();
                case 3 -> printAllManuscriptsNotConformed();
                case 4 -> saveAllManuscriptsConformed();
                case 5 -> addPresentation();
                case 6 -> printAllPresentations();
                case 7 -> printAllMPresentationsNotConformed();
                case 8 -> saveAllPresentationsConformed();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("!! Invalid option !!\n");
            }
        }
    }

    //Product functions
    void addPresentation(){
        Presentation presentation = readingPresentation();
        manuscriptPresentationService.addPresentation(presentation);
    }
    void printAllPresentations(){
        for(Presentation p : manuscriptPresentationService.getAllPresentations()){
            System.out.println(p.toString());
        }
    }
    void printAllMPresentationsNotConformed(){
        System.out.println("All presentations not conformed ordered by author");
        for(Presentation p : manuscriptPresentationService.getAllPresentationsNotConformed()){
            System.out.println(p.toString());
        }
    }
    void saveAllPresentationsConformed(){
        for(Presentation p : manuscriptPresentationService.getAllPresentationsConformed()){
            manuscriptPresentationConformedService.addPresentation(p);
        }
        for(Presentation p : manuscriptPresentationConformedService.getAllPresentations()){
            System.out.println(p.toString());
        }
        System.out.println("The saving was made successfully!");
    }
    void addManuscript(){
        Manuscript manuscript = readingManuscript();
        manuscriptPresentationService.addManuscript(manuscript);
    }
    void printAllManuscripts(){
        for(Manuscript manuscript : manuscriptPresentationService.getAllManuscripts()){
            System.out.println(manuscript.toString());
        }
    }
    void printAllManuscriptsNotConformed(){
        System.out.println("All manuscripts not conformed ordered by author");
        for(Manuscript m : manuscriptPresentationService.getAllManuscriptsNotConformed()){
            System.out.println(m.toString());
        }
    }
    void saveAllManuscriptsConformed(){
        for(Manuscript m : manuscriptPresentationService.getAllManuscriptsConformed()){
            manuscriptPresentationConformedService.addManuscript(m);
        }
        for(Manuscript m : manuscriptPresentationConformedService.getAllManuscripts()){
            System.out.println(m.toString());
        }
        System.out.println("The saving was made successfully!");
    }
}
