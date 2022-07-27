import java.io.IOException;
import java.sql.Timestamp;

public class ForceBruteCombinaison implements ForceBrute {

    @Override
    public void pirater(User u) {
        char combinnaison[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '0', '&', '.', ':', '!', '*', '^', ')', '(', '-', '\\', '/', ' ', };
        int nbPosition = 0;
        System.out.println("chargement... ");
        long debut = System.currentTimeMillis();
        while (true) {
            nbPosition++;
            int ArrayCombinnaison[] = new int[nbPosition];
            boolean sortie = true;

            while (sortie) {
                String password = "";
                for (int i = 0; i < ArrayCombinnaison.length; i++) {
                    password = password.concat(String.valueOf(combinnaison[ArrayCombinnaison[i]]));
                }
                u.setPassword(password);
                try {
                    if (u.login()) {
                        long fin = System.currentTimeMillis();
                        long diff = fin - debut;
                        Timestamp temps = new Timestamp(diff);
                        System.out.println("Votre mot de passe " + password + " a ete trouver en "
                                + " h : " + temps.getMinutes() + " m : " + temps.getSeconds() + " sec");
                        return;
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                for (int i = ArrayCombinnaison.length - 1; i >= 0; i--) {
                    if (ArrayCombinnaison[i] < (combinnaison.length - 1)) {
                        ArrayCombinnaison[i] = ArrayCombinnaison[i] + 1;
                        for (int j = i + 1; j < ArrayCombinnaison.length; j++) {
                            ArrayCombinnaison[j] = 0;
                        }// 2 9 27  2 10 0  B C A  
                        break;
                    }
                    if (i == 0) {
                        sortie = false;
                    }
                }

            }
        }
    }

}
