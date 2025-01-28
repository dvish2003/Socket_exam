package lk.ijse.Contollers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: vishmee
 * Date: 1/28/25
 * Time: 9:18 AM
 * Description:
 */
public class ServerController {

    public HBox HBOX;
    public VBox VBOX;
    @FXML
        private Button btnImage;

        @FXML
        private Button btnSend;

        @FXML
        private TextArea txtArea;

        @FXML
        private TextField txtMsg;
        String massage = "";
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        public void initialize(){
            new Thread(() ->{
                try {
                    ServerSocket serverSocket = new ServerSocket(7000);
                    txtArea.appendText(" Server is start.......\n");

                    Socket socket = serverSocket.accept();
                    txtArea.appendText(" Client connected \n");

                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());

                    while (!massage.equals("exit")){
                        massage = dataInputStream.readUTF();
                        txtArea.appendText(" Client : " + massage + "\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        @FXML
        void btnImageOnAction(ActionEvent event) {

        }

        @FXML
        void btnSendOnAction(ActionEvent event) throws IOException {
          dataOutputStream.writeUTF(txtMsg.getText().trim());
          txtArea.appendText(" you :"+txtMsg.getText().trim()+"\n");
          dataOutputStream.flush();
          txtMsg.clear();
        }

    }





















