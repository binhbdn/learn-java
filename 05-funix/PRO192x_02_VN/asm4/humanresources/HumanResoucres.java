
/* PRO192x_02_VN_Asm4_binhbdnFX06635 */

/*  class HumanResoucres chứa luồng chính của chương trình
        1. Hiển thị danh sách nhân viên hiện có trong công ty
        2. Hiển thị các bộ phận trong công ty
        3. Hiển thị các nhân viên theo từng bộ phận
        4. Thêm nhân viên mới vào công ty: bao gồm 2 loại
            - Thêm nhân viên thông thường 
            - Thêm nhân viên là cấp quản lý (có thêm chức vụ)
        5. Tìm kiếm thông tin nhân viên theo tên
        6. Hiển thị bảng lương của nhân viên toàn công ty
        7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class HumanResoucres {
    private static final String SMS_FOR_INVALID_INPUT = "Dữ liệu nhập vào không hợp lệ. ";
    private static final String SMS_FOR_BLANK_STRING_INPUT = "Chuỗi trống nhập vào là không hợp lệ!";
    private static final String SMS_INPUT_DATA_AGAIN = "Vui lòng nhập lại!";

    // biến điểu khiển chương trình tiếp tục hay dừng.
    private static boolean continueApp = true;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // biến lưu trữ chức năng điều khiển
        int choice;
        
        // đọc dữ liệu các quản lý công ty từ file txt và trả về danh sách mảng
        ArrayList<Manager> managersList = readManagersDataFromFile("humanresources/managers.txt");
        //System.out.println(managersList.size());
        
        // đọc dữ liệu các nhân viên công ty từ file txt và trả về danh sách mảng
        ArrayList<Employee> employeesList = readEmployeesDataFromFile("humanresources/employees.txt");
        //System.out.println(employeesList.size());
        
        // đọc dữ liệu các bộ phận (phòng ban) công ty từ file txt và trả về danh sách mảng
        ArrayList<Department> departmentsList = readDepartmentsDataFromFile("humanresources/departments.txt");
        //System.out.println(employeesList.size());

        // Hiển thị thông điệp chào mừng + tên chương trình
        viewWelcome();

        while (continueApp) {
            // Hiển thị bảng điều khiển
            viewControlPanel();

            choice = getIntegerWithInRangeFromConsole("Nhập số để chọn chức năng: ", SMS_FOR_INVALID_INPUT + "Vui lòng nhập số từ 1 đến 8.", 1, 8);
            System.out.println();
            switch (choice) {
                case 1:
                    // 1. Hiển thị danh sách nhân viên hiện có trong công ty
                    /* Hiển thị tiêu đề bảng:
                        8 cột nếu danh sách có cán bộ quản lý,
                        7 cột nếu danh sách chỉ có nhân viên thường,
                        không có nhân viên thì không in tiêu đề bảng
                    */
                    if (managersList.size() != 0 || employeesList.size() != 0) {
                        System.out.println("BẢNG DANH SÁCH NHÂN VIÊN HIỆN CÓ TRONG CÔNG TY");
                        if (managersList.size() != 0) {
                            viewHeaderForManagers();
                        } else {
                            viewHeaderForEmployee();
                        }
                        // in danh sách tất cả cán bộ quản lý
                        printAllManagers(managersList, 0, departmentsList);
                        // in danh sách tất cả nhân viên
                        printAllEmployees(employeesList, managersList.size(), departmentsList);
                    } else {
                        System.out.println("Chưa có dữ liệu nhân viên nào được nhập vào và lưu trữ!.");
                    }
                    break;
                case 2:
                    // 2. Hiển thị các bộ phận trong công ty
                    if (departmentsList.size() != 0) {
                        System.out.println("BẢNG DANH SÁCH CÁC BỘ PHẬN TRONG CÔNG TY");
                    }
                    printAllDepartments(departmentsList);
                    break;
                case 3:
                    // 3. Hiển thị các nhân viên theo từng bộ phận
                    if (departmentsList.size() == 0) {
                        System.out.println("Dữ liệu các bộ phận và/hoặc dữ liệu nhân viên chưa được nhập vào!.");
                    } else {
                        String deptId;
                        boolean isInvalid = true;
                        do {
                            deptId = getNoBlankStringFromConsole("Nhập mã bộ phận cần hiển thị danh sách các nhân viên: ", SMS_FOR_BLANK_STRING_INPUT);
                            
                            if (hasDepartmentId(departmentsList, deptId)) {
                                isInvalid = false;

                                ArrayList<Manager> managersListByDeptId = findManagersByDepartmentId(managersList, deptId);
                                ArrayList<Employee> employeesListByDeptId = findEmployeesByDepartmentId(employeesList, deptId);

                                if (managersListByDeptId.size() != 0 || employeesListByDeptId.size() != 0) {
                                    System.out.println("BẢNG DANH SÁCH NHÂN VIÊN HIỆN CÓ TRONG BỘ PHẬN " + getDeptNameFromInputDeptId(departmentsList, deptId).toUpperCase());
                                } else {
                                    System.out.println("Không tìm thấy kết quả phù hợp!.");
                                }
                                if (managersListByDeptId.size() != 0) {
                                    viewHeaderForManagers();
                                } else if (employeesListByDeptId.size() != 0) {
                                    viewHeaderForEmployee();
                                }
                                // in danh sách tất cả cán bộ quản lý tìm thấy nếu có
                                printAllManagers(managersListByDeptId, 0, departmentsList);
                                // in danh sách tất cả nhân viên tìm thấy nếu có
                                printAllEmployees(employeesListByDeptId, managersListByDeptId.size(), departmentsList);
                            } else {
                                System.out.println("Mã bộ phận " + deptId + " không tồn tại. Vui lòng nhập lại mã khác dựa vào BẢNG DANH SÁCH CÁC BỘ PHẬN dưới đây!");
                                printAllDepartments(departmentsList);
                            }
                        } while(isInvalid);
                    }
                    break;
                case 4:
                    // 4. Thêm nhân viên mới vào công ty
                    int staffType;                  // loại nhân viên (1=thường, 2=quản lý)
                    boolean isInvalid_4 = true;

                    String id;                      // mã nhân viên
                    String fullName;                // tên nhân viên
                    int age;                        // tuổi nhân viên
                    double salaryFactor;            // hệ số lương
                    String startDateString;         // ngày vào làm kiểu dữ liệu Date
                    Date startDate = new Date();    // ngày vào làm kiểu dữ liệu Date
                    String departmentId;            // bộ phận làm việc
                    int vacationDays;               // số ngày nghỉ phép

                    // nhập loại nhân viên (1=thường, 2=quản lý)
                    do {
                        staffType = getIntegerWithInRangeFromConsole("Nhập số 1 để Thêm nhân viên thông thường, số 2 để Thêm nhân viên là cấp quản lý: ", SMS_FOR_INVALID_INPUT + "Vui lòng nhập số 1 hoặc 2.", 1, 2);
                        if (staffType == Integer.MIN_VALUE) {
                            // Báo nhập lại do lỗi nhập ký tự không phải số nguyên
                            System.out.println(SMS_INPUT_DATA_AGAIN);
                        }
                    } while(!(staffType==1 || staffType==2));
                    
                    // nhập mã nhân viên, không được trùng với mã nhân viên cũ, không quá 6 ký tự
                    do {
                        id = getNoBlankStringFromConsole("Nhập mã nhân viên: ", SMS_FOR_BLANK_STRING_INPUT);
                        if (hasStaffId(managersList, employeesList, id)) {
                            System.out.println("Mã nhân viên " + id + " đã tồn tại. Vui lòng nhập lại mã khác!");
                        } else if (id.length()>6) {
                            System.out.println("Mã nhân viên không được quá 6 ký tự. " + SMS_INPUT_DATA_AGAIN);
                        } else {
                            isInvalid_4 = false;
                        }
                    } while(isInvalid_4);

                    // nhập tên nhân viên
                    fullName = getNoBlankStringFromConsole("Họ và tên: ", SMS_FOR_BLANK_STRING_INPUT);

                    // nhập tuổi nhân viên, >= 18 tuổi, <=65 tuổi
                    do {
                        age = getIntegerWithInRangeFromConsole("Tuổi: ", SMS_FOR_INVALID_INPUT + "Độ tuổi lao động là từ 18 đến 65! " + SMS_INPUT_DATA_AGAIN, 18, 65);
                        if (age == Integer.MIN_VALUE) {
                            // Báo nhập lại do lỗi nhập ký tự không phải số nguyên
                            System.out.println(SMS_INPUT_DATA_AGAIN);
                        }
                    } while(age<18 || age>65);

                    // nhập hệ số lương > 0.0, <15.0
                    do {
                        salaryFactor = getPostivieDoubleFromConsole("Hệ số lương: ", SMS_FOR_INVALID_INPUT + "Hệ số lương phải lớn hơn 0 và không vượt quá 15! " + SMS_INPUT_DATA_AGAIN, 15.0);
                        if (age == Integer.MIN_VALUE) {
                            // Báo nhập lại do lỗi nhập ký tự không phải số nguyên
                            System.out.println(SMS_INPUT_DATA_AGAIN);
                        }
                    } while(salaryFactor<0.0 || salaryFactor>15.0);

                    
                    // nhập ngày bắt đầu vào làm
                    isInvalid_4 = true;
                    do {
                        startDateString = getNoBlankStringFromConsole("Ngày bắt đầu vào làm (dd/MM/yyyy): ", SMS_FOR_INVALID_INPUT);
                        try {
                            startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
                            isInvalid_4 = false;
                        } catch (Exception e) {
                            System.out.println("Lỗi do ngày không đúng định dạng dd/MM/yyyy hoặc ngày không tồn tại");
                            e.printStackTrace();
                        }
                    } while(isInvalid_4);

                    // nhập mã bộ phận làm việc
                    isInvalid_4 = true;
                    do {
                        departmentId = getNoBlankStringFromConsole("Nhập mã bộ phận làm việc: ", SMS_FOR_BLANK_STRING_INPUT);
                        
                        if (hasDepartmentId(departmentsList, departmentId)) {
                            isInvalid_4 = false;
                        } else {
                            System.out.println("Mã bộ phận " + departmentId + " không tồn tại. Vui lòng nhập lại mã khác dựa vào BẢNG DANH SÁCH CÁC BỘ PHẬN dưới đây!");
                            printAllDepartments(departmentsList);
                        }
                    } while(isInvalid_4);

                    // nhập số ngày nghỉ phép, >= 12, <=30
                    do {
                        vacationDays = getIntegerWithInRangeFromConsole("Tổng ngày phép: ", SMS_FOR_INVALID_INPUT + "Tổng ngày phép phải nằm trong khoảng 12 đến 30 ngày! " + SMS_INPUT_DATA_AGAIN, 12, 30);
                        if (vacationDays == Integer.MIN_VALUE) {
                            // Báo nhập lại do lỗi nhập ký tự không phải số nguyên
                            System.out.println(SMS_INPUT_DATA_AGAIN);
                        }
                    } while(vacationDays<12 || vacationDays>30);

                    // nếu là nhân viên bình thường thì cần nhập thêm số giờ làm thêm
                    if (staffType==1) {
                        int overtimeHours;      // số giờ làm thêm

                        do {
                            overtimeHours = getIntegerWithInRangeFromConsole("Số giờ làm thêm: ", SMS_FOR_INVALID_INPUT + "Số giờ làm thêm phải nằm trong khoảng 0 đến 100 giờ! " + SMS_INPUT_DATA_AGAIN, 0, 100);
                            if (overtimeHours == Integer.MIN_VALUE) {
                                // Báo nhập lại do lỗi nhập ký tự không phải số nguyên
                                System.out.println(SMS_INPUT_DATA_AGAIN);
                            }
                        } while(overtimeHours<0 || overtimeHours>100);

                        // thêm nhân viên bình thường vào danh sách mảng
                        employeesList.add(new Employee(id, fullName, age, salaryFactor, startDate, departmentId, vacationDays, overtimeHours));
                    
                    // nếu là quản lý cần nhập thêm chức danh    
                    } else {
                        // chức danh
                        String title = getNoBlankStringFromConsole("Chức danh quản lý: ", SMS_FOR_BLANK_STRING_INPUT);
                        
                        // thêm nhân viên cấp quản lý vào danh sách mảng
                        managersList.add(new Manager(id, fullName, age, salaryFactor, startDate, departmentId, vacationDays, title));
                    }

                    // cập nhật số lượng nhân viên cho bộ phận
                    for (Department aDepartment : departmentsList) {
                        if (aDepartment.getId().equalsIgnoreCase(departmentId)) {
                            aDepartment.setMembersQuantity(aDepartment.getMembersQuantity() + 1);
                        }
                    }

                    break;
                case 5:
                    // 5. Tìm kiếm thông tin nhân viên theo tên
                    if (managersList.size() == 0 && employeesList.size() == 0) {
                        System.out.println("Chưa có bất kỳ nhân viên nào được nhập vào và lưu trữ!.");
                    } else {
                        String staffName = getNoBlankStringFromConsole("Nhập tên nhân viên cần tìm kiếm: ", SMS_FOR_BLANK_STRING_INPUT);
                        ArrayList<Manager> managersListByName = findManagersByName(managersList, staffName);
                        ArrayList<Employee> employeesListByName = findEmployeesByName(employeesList, staffName);

                        if (managersListByName.size() != 0 || employeesListByName.size() != 0) {
                            System.out.println("BẢNG KẾT QUẢ TÌM KIẾM NHÂN VIÊN");
                            if (managersListByName.size() != 0) {
                                viewHeaderForManagers();
                            } else {
                                viewHeaderForEmployee();
                            }
                            // in danh sách tất cả cán bộ quản lý tìm thấy nếu có
                            printAllManagers(managersListByName, 0, departmentsList);
                            // in danh sách tất cả nhân viên tìm thấy nếu có
                            printAllEmployees(employeesListByName, managersListByName.size(), departmentsList);
                        } else {
                            System.out.println("Không tìm thấy kết quả phù hợp!.");
                        }
                    }
                    break;
                case 6:
                    // 6. Hiển thị bảng lương của nhân viên toàn công ty
                    if (managersList.size() != 0 || employeesList.size() != 0) {
                        System.out.println("BẢNG LƯƠNG TOÀN BỘ NHÂN VIÊN CÔNG TY");
                        if (managersList.size() != 0) {
                            viewSalaryHeaderForManagers();
                        } else {
                            viewSalaryHeaderForEmployee();
                        }
                        // in danh sách lương tất cả cán bộ quản lý
                        printSalaryAllManagers(managersList, 0, departmentsList);
                        // in danh sách lương tất cả nhân viên
                        printSalaryAllEmployees(employeesList, managersList.size(), departmentsList);
                    } else {
                        System.out.println("Chưa có dữ liệu nhân viên nào được nhập vào và lưu trữ!.");
                    }
                    break;
                case 7:
                    // 7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
                    if (managersList.size() != 0 || employeesList.size() != 0) {
                        System.out.println("BẢNG LƯƠNG TOÀN BỘ NHÂN VIÊN THEO THỨ TỰ TĂNG DẦN");
                        if (managersList.size() != 0) {
                            viewSalaryHeaderForManagers();
                        } else {
                            viewSalaryHeaderForEmployee();
                        }
                        ArrayList<CompareSalary> salarysList = new ArrayList<>();

                        for (Manager aManager : managersList) {
                            CompareSalary aSalary = new CompareSalary();
                            
                            aSalary.isManager = true;
                            aSalary.index = managersList.indexOf(aManager);
                            aSalary.salary = (int)(aManager.calculateSalary() * 10);

                            salarysList.add(aSalary);
                        }

                        for (Employee anEmployee : employeesList) {
                            CompareSalary aSalary = new CompareSalary();
                            
                            aSalary.isManager = false;
                            aSalary.index = employeesList.indexOf(anEmployee);
                            aSalary.salary = (int)(anEmployee.calculateSalary() * 10);

                            salarysList.add(aSalary);
                        }

                        Collections.sort(salarysList);

                        // in Bảng lương theo thứ tự tăng dần
                        printSalaryAscending(salarysList, managersList, employeesList, departmentsList);
                    } else {
                        System.out.println("Chưa có dữ liệu nhân viên nào được nhập vào và lưu trữ!.");
                    }

                    break;
                case 8:
                    // 8. Thoát chương trình
                    exit();
                    break;
                case Integer.MIN_VALUE:
                    // Báo nhập lại do lỗi nhập ký tự không phải số nguyên
                    System.out.println(SMS_INPUT_DATA_AGAIN);
            }
        }
    }

    // 1.1. Hiển thị danh sách QUẢN LÝ hiện có trong ArrayList truyền vào
    private static void printAllManagers(ArrayList<Manager> list, int order, ArrayList<Department> departmentsList) {
        if (list.size()!=0) {
            String str;
            char ch = '.';
    
            for (Manager aManager : list) {
                order++;
                if (order<10) {
                    str = "| 0";
                } else {
                    str = "| ";
                }
                str += order;

                if (list.size()==order) ch = '-';

                System.out.print(String.format("%-6s", str));
                System.out.println(aManager.toString());
                printRowBorder(122,ch);
            }
        }
    }

    // 1.2. Hiển thị danh sách nhân viên hiện có trong ArrayList truyền vào
    private static void printAllEmployees(ArrayList<Employee> list, int order, ArrayList<Department> departmentsList) {
        if (list.size()!=0) {
            String startStr;
            String endStr;
            char ch = '.';
            int charNumber;

            if (order == 0) {
                endStr = "|";
                charNumber = 106;
            } else {
                endStr = "|               |";
                charNumber = 122;
            }
    
            for (Employee anEmployee : list) {
                order++;
                if (order<10) {
                    startStr = "| 0";
                } else {
                    startStr = "| ";
                }
                startStr += order;

                if (list.size()==order) ch = '-';

                System.out.print(String.format("%-6s", startStr));
                System.out.print(anEmployee.toString());
                System.out.println(endStr);
                printRowBorder(charNumber,ch);
            }
        }
    }

    // 2. Hiển thị các bộ phận trong công ty
    private static void printAllDepartments(ArrayList<Department> list) {
        if (list.size()==0) {
            System.out.println("Chưa có dữ liệu bộ phận phòng ban nào được nhập vào và lưu trữ!.");
        } else {
            int order = 0;
            String str;
            char ch = '.';
    
            viewHeaderForDepartments();

            for (Department aDepartment : list) {
                order++;
                if (order<10) {
                    str = "| 0";
                } else {
                    str = "| ";
                }
                str += order;

                if (list.size()==order) ch = '-';

                System.out.print(String.format("%-6s", str));
                System.out.println(aDepartment.toString());
                printRowBorder(67,ch);
            }
        }
    }

    // 3.1 Tìm kiếm quản lý theo mã bộ phận nhập vào, trả về danh sách mảng chứa kết quả
    private static ArrayList<Manager> findManagersByDepartmentId(ArrayList<Manager> managersList, String deptId) {
        ArrayList<Manager> managersListByDeptId = new ArrayList<>();
        for (Manager aManager : managersList) {
            if (aManager.getDepartmentId().equalsIgnoreCase(deptId)) {
                managersListByDeptId.add(aManager);
            }
        }
        return managersListByDeptId;
    }

    // 3.2 Tìm kiếm nhân viên theo mã bộ phận nhập vào, trả về danh sách mảng chứa kết quả
    private static ArrayList<Employee> findEmployeesByDepartmentId(ArrayList<Employee> employeesList, String deptId) {
        ArrayList<Employee> employeesListByDeptId = new ArrayList<>();
        for (Employee anEmployee : employeesList) {
            if (anEmployee.getDepartmentId().equalsIgnoreCase(deptId)) {
                employeesListByDeptId.add(anEmployee);
            }
        }
        return employeesListByDeptId;
    }

    // 5.1 Tìm kiếm quản lý theo tên nhập vào, trả về danh sách mảng chứa kết quả
    private static ArrayList<Manager> findManagersByName(ArrayList<Manager> managersList, String staffName) {
        ArrayList<Manager> managersListByName = new ArrayList<>();
        staffName = removeAccents(staffName);

        for (Manager aManager : managersList) {
            if (removeAccents(aManager.getFullName()).contains(staffName)) {
                managersListByName.add(aManager);
            }
        }
        return managersListByName;
    }

    // 5.2 Tìm kiếm nhân viên theo tên nhập vào, trả về danh sách mảng chứa kết quả
    private static ArrayList<Employee> findEmployeesByName(ArrayList<Employee> employeesList, String staffName) {
        ArrayList<Employee> employeesListByName = new ArrayList<>();
        staffName = removeAccents(staffName);
        
        for (Employee anEmployee : employeesList) {
            if (removeAccents(anEmployee.getFullName()).contains(staffName)) {
                employeesListByName.add(anEmployee);
            }
        }
        return employeesListByName;
    }

    // 6.1. Hiển thị bảng lương QUẢN LÝ hiện có trong ArrayList truyền vào
    private static void printSalaryAllManagers(ArrayList<Manager> list, int order, ArrayList<Department> departmentsList) {
        if (list.size()!=0) {
            String str;
            char ch = '.';
    
            for (Manager aManager : list) {
                order++;
                if (order<10) {
                    str = "| 0";
                } else {
                    str = "| ";
                }
                str += order;

                if (list.size()==order) ch = '-';
                System.out.print(String.format("%-6s", str));
                System.out.print(aManager.toString());
                System.out.printf(" %.1f |\n", aManager.calculateSalary());
                printRowBorder(135,ch);
            }
        }
    }

    // 6.2. Hiển thị bảng lương nhân viên hiện có trong ArrayList truyền vào
    private static void printSalaryAllEmployees(ArrayList<Employee> list, int order, ArrayList<Department> departmentsList) {
        if (list.size()!=0) {
            String startStr;
            String middleStr;
            char ch = '.';
            int charNumber;

            if (order == 0) {
                middleStr = "|";
                charNumber = 119;
            } else {
                middleStr = "|               |";
                charNumber = 135;
            }
    
            for (Employee anEmployee : list) {
                order++;
                if (order<10) {
                    startStr = "| 0";
                } else {
                    startStr = "| ";
                }
                startStr += order;

                if (list.size()==order) ch = '-';

                System.out.print(String.format("%-6s", startStr));
                System.out.print(anEmployee.toString() + middleStr);
                System.out.printf(" %.1f |\n", anEmployee.calculateSalary());
                printRowBorder(charNumber,ch);
            }
        }
    }

    // 7. in Bảng lương theo thứ tự tăng dần
    private static void printSalaryAscending
    (   ArrayList<CompareSalary> salarysList,
        ArrayList<Manager> managersList,
        ArrayList<Employee> employeesList,
        ArrayList<Department> departmentsList
    )
    {
        int order = 0;
        String startStr;
        String middleStr;
        int charNumber;

        if (managersList.size() == 0) {
            middleStr = "|";
            charNumber = 119;
        } else {
            middleStr = "|               |";
            charNumber = 135;
        }

        for (CompareSalary aSalary : salarysList) {
            order++;
            if (order<10) {
                startStr = "| 0";
            } else {
                startStr = "| ";
            }
            startStr += order;
            System.out.print(String.format("%-6s", startStr));
            
            if (aSalary.isManager) {
                System.out.print(managersList.get(aSalary.index).toString());
                System.out.printf(" %.1f |\n", managersList.get(aSalary.index).calculateSalary());
            } else {
                System.out.print(employeesList.get(aSalary.index).toString() + middleStr);
                System.out.printf(" %.1f |\n", employeesList.get(aSalary.index).calculateSalary());
            }

            printRowBorder(charNumber,'-');
        }
    }

    // 8. Thoát chương trình
    private static void exit() {
        sc.close();
        System.out.println("Cảm ơn bạn đã sử dụng CHƯƠNG TRÌNH QUẢN LÝ NHÂN SỰ CÔNG TY!");
        continueApp = false;
    }

    // đọc dữ liệu các nhân viên QUẢN LÝ công ty từ file txt và trả về danh sách mảng
    private static ArrayList<Manager> readManagersDataFromFile(String fileName) {
        ArrayList<Manager> list = new ArrayList<Manager>();
        String oneLine;

        //System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try {
            File myFile = new File(fileName);
            Scanner sc = new Scanner(myFile);
            String[] a;

            while (sc.hasNextLine()) {
                oneLine = sc.nextLine();
                Manager aManager = new Manager();
                a = oneLine.split(";");

                aManager.setId(a[0]); //System.out.println(aManager.getId());
                aManager.setFullName(a[1]); //System.out.println(aManager.getFullName());
                aManager.setAge(Integer.parseInt(a[2])); //System.out.println(aManager.getAge());
                aManager.setSalaryFactor(Double.parseDouble(a[3])); //System.out.println(aManager.getSalaryFactor());

                try {
                    Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(a[4]);
                    aManager.setStartDate(startDate); //System.out.println(aManager.getStartDate());
                } catch (Exception e) {
                    System.out.println("Lỗi do ngày không đúng định dạng dd/MM/yyyy");
                    e.printStackTrace();
                }
                
                aManager.setDepartmentId(a[5]); //System.out.println(aManager.getDepartmentId());
                aManager.setVacationDays(Integer.parseInt(a[6])); //System.out.println(aManager.getVacationDays());
                aManager.setTitle(a[7]); //System.out.println(aManager.getTitle());

                list.add(aManager);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file " + fileName);
            e.printStackTrace();
        }

        return list;
    }

    // đọc dữ liệu các nhân viên công ty từ file txt và trả về danh sách mảng
    private static ArrayList<Employee> readEmployeesDataFromFile(String fileName) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        String oneLine;

        //System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try {
            File myFile = new File(fileName);
            Scanner sc = new Scanner(myFile);
            String[] a;

            while (sc.hasNextLine()) {
                oneLine = sc.nextLine();
                Employee anEmployee = new Employee();
                a = oneLine.split(";");

                anEmployee.setId(a[0]); //System.out.println(anEmployee.getId());
                anEmployee.setFullName(a[1]); //System.out.println(anEmployee.getFullName());
                anEmployee.setAge(Integer.parseInt(a[2])); //System.out.println(anEmployee.getAge());
                anEmployee.setSalaryFactor(Double.parseDouble(a[3])); //System.out.println(anEmployee.getSalaryFactor());

                try {
                    Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(a[4]);
                    anEmployee.setStartDate(startDate); //System.out.println(anEmployee.getStartDate());
                } catch (Exception e) {
                    System.out.println("Lỗi do ngày không đúng định dạng dd/MM/yyyy");
                    e.printStackTrace();
                }
                
                anEmployee.setDepartmentId(a[5]); //System.out.println(anEmployee.getDepartmentId());
                anEmployee.setVacationDays(Integer.parseInt(a[6])); //System.out.println(anEmployee.getVacationDays());
                anEmployee.setOvertimeHours(Integer.parseInt(a[7])); //System.out.println(anEmployee.getOvertimeHours());

                list.add(anEmployee);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file " + fileName);
            e.printStackTrace();
        }

        return list;
    }

    // đọc dữ liệu các nhân viên công ty từ file txt và trả về danh sách mảng
    private static ArrayList<Department> readDepartmentsDataFromFile(String fileName) {
        ArrayList<Department> list = new ArrayList<Department>();
        String oneLine;

        //System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try {
            File myFile = new File(fileName);
            Scanner sc = new Scanner(myFile);
            String[] a;

            while (sc.hasNextLine()) {
                oneLine = sc.nextLine();
                Department aDepartment = new Department();
                a = oneLine.split(";");

                aDepartment.setId(a[0]); //System.out.println(aDepartment.getId());
                aDepartment.setName(a[1]); //System.out.println(aDepartment.getName());
                aDepartment.setMembersQuantity(Integer.parseInt(a[2])); //System.out.println(aDepartment.getMembersQuantity());

                list.add(aDepartment);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file " + fileName);
            e.printStackTrace();
        }

        return list;
    }

    // Hiển thị thông điệp chào mừng + tên chương trình
    private static void viewWelcome() {
		System.out.println("\n--------------------------------------------------------------");
        System.out.println("|                    Chào mừng bạn đến với                   |");
        System.out.println("|            CHƯƠNG TRÌNH QUẢN LÝ NHÂN SỰ CÔNG TY            |");
        System.out.println("--------------------------------------------------------------");
	}

    // Hiển thị bảng điều khiển
    private static void viewControlPanel() {
		System.out.println("\n--------------------------------------------------------------");
        System.out.println("|                       BẢNG ĐIỀU KHIỂN                      |");
        System.out.println("|------------------------------------------------------------|");
        System.out.println("| 1. Hiển thị danh sách nhân viên hiện có trong công ty      |");
        System.out.println("| 2. Hiển thị các bộ phận trong công ty                      |");
        System.out.println("| 3. Hiển thị các nhân viên theo từng bộ phận                |");
        System.out.println("| 4. Thêm nhân viên mới vào công ty                          |");
        System.out.println("| 5. Tìm kiếm thông tin nhân viên theo tên                   |");
        System.out.println("| 6. Hiển thị bảng lương của nhân viên toàn công ty          |");
        System.out.println("| 7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần  |");
        System.out.println("| 8. Thoát chương trình                                      |");
        System.out.println("--------------------------------------------------------------");
    }

    // Print Row Border
    private static void printRowBorder(int n, char ch) {
        for (int i=0; i<n-1; i++) System.out.print(ch);
        System.out.println(ch);
    }

    // Hiển thị Tiêu đề Bảng chỉ có nhân viên
    private static void viewHeaderForEmployee() {
        printRowBorder(106,'-');
        System.out.print(String.format("%-6s", "| STT"));
        System.out.println(String.format
        (   Employee.ROW_FORMAT_FOR_EMPLOYEE_TABLE + "%-1s",
            "| Mã số",
            "| Họ và tên",
            "| Tuổi",
            "| H/s lương",
            "| Ngày vào làm",
            "| Mã bộ phận",
            "| Ngày phép",
            "|"
        ));
        printRowBorder(106,'-');
    }

    // Hiển thị Tiêu đề Bảng nhân viên thường + nhân viên quản lý
    private static void viewHeaderForManagers() {
        printRowBorder(122,'-');
        System.out.print(String.format("%-6s", "| STT"));
        System.out.println(String.format
        (   Employee.ROW_FORMAT_FOR_EMPLOYEE_TABLE + "%-16s%-1s",
            "| Mã số",
            "| Họ và tên",
            "| Tuổi",
            "| H/s lương",
            "| Ngày vào làm",
            "| Mã bộ phận",
            "| Ngày phép",
            "| Chức vụ ",
            "|"
        ));
        printRowBorder(122,'-');
    }

    // Hiển thị Tiêu đề Bảng chỉ có nhân viên
    private static void viewSalaryHeaderForEmployee() {
        printRowBorder(119,'-');
        System.out.print(String.format("%-6s", "| STT"));
        System.out.println(String.format
        (   Employee.ROW_FORMAT_FOR_EMPLOYEE_TABLE + "%-13s%-1s",
            "| Mã số",
            "| Họ và tên",
            "| Tuổi",
            "| H/s lương",
            "| Ngày vào làm",
            "| Mã bộ phận",
            "| Ngày phép",
            "| Lương",
            "|"
        ));
        printRowBorder(119,'-');
    }

    // Hiển thị Tiêu đề Bảng nhân viên thường + nhân viên quản lý
    private static void viewSalaryHeaderForManagers() {
        printRowBorder(135,'-');
        System.out.print(String.format("%-6s", "| STT"));
        System.out.println(String.format
        (   Employee.ROW_FORMAT_FOR_EMPLOYEE_TABLE + "%-16s%-13s%-1s",
            "| Mã số",
            "| Họ và tên",
            "| Tuổi",
            "| H/s lương",
            "| Ngày vào làm",
            "| Mã bộ phận",
            "| Ngày phép",
            "| Chức vụ ",
            "| Lương",
            "|"
        ));
        printRowBorder(135,'-');
    }

    // Hiển thị Tiêu đề Bảng bộ phận
    private static void viewHeaderForDepartments() {
        printRowBorder(67,'-');
        System.out.print(String.format("%-6s", "| STT"));
        System.out.println(String.format
        (   Department.ROW_FORMAT_FOR_DEPARTMENT_TABLE,
            "| Mã bộ phận",
            "| Tên bộ phận",
            "| Số lượng nhân viên",
            "| "
        ));
        printRowBorder(67,'-');
    }

    // Nhận số nguyên trong khoảng [min max] (inclusive / bao gồm biên) từ console:
    // nếu lỗi (exception) thì cố trả về Integer.MIN_VALUE
    private static int getIntegerWithInRangeFromConsole(String sms, String smsForInvalidInput, int min, int max) {
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
                    return Integer.MIN_VALUE;
                }
            }       
        } while (invalidInput);

        return result;
    }

    // Nhận số Double>0 từ console:
    // nếu lỗi (exception) thì cố trả về 0.0
    private static double getPostivieDoubleFromConsole(String sms, String smsForInvalidInput, double max) {
        boolean invalidInput = true;
        double result=0.0;

        do {
            System.out.print(sms);

            if (sc.hasNext()) {
                try {
                    result = sc.nextDouble();
                    sc.nextLine();
                    if (result<=0.0 || result>max) {
                        System.out.println(smsForInvalidInput);
                    } else {
                        invalidInput = false;
                    }
                } catch(Exception e) {
                    System.err.println("Lỗi do dữ liệu nhập vào không hợp lệ! Chỉ được phép nhập dũ liệu là số!");
                    sc.nextLine();
                    return 0.0;
                }
            }       
        } while (invalidInput);

        return result;
    }

    // Nhận chuỗi không rỗng từ console:
    private static String getNoBlankStringFromConsole(String sms, String smsForInvalidInput) {
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

    // Kiểm tra mã bộ phận có tồn tại hay không
    private static boolean hasDepartmentId(ArrayList<Department> departmentsList, String inputId) {
        if (departmentsList.isEmpty()) return false;

        for (Department aDepartment : departmentsList) {
            if (aDepartment.getId().equalsIgnoreCase(inputId)) return true;
        }

        return false;
    }

    // Kiểm tra mã nhân viên đã tồn tại hay chưa
    private static boolean hasStaffId(ArrayList<Manager> managersList, ArrayList<Employee> employeesList, String inputId) {
        if (managersList.isEmpty() && employeesList.isEmpty()) return false;

        for (Manager aManager : managersList) {
            if (aManager.getId().equalsIgnoreCase(inputId)) return true;
        }

        for (Employee anEmployee : employeesList) {
            if (anEmployee.getId().equalsIgnoreCase(inputId)) return true;
        }

        return false;
    }

    // Trong danh sách bộ phận: Nhập mã bộ phận, trả về tên bộ phận
    private static String getDeptNameFromInputDeptId(ArrayList<Department> departmentsList, String inputId) {
        if (departmentsList.isEmpty()) return inputId;

        for (Department aDepartment : departmentsList) {
            if (aDepartment.getId().equalsIgnoreCase(inputId)) return aDepartment.getName();
        }

        return inputId;
    }

    // Đổi chữ hoa thành chữ thường, Đổi ký tự có dấu thành không dấu
    private static String removeAccents(String str) {
        //Đổi chữ hoa thành chữ thường
        str = str.toLowerCase();
    
        //Đổi ký tự có dấu thành không dấu
        str = str.replaceAll("á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ", "a");
        str = str.replaceAll("é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ", "e");
        str = str.replaceAll("i|í|ì|ỉ|ĩ|ị", "i");
        str = str.replaceAll("ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ", "o");
        str = str.replaceAll("ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự", "u");
        str = str.replaceAll("ý|ỳ|ỷ|ỹ|ỵ", "y");
        str = str.replaceAll("đ", "d");

        return str;
    }
}