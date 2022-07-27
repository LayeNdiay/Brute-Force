import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class User {
    private String email;
    private String password;

    public User(String email) {
        this.email = email;
    }

    public boolean login() throws IOException {
        String urlParameters = "login="+this.email+"&password="+this.password;
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = new URL("http://127.0.0.1:3000/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }
        if (conn.getResponseCode()==200) {
            
            return true;
        }
        return false;
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

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
