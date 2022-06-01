import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez entrer votre mot de passe ");
        String mdp = sc.nextLine();
        User u = new User("name", mdp);
        u.testPassword();
        sc.close();
    }
    
}
