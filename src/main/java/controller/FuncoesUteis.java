/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import model.Endereco;
import org.json.JSONObject;


public class FuncoesUteis {
     public static Endereco consultarCEP(String cep) throws MalformedURLException, IOException  {
         
        cep = cep.replace("-", "").replace("_", "").trim(); 
    
         if (cep.length() != 8) return null; 
        
        Endereco ender = null;
        
        // Definir a URL do serviço ViaCEP
        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");

        // Definir a URL do serviço GOV.BR
        //URL url = new URL("https://h-apigateway.conectagov.estaleiro.serpro.gov.br/api-cep/v1/consulta/cep/" + cep);

        // Abrir conexão HTTP
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Ler a resposta
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // Converter a resposta JSON em um objeto JSONObject
        JSONObject jsonObject = new JSONObject(response.toString());

        // Exibir as informações do endereço
        if (!jsonObject.has("erro")) {                            

            ender = new Endereco();
            ender.setLogradouro(jsonObject.getString("logradouro"));
            ender.setBairro(jsonObject.getString("bairro") );
            ender.setCidade(jsonObject.getString("localidade") );
            ender.setEstado(jsonObject.getString("uf") );

        } else {
            System.out.println("CEP não encontrado.");
               
        }

        // Fechar conexão
        connection.disconnect();
        return ender;

    } 
    
    public static void consultarString(JComboBox comboBox, String textoBusca) {
        
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            String item = comboBox.getItemAt(i).toString();
            if (item.equalsIgnoreCase(textoBusca) ) { // ou item.equals(textoBusca)
                comboBox.setSelectedIndex(i);
                return;
            }
        }
        // Não encontrou. Adiciona
        comboBox.addItem(textoBusca);
        comboBox.setSelectedItem(textoBusca);
    }
       
    
    public static void mostrarFoto(JLabel lbl, Icon ic) {
        
        // Redimensionar
        ImageIcon imagem = (ImageIcon) ic;
        imagem.setImage(imagem.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        
        lbl.setText("");                
        lbl.setIcon(imagem);
    } 
    
}


