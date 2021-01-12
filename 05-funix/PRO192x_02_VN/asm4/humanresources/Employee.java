/* PRO192x_02_VN_Asm4_binhbdnFX06635 */

import java.util.Date;
import java.text.SimpleDateFormat;

// Employee.java là lớp kế thừa lớp Staff, chứa thông tin chung về nhân viên
public class Employee extends Staff implements ICalculator, Comparable<Employee> {
    // ĐỊNH DẠNG HIỂN THỊ TỪNG HÀNG CỦA BẢNG NHÂN VIÊN
    public static final String ROW_FORMAT_FOR_EMPLOYEE_TABLE = "%-10s%-26s%-8s%-13s%-16s%-13s%-13s";
    
    private int overtimeHours;      // số giờ làm thêm

    // empty contructor
    public Employee() {};

    // contructor
    public Employee
    (   String id,
        String fullName,
        int age,
        double salaryFactor,
        Date startDate,
        String departmentId,
        int vacationDays,
        int overtimeHours
    )
    {
		super(id, fullName, age, salaryFactor, startDate, departmentId, vacationDays);
		this.overtimeHours = overtimeHours;
    }

    // Phương thức calculateSalary() tính toán và trả về lương nhân viên
    // (triển khai phương thức của giao diện ICalculator)
	public double calculateSalary() {
        // Công thức tính lương Nhân viên: Hệ số lương * 3,000,000 + số giờ làm thêm * 200,000
        // chỉ tính chính xác đến phần mười (một số sau dấu chấm thập phân) :

        return (int)((super.getSalaryFactor() * 3000000 + overtimeHours * 200000) * 10) / 10.0;
	}

    // Phương thức toString() hiển thị thông tin nhân viên
    // (đưa ra phần thân cho phương thức trừu tượng của lớp Staff - lớp cha)
	public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return String.format
        (   ROW_FORMAT_FOR_EMPLOYEE_TABLE,
            "| " + super.getId(),
            "| " + super.getFullName(),
            "| " + super.getAge(),
            "| " + super.getSalaryFactor(),
            "| " + simpleDateFormat.format(super.getStartDate()),
            "| " + super.getDepartmentId(),
            "| " + super.getVacationDays()
        );
	}
    
    // getter & setter for overtimeHours
    public final int getOvertimeHours() {
        return overtimeHours;
    }

    public final void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        /* For Ascending order*/
        return (int)(this.calculateSalary()*10 - otherEmployee.calculateSalary()*10);
    }
}