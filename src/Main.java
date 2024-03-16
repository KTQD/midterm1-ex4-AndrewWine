import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};
        
        // Luồng 1 tính tổng các phần tử trong mảng
        Thread sumThread = new Thread(() -> {
            int sum = Arrays.stream(numbers).sum();
            System.out.println("Tổng của các phần tử trong mảng là: " + sum);
        });

        // Luồng 2 tìm phần tử lớn nhất trong mảng
        Thread maxThread = new Thread(() -> {
            int max = Arrays.stream(numbers).max().getAsInt();
            System.out.println("Phần tử lớn nhất trong mảng là: " + max);
        });

        // Khởi động các luồng
        sumThread.start();
        maxThread.start();

        // Đợi cho các luồng hoàn thành
        sumThread.join();
        maxThread.join();
    }
}
