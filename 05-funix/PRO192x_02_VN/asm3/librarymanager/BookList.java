/* PRO192x_02_VN_Asm3_binhbdnFX06635 */

import java.util.Scanner;
import java.util.ArrayList;

// Class BookList: chứa danh sách các cuốn sách, và các phương thức xử lý liên quan.
public class BookList {
    public static final String SMS_FOR_INVALID_INPUT = "Dữ liệu nhập vào không hợp lệ. ";

    private static final String SEPARATOR = "---------------------------------------";
    private final String SMS_FOR_BLANK_STRING_INPUT = "Chuỗi trống nhập vào là không hợp lệ!";
    
    ArrayList<Book> allBooks = new ArrayList<>(); // biến lưu trữ Danh sách mảng các sách
    private boolean continueApp = true; // biến điều khiển chương trình tiếp tục hoặc thoát

    private static Scanner sc = new Scanner(System.in);

    // Nhận số nguyên trong khoảng [min max] (inclusive / bao gồm biên) từ console:
    public static int getIntegerWithInRangeFromConsole(String sms, String smsForInvalidInput, int min, int max) {
        if (min>max) return getIntegerWithInRangeFromConsole(sms, smsForInvalidInput, max, min);

        boolean invalidInput = true;
        int result=-1;

        do {
            System.out.print(sms);

            if (sc.hasNext()) {
                try {
                    result = sc.nextInt();
                    sc.nextLine();
                    if (result<min || result>max) {
                        System.out.println(smsForInvalidInput);
                    } else {
                        invalidInput = false;
                    }
                } catch(Exception e) {
                    System.err.println("Lỗi do dữ liệu nhập vào không hợp lệ! Chỉ được phép nhập số nguyên!");
                    sc.nextLine();
                }
            }       
        } while (invalidInput);

        return result;
    }

    // in ra ---------------------------------------
    public static void printSeparator() {
        System.out.println(SEPARATOR);
    }
    
    // 1. Thêm sách mới:
    public void add() {
        System.out.println("Nhập thông tin cho sách mới:");

        String id;
        boolean isDuplicate = true;
        do {
            id = getNoBlankStringFromConsole("Mã sách: ", SMS_FOR_BLANK_STRING_INPUT);
            
            if (noDuplicate(id)) {
                isDuplicate = false;
            } else {
                System.out.println("Đã tồn tại Mã sách " + id + " trong thư viện. Vui lòng nhập lại mã khác!");
            }
        } while(isDuplicate);

        String title = getNoBlankStringFromConsole("Tên sách: ", SMS_FOR_BLANK_STRING_INPUT);

        String author = getNoBlankStringFromConsole("Tác giả: ", SMS_FOR_BLANK_STRING_INPUT);

        boolean isBorrowed = false;
        if (getIntegerWithInRangeFromConsole("Đã cho mượn (1 = đúng, 0 = sai): ", SMS_FOR_INVALID_INPUT + "Vui lòng nhập số 0 hoặc số 1.", 0, 1) == 1) {
            isBorrowed = true;
        }

        addToList(id, title, author, isBorrowed);
    }

    // 2. Tìm kiếm theo tên sách
    public void searchByTitle() {
        ArrayList<Book> booksFound = new ArrayList<>();

        System.out.println("Nhập tên sách để tìm kiếm.");
        booksFound = searchByTitleResult(getNoBlankStringFromConsole("Tên sách: ", SMS_FOR_BLANK_STRING_INPUT));

        if (booksFound.isEmpty()) {
            System.out.println("Cuốn sách bạn cần tìm hiện không có trong thư viện. Bạn có thể quay lại tìm kiếm vào lúc khác.");
        } else {
            printTableHeader();
            printBooks(booksFound);
        }
    }

    // 3. Liệt kê sách của thư viện
    public void displayAllBooks() {
        if (allBooks.isEmpty()) {
            System.out.println("Thư viện chưa có cuốn sách nào!");
        } else {
            printTableHeader();
            printBooks(allBooks);
        }
    }

    // 4. Mượn sách theo mã sách
    public void borrowById() {
        System.out.println("Nhập mã sách cần mượn.");
        Book aBooksFound = searchByIdResult(getNoBlankStringFromConsole("Mã sách: ", SMS_FOR_BLANK_STRING_INPUT));

        if (aBooksFound.getId().equals("")) {
            System.out.println("Thư viện hiện không có sách này.");
        } else if (aBooksFound.getBorrowed()) {
            System.out.println("Sách này đã được cho mượn. Bạn có thể mượn vào lúc khác hoặc chọn sách khác để mượn.");
            return;
        } else {
            aBooksFound.setBorrowed(true);
            System.out.println("Bạn đã mượn thành công cuốn sách có mã " + aBooksFound.getId() + ". Thông tin đầy đủ hơn như sau:"); //(xxxx là Tên cuốn sách họ mượn)
            printTableHeader();
            System.out.println(aBooksFound.toString());
        }
    }

    // 5. Kết thúc chương trình
    public void exit() {
        System.out.println("Cảm ơn bạn đã sử dụng Thư Viện Sách Trực Tuyến!");
        continueApp = false;
    }

    // Thêm một phần tử Book vào ArrayList<Book> allBooks, ID được chuyển thành chữ viết hoa trước khi thêm.
    public void addToList(String id, String title, String author, boolean isBorrowed) {
        Book newBook = new Book(id.toUpperCase(), title, author, isBorrowed);
        allBooks.add(newBook);
    }

    // getter trả về giá trị của biến continueApp (biến điều khiển chương trình tiếp tục hoặc kết thúc)
    public final boolean getContinueApp() {
        return continueApp;
    }

    // Nhận chuỗi không rỗng từ console:
    private String getNoBlankStringFromConsole(String sms, String smsForInvalidInput) {
        boolean invalidInput = true;
        String result;

        do {
            System.out.print(sms);
            result = sc.nextLine();
            result = result.trim(); // bỏ khoảng trắng ở đầu và cuối chuỗi;
            if (result.isEmpty()) {
                System.out.println(smsForInvalidInput);
            } else {
                invalidInput = false;
            }
        } while (invalidInput);

        return result;
    }

    // Kiểm tra mã sách có bị trùng hay không
    private boolean noDuplicate(String newID) {
        if (allBooks.isEmpty()) return true;

        newID = newID.toUpperCase();
        for (Book book : allBooks) {
            if (book.getId().equals(newID)) return false;
        }

        return true;
    }

    // Tìm kiếm theo tên sách và trả về Danh sách mảng các sách tìm thấy nếu có
    private ArrayList<Book> searchByTitleResult(String searchKey) {
        ArrayList<Book> booksFound = new ArrayList<>();

        searchKey = searchKey.toLowerCase();

        for (Book book : allBooks) {
            if (book.getTitle().toLowerCase().contains(searchKey)) {
                booksFound.add(book);
            }
        }

        return booksFound;
    }

    // Tìm kiếm theo mã sách và trả về một sách tìm thấy nếu có
    private Book searchByIdResult(String searchKey) {
        searchKey = searchKey.toUpperCase();

        for (Book book : allBooks) {
            if (book.getId().equals(searchKey)) {
                return book;
            }
        }

        return new Book("","","",false);
    }

    // In tiêu đề của bảng danh mục sách
    private void printTableHeader() {
        System.out.println(String.format(Book.TABLE_ROW_FORMAT, "Mã sách", "Tên sách", "Tác giả", "Đã cho mượn"));
    }

    // In các sách trong một ArrayList<Book>
    private void printBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
