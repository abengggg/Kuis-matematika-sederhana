import java.util.Random;
import java.util.Scanner;

public class mathQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("============ Math Quiz App ============");
        System.out.println("Selamat datang di aplikasi kuis matematika")
        System.out.println("Pilih tingkat kesulitan:");
        System.out.println("1. Mudah (1-10)");
        System.out.println("2. Sedang (10-50)");
        System.out.println("3. Sulit (50-100)");
        System.out.print("Masukkan pilihan (1/2/3): ");
        int tingkatKesulitan = scanner.nextInt();

        int angkaMin = 1, angkaMax = 10;
        if (tingkatKesulitan == 2) {
            angkaMin = 10;
            angkaMax = 50;
        } else if (tingkatKesulitan == 3) {
            angkaMin = 50;
            angkaMax = 100;
        }

        int skor = 0;
        int jumlahSoal = 5;

        for (int nomorSoal = 1; nomorSoal <= jumlahSoal; nomorSoal++) {
            int angka1 = random.nextInt(angkaMax - angkaMin + 1) + angkaMin;
            int angka2 = random.nextInt(angkaMax - angkaMin + 1) + angkaMin;
            char[] pilihanOperator = {'+', '-', '*', '/'};
            char operator = pilihanOperator[random.nextInt(4)];
            int hasilBenar = 0;

            if (operator == '+') {
                hasilBenar = angka1 + angka2;
            } else if (operator == '-') {
                hasilBenar = angka1 - angka2;
            } else if (operator == '*') {
                hasilBenar = angka1 * angka2;
            } else if (operator == '/') {
                hasilBenar = (angka2 != 0) ? (angka1 / angka2) : 0;
                angka1 = hasilBenar * angka2;
            }

            System.out.println("\nSoal " + nomorSoal + ": " + angka1 + " " + operator + " " + angka2 + " = ?");
            System.out.print("Jawaban: ");
            int jawabanUser = scanner.nextInt();

            if (jawabanUser == hasilBenar) {
                System.out.println("Benar!");
                skor++;
            } else {
                System.out.println("Salah! Jawaban yang benar: " + hasilBenar);
            }
        }

        System.out.println("\nSkor akhir kamu: " + skor + "/" + jumlahSoal);
        scanner.close();
    }
}
