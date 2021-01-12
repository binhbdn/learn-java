/* PRO192x_02_VN_Asm2_binhbdnFX06635 */

/*
Grade Student là ứng dụng cho phép người dùng nhập thông tin về điểm số của sinh viên,
sau đó hệ thống sẽ tính toán để đưa ra Grade phù hợp cho sinh viên đó
(dựa vào các giá trị đã nhập vào và quy tắc xếp loại của trường).  
*/

import java.util.Scanner; // Import the Scanner class

public class GradeStudent {
    // Khai báo các hằng số
    public static final int MAX_EXAM_SCORE=100; // điểm kỳ thi tối đa
    public static final int MAX_SHIFT=20; // điểm thưởng kỳ thi tối đa
    public static final int MAX_ASM_QUANTITY=5; // Số lượng bài tập lớn tối đa
    public static final int MAX_ASM_SCORES=150; // tổng điểm các bài tập lớn tối đa
    public static final int MAX_SECTION_POINTS=30; // điểm chuyên cần tối đa
    public static final String SMS_FOR_INVALID_INPUT="Số liệu nhập vào không hợp lệ. Vui lòng nhập lại!"; //Nội dung thông báo khi số liệu nhập vào không hợp lệ.

    // Khai báo các biến
    private static int weight; // biến lưu trữ trọng số mỗi lần nhập vào
    private static int totalWeight = 0; // tổng các trọng số (yêu cầu <=100 & bằng đúng 100 ngay sau lần nhập trọng số cuối cùng)
    private static int examScore; // biến lưu trữ điểm số kỳ thi mỗi lần nhập vào
    private static int shiftAmount; // biến lưu trữ điểm thưởng kỳ thi mỗi lần nhập vào
    private static double weightedScore; // biến lưu trữ điểm số đã tính dựa trên trọng số
    private static double overallPercentage = 0.0; // biến lưu trữ điểm phần trăm tổng thể, bằng tổng các weightedScore
    

    // Hàm main() điều khiển luồng chính của chương trình:
    public static void main(String[] args) {
        // Gọi hàm begin() để hiển thị thông điệp chào mừng:
        begin();
        // Khai báo biến kiểu Scanner dùng cho việc đọc số liệu từ người dùng nhập vào:
        Scanner sc = new Scanner(System.in);
        // Gọi hàm midtermExam() để nhập và tính toán điểm thi giữa kỳ:
        midtermExam(sc);
        // Gọi hàm finalExam() để nhập và tính toán điểm thi cuối kỳ:
        finalExam(sc);
        // Gọi hàm homework() để nhập và tính toán điểm bài tập về nhà:
        homework(sc);
        // Ngừng sử dụng biến kiểu Scanner:
        sc.close();
        // Gọi hàm report() để tính toán và hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng:
        report();
    }

    // Hàm begin() để hiển thị thông điệp chào mừng:
    private static void begin() {
        System.out.println("CHƯƠNG TRÌNH TÍNH ĐIỂM TỔNG KẾT MÔN HỌC CỦA SINH VIÊN");
        System.out.println("\t*Hãy nhập vào điểm các kỳ thi & điểm các bài tập về nhà cùng với trọng số tương ứng.");
        System.out.println("\t*Chương trình sẽ tính điểm tổng kết và đưa ra đánh giá.");
        System.out.println();
    }

    // Hàm midtermExam() để nhập và tính toán điểm thi giữa kỳ:
    private static void midtermExam(Scanner sc) {
        System.out.println("Điểm kỳ thi giữa kỳ:");
        exam(sc);
    }

    // Hàm finalExam() để nhập và tính toán điểm thi cuối kỳ:
    private static void finalExam(Scanner sc) {
        System.out.println("Điểm kỳ thi cuối kỳ:");
        exam(sc);
    }

    // Hàm exam() để nhập và tính toán điểm thi (giữa kỳ/ cuối kỳ):
    private static void exam(Scanner sc) {
        weight = getInputWeight(sc, false);
        examScore = getInputExamScore(sc);
        shiftAmount = getInputShiftAmount(sc);
        calcualteAndPrintTotalPoints();
        calcualteAndPrintWeightedScore();
        System.out.println();
    }

