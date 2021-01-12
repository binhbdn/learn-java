public class CompareSalary implements Comparable<CompareSalary> {
    public boolean isManager = false; // true nếu là Manager, false nếu là Employee
    public int index; // chỉ số trong danh sách mảng (Manager hoặc Employee)
    int salary; // lương của Manager hoặc Employee * 10 và parse sang int

    @Override
    public int compareTo(CompareSalary otherCompareSalary) {
        /* For Ascending order*/
        return this.salary - otherCompareSalary.salary;
    }
}
