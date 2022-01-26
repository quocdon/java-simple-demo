import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Document> documents = new ArrayList<>();
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("---------MAIN MENU --------\n" +
                "1. Add new document\n" +
                "2. Delete document\n" +
                "3. Show document list\n" +
                "4. Exit\n" +
                "Please choose: ");
        String selectedNumber = scanner.next();
        switch (selectedNumber) {
            case "1": {
                addNewDocument();
                break;
            }
            case "2": {
                deleteDocument();
                break;
            }
            case "3": {
                showDocument();
                break;
            }
            case "4":
                scanner.close();
                System.exit(0);
            default: mainMenu();
        }
    }

    public static void addNewDocument() {
        System.out.println("------INPUT DOCUMENT------\n" +
                "1. New Book\n" +
                "2. New Journal\n" +
                "3. New Newspaper\n" +
                "4. Back to Main menu\n" +
                "Please choose: ");
        String selectedNumber = scanner.next();
        Document newDocument = null;
        switch (selectedNumber){
            case "1": {
                newDocument = new Book();
                break;
            }
            case "2": {
                newDocument = new Journal();
                break;
            }
            case "3": {
                newDocument = new Newspaper();
                break;
            }
            case "4": mainMenu();
            default: addNewDocument();
        }
        newDocument.inputData(scanner, documents);
        documents.add(newDocument);
        System.out.println("Add document ID: " + newDocument.getId() + " successfully");
        addNewDocument();
    }

    public static void deleteDocument() {
        System.out.println("-----DELETE DOCUMENT-----");
        System.out.println("Enter document id: ");
        String id = scanner.next();
        if (documents.isEmpty()) {
            System.out.println("Document list is empty");
        } else {
            boolean notFound = true;
            for (Document document: documents) {
                if (document.getId().equals(id)) {
                    notFound = false;
                    documents.remove(document);
                    System.out.println("Delete document " + document.getId() + " successfully");
                    break;
                }
            }
            if (notFound) {
                System.out.println("Document Id " + id + " not found");
            }
        }
        mainMenu();
    }

    public static void showDocument() {
        System.out.println("-----DOCUMENT LIST-----");
        if (documents.isEmpty()){
            System.out.println("Document list is empty");
        } else {
            for (Document document: documents){
                document.showData();
                System.out.println("----------");
            }
        }
        mainMenu();
    }
}
