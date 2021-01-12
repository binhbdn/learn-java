/* PRO192x_02_VN_Asm4_binhbdnFX06635 */

import java.util.Date;
import java.text.SimpleDateFormat;

// Employee.java là lớp kế thừa lớp Staff, chứa thông tin chung về quản lý
public class Manager extends Staff implements ICalculator, Comparable<Manager> {
    private String title;  // chức danh

    // empty contructor
    public Manager() {};

    // contructor
    public Manager
    (   String id,
        String fullName,
        int age,
        double salaryFactor,
        Date startDate,
        String departmentId,
        int vacationDays,
        String title
    )
    {
		super(id, fullName, age, salaryFactor, startDate, departmentId, vacationDays);
		this.title = title;
    }

    // Phương thức calculateSalary() tính toán và trả về lương quản lý
    // (triển khai phương thức của giao diện ICalculator)
	public double calculateSalary() {
        // Công thức tính lương Quản lý: Hệ số lương * 5,000,000 + lương trách nhiệm
        // trong đó, Lương trách nhiệm:
        //          Business Leader = 8,000,000
        //          Technical Leader = 6,000,000
        //          Project Leader = 5,000,000
        // chỉ tính chính xác đến phần mười (một số sau dấu chấm thập phân) :

        int bonus;
        if (title.equalsIgnoreCase("Business Leader")) {
            bonus = 8000000;
        } else if (title.equalsIgnoreCase("Technical Leader")) {
            bonus = 6000000;
        } else if (title.equalsIgnoreCase("Project Leader")) {
            bonus = 5000000;
        } else {
            bonus = 3000000;
        }

        return (int)((super.getSalaryFactor() * 5000000 + bonus) * 10) / 10.0;
	}

    // Phương thức toString() hiển thị thông tin quản lý bao gồm cả chức danh
    // (đưa ra phần thân cho phương thức trừu tượng của lớp Staff - lớp cha)
	public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return String.format
        (   Employee.ROW_FORMAT_FOR_EMPLOYEE_TABLE + "%-16s%-1s",
            "| " + super.getId(),
            "| " + super.getFullName(),
            "| " + super.getAge(),
            "| " + super.getSalaryFactor(),
            "| " + simpleDateFormat.format(super.getStartDate()),
            "| " + super.getDepartmentId(),
            "| " + super.getVacationDays(),
            "| " + title,
            "|"
        );
	}
    
    // getter & setter for title
    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Manager otherManager) {
        /* For Ascending order*/
        return (int)(this.calculateSalary()*10 - otherManager.calculateSalary()*10);
    }
}