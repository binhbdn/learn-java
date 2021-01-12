/* PRO192x_02_VN_Asm1_binhbdnFX06635 */

import java.util.Scanner; // Import the Scanner class

public class LuckyNumber {
    // Khai báo các hằng số
    public static final int MIN_LUCKY_NUMBER=0;
    public static final int MAX_LUCKY_NUMBER=100;

    // Khai báo các biến
    private static int totalGames = 0;  // tổng số lượt chơi
    private static int totalGuess = 0;  // tổng số lần đoán trong tất cả lượt chơi
    private static double guessAvg;     // số lần đoán trung bình để thắng một lượt chơi, đánh giá cho trong tất cả lượt chơi
    private static int bestGame=0;      // số lần đoán nhỏ nhất để thắng một lượt chơi được ghi nhận

    // Hàm main() điều khiển luồng chính của chương trình:
    public static void main(String[] args) {
        play();
        report();
    }

    // Hàm play() để thực hiện trò chơi
    private static void play() {
        int luckyNumber;                // số may mắn cần đoán trong mỗi lượt chơi
        int countGuess;                 // biến đếm số lần dự đoán trong mỗi lượt chơi
        int guessNumber;                // biến lưu trữ số mà người chơi dự đoán
        String answer;                  // biến lưu trữ câu trả lời của người chơi
        boolean foundLuckyNumber;       // == true khi tìm thấy số may mắn, == false khi chưa tìm thấy
        boolean continuePlay;           // biến logic để kiểm tra có chơi lượt tiếp theo hay không
        
        Scanner console = new Scanner(System.in);
        
        do {
            foundLuckyNumber = false;   // reset trạng thái cho lượt chơi mới
            countGuess = 0;             // reset trạng thái cho lượt chơi mới
            luckyNumber = getRandomNumber(MIN_LUCKY_NUMBER, MAX_LUCKY_NUMBER);  //tạo số may mắn cho lượt chơi mới
            
            System.out.println("--------------------GAME START--------------------");
            System.out.println("Số may mắn nằm trong khoảng từ " + MIN_LUCKY_NUMBER + " đến " + MAX_LUCKY_NUMBER);
            do {
                System.out.print("Số dự đoán của bạn? ");
                guessNumber = console.nextInt();
                countGuess++;           // tăng số lần dự đoán thêm 1
                
                // Kiểm tra Số dự đoán + Thông báo gợi ý nếu chưa đoán đúng Số may mắn:
                if (guessNumber > luckyNumber) {
                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
                } else if (guessNumber < luckyNumber) {
                    System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
                } else { // guessNumber == luckyNumber
                    System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + countGuess + " lần dự đoán.");
                    
                    foundLuckyNumber = true;
                    totalGuess += countGuess;   // cập nhật số lần dự đoán của lượt chơi này vào tổng lượt chơi
                    // cập nhật bestGame
                    if (bestGame == 0 || bestGame > countGuess) {
                        bestGame = countGuess;
                    }
                }
            } while(! foundLuckyNumber);
            
            totalGames += 1;            // tăng tổng số lượt chơi thêm 1

            // Hỏi người chơi có muốn tiếp tục chơi thêm lượt hay không:
            System.out.print("Bạn có muốn tiếp tục chơi không? (Trả lời \"y\" hoặc \"yes\" để đồng ý, Trả lời khác để kết thúc trò chơi) ");
            answer = console.next();
            continuePlay = isContinue(answer);
            
            System.out.println();
        } while(continuePlay);

        console.close();

        // Gọi hàm tính số lần đoán trung bình để thắng một lượt chơi
        updateGuessAverage();
    }

    // Hàm report() để hiển thị báo cáo 
    private static void report() {
        System.out.println("Kết quả tổng kết trò chơi:");
        System.out.println("Tổng số lần chơi                                = " + totalGames);
        System.out.println("Tổng số lần dự đoán                             = " + totalGuess);
        System.out.println("Số lần dự đoán trung bình mỗi lượt              = " + getRoundedGuessAverage());
        System.out.println("Số lần dự đoán (ít nhất) của lượt chơi tốt nhất = " + bestGame);
        System.out.println("--------------------GAME OVER--------------------");
    }

    // Hàm trả về số tự nhiên ngẫu nhiên trong khoảng [a, b] (bao gồm cả a, b)
    private static int getRandomNumber(int a, int b) {
        if (b < a) return getRandomNumber(b, a);
        return a + (int) ((b - a + 1) * Math.random());
    }

    // Hàm tính số lần đoán trung bình để thắng một lượt chơi, đánh giá cho trong tất cả lượt chơi
    private static void updateGuessAverage() {
        if (totalGames == 0) {
            throw new IllegalArgumentException("Đối số không hợp lệ do chưa thực hiện lượt chơi nào!");
        } else {
            guessAvg = 1.0 * totalGuess / totalGames;
        }
    }

    // Hàm trả về giá trị số lần đoán trung bình đã làm tròn đến một chữ số thập phân
    private static double getRoundedGuessAverage() {
        return (int)(guessAvg * 10) / 10.0;
    }

    // Hàm đánh giá câu trả lời có tiếp tục chơi hay không
    private static boolean isContinue(String answer) {
        answer = answer.toLowerCase();
        if (answer.equals("y") || answer.equals("yes")) return true;
        return false;
    }
}