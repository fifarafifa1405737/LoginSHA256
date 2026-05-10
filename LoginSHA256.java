import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginSHA256 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String username, password;
        String simpanUser, simpanHash;

        // Registrasi User
        System.out.println("=== REGISTRASI USER ===");
        System.out.print("Masukkan Username : ");
        username = input.nextLine();

        System.out.print("Masukkan Password : ");
        password = input.nextLine();

        // Ubah password ke hash SHA-256
        simpanHash = hashSHA256(password);
        simpanUser = username;

        // Tampilkan hasil hash
        System.out.println("\nData berhasil disimpan!");
        System.out.println("Username : " + simpanUser);
        System.out.println("Hash Password : " + simpanHash);

        // Login
        System.out.println("\n=== LOGIN USER ===");
        System.out.print("Masukkan Username : ");
        String loginUser = input.nextLine();

        System.out.print("Masukkan Password : ");
        String loginPass = input.nextLine();

        // Verifikasi Login
        String loginHash = hashSHA256(loginPass);

        if (loginUser.equals(simpanUser) && loginHash.equals(simpanHash)) {
            System.out.println("Status Login : BERHASIL");
        } else {
            System.out.println("Status Login : GAGAL");
        }

        input.close();
    }

    // Method Hash SHA-256
    public static String hashSHA256(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(text.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}