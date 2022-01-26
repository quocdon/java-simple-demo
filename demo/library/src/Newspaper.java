import java.util.List;
import java.util.Scanner;

public class Newspaper extends Document {
    private String dateOfIssue;

    public Newspaper() {
    }

    public Newspaper(String id, String publisherName, String issueNumber, String dateOfIssue) {
        super(id, publisherName, issueNumber);
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Date of issue: " + dateOfIssue);
    }

    @Override
    public void inputData(Scanner scanner, List<Document> documents) {
        super.inputData(scanner, documents);
        System.out.println("Date of issue: ");
        setDateOfIssue(scanner.nextLine());
    }
}
