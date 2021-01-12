/* PRO192x_02_VN_Asm3_binhbdnFX06635 */

public class Manager {
    
    // hàm main() điều khiển luồng chính của chương trình
    public static void main(String[] args) {
        BookList bookList = new BookList();
        int choice;

        System.out.println("Chào mừng bạn đến với Thư Viện Sách Trực Tuyến");
        BookList.printSeparator();

        // Tự thêm một số sách mới vào thư viện sách (ban đầu rỗng) để phục vụ review assignment này !
        // Khi review sẽ comment out - nếu cần thiết
        bookList.addToList("HW1", "The cooker", "Tim", false);
        bookList.addToList("HW2", "The Timer", "Steven", true);
        bookList.addToList("HW3", "Travel to world", "Job", false);
        bookList.addToList("HW4", "Food cooker", "Shen", false);
        bookList.addToList("HW5", "See the world", "Timony", false);
        bookList.addToList("FUNIX01", "Funix History", "Nguyen Thanh Nam", false);

        while (bookList.getContinueApp()) {
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Tìm kiếm theo tên sách");
            System.out.println("3. Liệt kê sách của thư viện");
            System.out.println("4. Mượn sách theo mã sách");
            System.out.println("5. Thoát chương trình");
            choice = BookList.getIntegerWithInRangeFromConsole("Nhập số để chọn chức năng: ", BookList.SMS_FOR_INVALID_INPUT + "Vui lòng nhập số từ 1 đến 5.", 1, 5);
            System.out.println();
            switch (choice) {
                case 1:
                    // 1. Thêm sách mới:
                    bookList.add();
                    break;
                case 2:
                    // 2. Tìm kiếm theo tên sách
                    bookList.searchByTitle();
                    break;
                case 3:
                    // 3. Liệt kê sách của thư viện
                    bookList.displayAllBooks();
                    break;
                case 4:
                    // 4. Mượn sách theo mã sách
                    bookList.borrowById();
                    break;
                case 5:
                    // 5. Kết thúc chương trình
                    bookList.exit();
                default:
                    choice = 0;
            }

            BookList.printSeparator();
        }
    }
}