    // Hàm homework() để nhập và tính toán điểm bài tập về nhà:
    private static void homework(Scanner sc) {
        int assignmentQuantity; // Số lượng bài tập lớn
        int assignmentScore; // Điểm cho mỗi bài tập lớn
        int maxAssignmentScore; // Điểm tối đa cho mỗi bài tập lớn
        int totalAssignmentScores = 0; // Tổng điểm các bài tập lớn
        int maxTotalAssignmentScores = 0; // Tổng điểm các bài tập lớn tối đa có thể đạt được
        int sections; // Số lượng buổi mà sinh viên đã đi học và được điểm danh - căn cứ để tính điểm chuyên cần cho sinh viên. 
        int totalSectionPoints; // Tổng số điểm chuyên cần <= 30 (MAX_SECTION_POINTS)
        boolean isValid = false; // Biến logic điều khiển luồng do while loop
        String str; // Biến lưu trữ chuỗi thông báo

        System.out.println("Điểm bài tập về nhà:");
        weight = getInputWeight(sc, true); //true : lần nhập trọng số cuối cùng

        // Xác định số lượng bài tập lớn:
        str = "Số bài tập về nhà cần làm (1-" + MAX_ASM_QUANTITY + ") ? ";
        do {
            System.out.print(str);
            assignmentQuantity = sc.nextInt();
            if (assignmentQuantity>=1 && assignmentQuantity<=MAX_ASM_QUANTITY) {
                isValid = true; // số liệu nhập ok, thay đổi giá trị biến để thoát do while loop
            } else {
                System.out.println(SMS_FOR_INVALID_INPUT); // thông báo khi số liệu nhập vào không hợp lệ
            }
        } while(! isValid);

        // Xác định điểm đạt được & điểm tối đa cho mỗi bài tập lớn:
        for (int i=1; i<=assignmentQuantity; i++) {
            str = "Điểm đạt được (>=0) và điểm tối đa (>0) của bài assignment " + i + " ? ";
            isValid = false;

            do {
                System.out.print(str);
                assignmentScore = sc.nextInt();
                maxAssignmentScore = sc.nextInt();
                if (assignmentScore>=0 && maxAssignmentScore>0 && assignmentScore<=maxAssignmentScore) {
                    isValid = true; // số liệu nhập ok, thay đổi giá trị biến để thoát do while loop
                } else {
                    if (assignmentScore>maxAssignmentScore) {
                        System.out.println("Điểm đạt được không được phép vượt điểm tối đa!"); // thông báo khi nhập vào điểm đạt đượt bị vượt điểm tối đa
                    }
                    System.out.println(SMS_FOR_INVALID_INPUT); // thông báo chung khi số liệu nhập vào không hợp lệ
                }
            } while(! isValid);

            totalAssignmentScores += assignmentScore;
            maxTotalAssignmentScores += maxAssignmentScore;
        }

        // Kiểm tra điều kiện: Điểm tối đa của phần Assignment là 150(MAX_ASM_SCORES), nếu vượt quá thì cũng chỉ tính là 150 điểm. 
        if (totalAssignmentScores > MAX_ASM_SCORES) totalAssignmentScores = MAX_ASM_SCORES;

        // Xác định số lượng buổi học sinh viên đã đi học và được điểm danh:
        isValid = false;
        str = "Số lượng buổi học mà sinh viên đã đi học và được điểm danh? ";
        do {
            System.out.print(str);
            sections = sc.nextInt();
            if (sections>=0) {
                isValid = true; // số liệu nhập ok, thay đổi giá trị biến để thoát do while loop
            } else {
                System.out.println(SMS_FOR_INVALID_INPUT); // thông báo khi số liệu nhập vào không hợp lệ
            }
        } while(! isValid);

        // Xác định tổng số điểm chuyên cần của sinh viên:
        totalSectionPoints = sections * 5;
        // Điểm tối đa của phần Attend là 30 (MAX_SECTION_POINTS), nếu vượt quá 30 thì vẫn chỉ tính là 30. 
        if (totalSectionPoints > MAX_SECTION_POINTS) totalSectionPoints = MAX_SECTION_POINTS;
        System.out.println("Điểm chuyên cần = " + totalSectionPoints + " / " + MAX_SECTION_POINTS);

        // Xác định tổng điểm số thực tế đạt được & tối đa có thể đã đạt được:
        totalAssignmentScores += totalSectionPoints;
        maxTotalAssignmentScores += MAX_SECTION_POINTS;
        System.out.println("Tổng điểm bài tập về nhà = " + totalAssignmentScores + " / " + maxTotalAssignmentScores);

        // Xác định điểm số đã tính dựa trên trọng số:
        // chỉ tính và lấy đến phần mười (một số sau dấu chấm thập phân) :
        weightedScore = (int)((1.0 * totalAssignmentScores / maxTotalAssignmentScores) * weight * 10) / 10.0;
        System.out.println("Điểm số đã tính dựa trên trọng số = " + weightedScore + " / " + weight);
        overallPercentage += weightedScore;

        System.out.println();
    }

