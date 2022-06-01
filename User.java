import java.util.Scanner;
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean login(String pass) {
        return this.password.equals(pass);
    }

    public void testPassword() {
        ForceBrute forceBrute= null;
        System.out.println("Veuillez choisir votre la methode par laquelle vous voullez \n1 Force brute classic \n2  force brute avec dictionnaire  ");
        Scanner sc = new Scanner(System.in);
        int rep = sc.nextInt();
        if (rep == 1) {
            forceBrute = FabriqueForceBrute.getInstance("Combinnaison");
        } else if (rep == 2) {
            forceBrute = FabriqueForceBrute.getInstance("Dictionaire");
        } else {
            this.testPassword();
        }
        forceBrute.pirater(this);
        sc.close(); 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
