import java.util.List;
import java.util.Scanner;

public class Journal extends Document {
    private String issueMonth;

    public Journal() {
    }

    public Journal(String id, String publisherName, String issueNumber,  String issueMonth) {
        super(id, publisherName, issueNumber);
        this.issueMonth = issueMonth;
    }

    public String getIssueMonth() {
        return issueMonth;
    }

    public void setIssueMonth(String issueMonth) {
        this.issueMonth = issueMonth;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Issue month: " + issueMonth);
    }

    @Override
    public void inputData(Scanner scanner, List<Document> documents) {
        super.inputData(scanner, documents);
        System.out.println("Issue month: ");
        setIssueMonth(scanner.nextLine());
    }
}