    // Hàm report() để tính toán và hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng:
    private static void report() {
        double minGPA; // được tính dựa vào overallPercentage
        String comment; // nhận xét
        
        System.out.println("Điểm phần trăm tổng thể = " + overallPercentage);

        // Xác định minGPA và comment dựa vào overallPercentage
        if (overallPercentage < 60) {
            minGPA = 0.0;
            comment = "Học lực kém!";
        } else if (overallPercentage < 75) {
            minGPA = 0.7;
            comment = "Học lực trung bình";
        } else if (overallPercentage < 85) {
            minGPA = 2.0;
            comment = "Học lực khá";
        } else {
            minGPA = 3.0;
            comment = "Học lực giỏi!";
        }

        System.out.println("min GPA = " + minGPA);
        System.out.println(comment);
    }

    // Hàm thông báo, cho phép người dùng nhập vào trọng số điểm
    // Hàm cũng trả về giá trị trọng số điểm vừa nhập
    // Hàm cũng cập nhật tổng trọng số điểm của các lần nhập
    private static int getInputWeight(Scanner sc, boolean isFinalInputWeight) { //Biến isFinalInputWeight==true cho lần nhập cuối cùng.
        String str = "Trọng số điểm (0-100) ? ";

        if (totalWeight==100) {
            System.out.println("Tổng trọng số đã nhập vào (các) lần trước đã đạt giá trị lớn nhất là 100!");
            str = "Trọng số điểm nhập vào bằng 0 ? (Nhập 0 để xác nhận) ";
        }

        int inputWeight;
        boolean isValid = false;

        do {
            System.out.print(str);
            inputWeight = sc.nextInt();
            // Diễn giải điều kiện trọng số hợp lệ:
            //  phải >=0 và <=100
            //  tổng các trọng số (đã nhập và nhập lần này) phải <=100
            //  nếu đây là lần nhập cuối cùng (isFinalInputWeight==true) thì tổng các trọng số (đã nhập và nhập lần này) phải ==100
            if ((inputWeight>=0) && (inputWeight<=100) && (totalWeight+inputWeight<=100) && ((! isFinalInputWeight) || (isFinalInputWeight && (totalWeight+inputWeight==100)))) {
                isValid = true;
            } else {
                if (totalWeight+inputWeight>100) {
                    System.out.println("Tổng các trọng số (đã nhập và nhập lần này) không được vượt quá 100!");
                } else if (isFinalInputWeight && (totalWeight+inputWeight<100)) {
                    System.out.println("Tổng các trọng số (đã nhập và nhập lần cuối này) phải bằng 100!");
                    System.out.println("Tổng các trọng số đã nhập lần trước = " + totalWeight);
                    System.out.println("Để thỏa mãn tổng các trọng số là 100 thì trọng số cho điểm bài tập về nhà phải là " + (100-totalWeight));
                }
                System.out.println(SMS_FOR_INVALID_INPUT); // thông báo khi số liệu nhập vào không hợp lệ
            }
        } while(! isValid);
        totalWeight += inputWeight;
        return inputWeight;
    }

