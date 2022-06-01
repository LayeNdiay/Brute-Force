import java.util.*;
import java.io.*;
import java.sql.Timestamp;
public class ForceBruteDictionnaire implements ForceBrute {
    @Override
    public void pirater(User u) {
        System.out.println("chargement... ");
        long debut = System.currentTimeMillis();
        Scanner scan;
        try {
            scan = new Scanner(new File("listCode.txt"));
            while (scan.hasNextLine()) {
                String password = scan.nextLine();
                if (u.login(password)) {
                    long fin = System.currentTimeMillis();
                    long diff = fin-debut;
                    Timestamp temps = new Timestamp(diff);
                    System.out.println("Votre mot de passe " + password + " a ete trouver en " + temps.getHours() + " h : " + temps.getMinutes()+" m : "+temps.getSeconds()+ " s");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        
    }
}
