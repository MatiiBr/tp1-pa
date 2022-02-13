/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Posts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Pedro
 */
public class GestorVistaPosts {
    private JDesktopPane escritorio;
    FrmPosts form;
    private static final String GET_URL = "http://jsonplaceholder.typicode.com/posts";
    //private GestorPerfil gestor; 
    
    public void openFormulario(JDesktopPane pantalla, GestorVistaPosts gestor) throws IOException {
        this.setEscritorio(pantalla);
        this.setForm(new FrmPosts(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
        this.getData();
    }

    private static void getData() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONArray posts;
            try {
                posts = new JSONArray(response.toString());
                System.out.println(posts);
            } catch (JSONException ex) {
                Logger.getLogger(GestorVistaPosts.class.getName()).log(Level.SEVERE, null, ex);
            }
            // print result
            
        } else {
            System.out.println("GET request not worked");
        }

    }
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public FrmPosts getForm() {
        return form;
    }

    public void setForm(FrmPosts form) {
        this.form = form;
    }
    
}
