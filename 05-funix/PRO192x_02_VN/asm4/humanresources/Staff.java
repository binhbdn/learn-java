/* PRO192x_02_VN_Asm4_binhbdnFX06635 */

import java.util.Date;

// Staff.java là lớp trừu tượng (abstract class) chứa các thông tin cơ bản của nhân viên
public abstract class Staff {
    // Các thuộc tính:
    private String id;                  // mã nhân viên
    private String fullName;            // tên nhân viên
    private int age;                    // tuổi nhân viên
    private double salaryFactor;        // hệ số lương
    private Date startDate;    // ngày vào làm
    private String departmentId;          // bộ phận làm việc
    private int vacationDays;           // số ngày nghỉ phép

    // toString() là phương thức trừu tượng (abstract method)
    public abstract String toString();

    // empty contructor
    public Staff() {};

    // contructor
    public Staff
    (   String id,
        String fullName,
        int age,
        double salaryFactor,
        Date startDate,
        String departmentId,
        int vacationDays
    )
    {
        this.id = id.toUpperCase();
        this.fullName = fullName;
        this.age = age;
        this.salaryFactor = salaryFactor;
        this.startDate = startDate;
        this.departmentId = departmentId;
        this.vacationDays = vacationDays;
    }

    // getter & setter for id
    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id.toUpperCase();
    }

    // getter & setter for fullName
    public final String getFullName() {
        return fullName;
    }

    public final void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // getter & setter for age
    public final int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    // getter & setter for salaryFactor
    public final double getSalaryFactor() {
        return salaryFactor;
    }

    public final void setSalaryFactor(double salaryFactor) {
        this.salaryFactor = salaryFactor;
    }

    // getter & setter for startDate
    public final Date getStartDate() {
        return startDate;
    }

    public final void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // getter & setter for department
    public final String getDepartmentId() {
        return departmentId;
    }

    public final void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    // getter & setter for vacationDays
    public final int getVacationDays() {
        return vacationDays;
    }

    public final void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }
}