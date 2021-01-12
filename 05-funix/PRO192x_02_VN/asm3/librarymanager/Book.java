/* PRO192x_02_VN_Asm3_binhbdnFX06635 */

// Class Book: định nghĩa thuộc tính và phương thức cho các cuốn sách.
public class Book {
    public static final String TABLE_ROW_FORMAT = "%-15s%-30s%-30s%-20s"; // ĐỊNH DẠNG HIỂN THỊ TỪNG HÀNG CỦA BẢNG
    
    private String id;                  // mã sách
    private String title;               // tên sách
    private String author;              // tác giả
    private boolean isBorrowed = false; //  trạng thái: true nếu đã cho ai đó mượn, false nếu chưa

    public Book(String id, String title, String author, boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    public final String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public final String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public final boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return String.format(TABLE_ROW_FORMAT, id, title, author, isBorrowed);
    }
}