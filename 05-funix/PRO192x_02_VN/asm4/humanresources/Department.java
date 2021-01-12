/* PRO192x_02_VN_Asm4_binhbdnFX06635 */

// Department.java là lớp chứa thông tin chung về bộ phận
public class Department {
    // ĐỊNH DẠNG HIỂN THỊ TỪNG HÀNG CỦA BẢNG BỘ PHẬN
    public static final String ROW_FORMAT_FOR_DEPARTMENT_TABLE = "%-13s%-26s%-21s%-1s";

    private String id;              // mã bộ phận
    private String name;            // tên bộ phận
    private int membersQuantity;    //số lượng nhân viên hiện tại

    // empty contructor
    public Department() {};

    // contructor
    public Department(String id, String name, int membersQuantity) {
        this.id = id.toUpperCase();
        this.name = name;
        this.membersQuantity = membersQuantity;
    }

    // Phương thức toString() hiển thị thông tin về bộ phận
    public String toString() {
        return String.format
        (   ROW_FORMAT_FOR_DEPARTMENT_TABLE,
            "| " + id,
            "| " + name,
            "| " + membersQuantity,
            "| "
        );
    }
    
    // getter & setter for id
    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id.toUpperCase();
    }

    // getter & setter for name
    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    // getter & setter for membersQuantity
    public final int getMembersQuantity() {
        return membersQuantity;
    }

    public final void setMembersQuantity(int membersQuantity) {
        this.membersQuantity = membersQuantity;
    }
}