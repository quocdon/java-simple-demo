import java.util.List;
import java.util.Scanner;

public abstract class Document {
    private String id;
    private String publisherName;
    private String issueNumber;

    public Document() {
    }

    public Document(String id, String publisherName, String issueNumber) {
        this.id = id;
        this.publisherName = publisherName;
        this.issueNumber = issueNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public void showData() {
        System.out.println("ID: " + id);
        System.out.println("Publisher name: " + publisherName);
        System.out.println("Issue number: " + issueNumber);
    }

    public void inputData(Scanner scanner, List<Document> documents) {
        String id = null;
        do {
            System.out.println("ID: ");
            id = scanner.nextLine();
        } while (checkIdExist(id, documents));
        setId(id);
        System.out.println("Publisher name: ");
        setPublisherName(scanner.nextLine());
        System.out.println("Issue number: ");
        setIssueNumber(scanner.nextLine());
    }

    public boolean checkIdExist(String id, List<Document> documents){
        if (id.equals("")) {
            return true;
        }
        if (!documents.isEmpty()) {
            for (Document document: documents) {
                if (document.getId().equals(id)) {
                    System.out.println("Document id exists!");
                    return true;
                }
            }
        }
        return false;
    }
}