    // Hàm thông báo, cho phép người dùng nhập vào điểm kỳ thi
    // Hàm cũng trả về giá trị điểm kỳ thi vừa nhập
    private static int getInputExamScore(Scanner sc) {
        String str = "Điểm thi đạt được (0-" + MAX_EXAM_SCORE + ") ? ";
        int inputExamScore;
        boolean isValid = false;

        do {
            System.out.print(str);
            inputExamScore = sc.nextInt();
            if (inputExamScore>=0 && inputExamScore<=MAX_EXAM_SCORE) {
                isValid = true;
            } else {
                System.out.println(SMS_FOR_INVALID_INPUT); // thông báo khi số liệu nhập vào không hợp lệ
            }
        } while(! isValid);
        return inputExamScore;
    }

    // Hàm hỏi người dùng có hay không điểm thưởng cho kỳ thi
    // Hàm cũng trả về giá trị điểm thưởng vừa nhập hoặc trả về 0 nếu không có điểm thưởng
    private static int getInputShiftAmount(Scanner sc) {
        //String 
        String str = "Bạn có được điểm thưởng không (chọn 1 nếu có, chọn 2 nếu không) ? ";
        int inputShiftAmount;   // khi người dùng nhập liệu, biến này bằng 1 nếu có điểm thưởng, bằng 2 nếu không
                                // sau đó biến này lưu giá trị điểm thưởng (0 - MAX_SHIFT) nếu có

        do {
            System.out.print(str);
            inputShiftAmount = sc.nextInt();
            if (inputShiftAmount==1) {
                str = "Điểm thưởng (0-" + MAX_SHIFT + ") ? ";

                do {
                    System.out.print(str);
                    inputShiftAmount = sc.nextInt();
                    if (inputShiftAmount>=0 && inputShiftAmount<=MAX_SHIFT) {
                        return inputShiftAmount; //trả về giá trị inputShiftAmount (thoát internal do while loop + thoát hàm)
                    } else {
                        System.out.println(SMS_FOR_INVALID_INPUT); // thông báo khi số liệu nhập vào không hợp lệ
                    }
                } while(true); // thoát do while loop bằng return nên không cần đặt biến boolean

                
            } else if (inputShiftAmount==2) {
                return 0; //trả về giá trị 0 (thoát external do while loop + thoát hàm)
            } else {
                System.out.println(SMS_FOR_INVALID_INPUT); // thông báo khi số liệu nhập vào không hợp lệ
            }
        } while(true); // thoát do while loop bằng return nên không cần đặt biến boolean
    }

    // Hàm tính toán và hiển thị Total points của kỳ thi:
    // Total points: là tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm,
    // điểm tối đa của total point là 100 (MAX_EXAM_SCORE)
    private static void calcualteAndPrintTotalPoints() {
        if (shiftAmount>0) {
            examScore += shiftAmount;
            if (examScore>100) examScore=100;
        }
        System.out.println("Tổng điểm (bao gồm điểm thưởng nếu có) = " + examScore + " / " + MAX_EXAM_SCORE);
    }

    // Hàm tính toán và hiển thị và trả về Weighted score của kỳ thi:
    // Weighted score: Là điểm số đã tính dựa trên trọng số.
    // Hàm cũng cập nhật điểm phần trăm tổng thể
    private static void calcualteAndPrintWeightedScore() {
        // chỉ tính và lấy đến phần mười (một số sau dấu chấm thập phân) :
        weightedScore = (int)((1.0 * examScore / MAX_EXAM_SCORE) * weight * 10) / 10.0;
        System.out.println("Điểm số đã tính dựa trên trọng số = " + weightedScore + " / " + weight);
        overallPercentage += weightedScore;
    }

}