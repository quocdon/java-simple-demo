import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Document> documents = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("---------MAIN MENU --------\n" +
                "1. Add new book\n" +
                "2. Add new journal\n" +
                "3. Show document list\n" +
                "4. Exit");
        String selectedNumber = scanner.next();
        switch (selectedNumber) {
            case "1": {
                System.out.println("-------- INPUT BOOK -------");
                Document book = new Book();
                book.inputData(scanner);
                documents.add(book);
                main(args);
                break;
            }
            case "2": {
                System.out.println("-------- INPUT JOURNAL --------");
                Document journal = new Journal();
                journal.inputData(scanner);
                documents.add(journal);
                main(args);
                break;
            }
            case "3": {
                System.out.println("-------DOCUMENT LIST -------");
                for (Document document: documents) {
                    document.showData();
                    System.out.println("---------");
                }
                main(args);
                break;
            }
            case "4":
                scanner.close();
                System.exit(0);
            default: main(args);
        }
    }
}
