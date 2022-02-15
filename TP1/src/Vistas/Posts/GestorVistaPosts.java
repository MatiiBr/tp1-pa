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
    FrmPost form;
    private String GET_URL = "http://jsonplaceholder.typicode.com/";
    //private GestorPerfil gestor; 
    
    public void openFormulario(JDesktopPane pantalla, GestorVistaPosts gestor) throws IOException {
        this.setEscritorio(pantalla);
        this.setForm(new FrmPost(gestor));
        this.getEscritorio().add(form);
        this.getForm().setVisible(true);
        this.getData();
    }
    
    public void getData() throws IOException {
        String url = "";
        url = GET_URL + this.getForm().getCboGet().getSelectedItem().toString();
        if (this.getForm().getCboGet().getSelectedItem().toString().equals("posts") && !this.getForm().getTxtId().toString().equals("")) {
            url += "/" + this.getForm().getTxtId().getText();
        }
        URL obj = new URL(url);
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
            //posts = new JSONArray(response.toString());
//                System.out.println(posts);
            this.getForm().getAreaResultado().setText(response.toString());
            
        } else {
            System.out.println("GET request not worked");
        }

    }
    public void verificarItem(){
        if (this.getForm().getCboGet().getSelectedItem().toString()=="posts") {
            this.getForm().getTxtId().setEnabled(true);
        } else {
            this.getForm().getTxtId().setEnabled(false);

        }
    }
    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public FrmPost getForm() {
        return form;
    }

    public void setForm(FrmPost form) {
        this.form = form;
    }
    
}
