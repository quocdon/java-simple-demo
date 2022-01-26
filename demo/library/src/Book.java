import java.util.List;
import java.util.Scanner;

public class Book extends Document {
    private String authorName;
    private int pageNumber;

    public Book() {
    }

    public Book(String id, String publisherName, String issueNumber, String authorName, int pageNumber) {
        super(id, publisherName, issueNumber);
        this.authorName = authorName;
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Author name: " + authorName);
        System.out.println("Page number: " + pageNumber);
    }

    @Override
    public void inputData(Scanner scanner, List<Document> documents) {
        super.inputData(scanner, documents);
        System.out.println("Author name: ");
        setAuthorName(scanner.nextLine());
        System.out.println("Page number: ");
        setPageNumber(scanner.nextInt());
    }
}
