package lk.ijse.Contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

/**
 * Author: vishmee
 * Date: 1/28/25
 * Time: 9:18 AM
 * Description:
 */
public class ClientController {

    @FXML
    private TextField txtUserName;

    public VBox VBOX;
    public HBox HBOX;
    @FXML
    private AnchorPane ClientAncorpane;

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


    public void initialize() {
            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost", 7000);
                    txtArea.appendText(" Client Connected \n");
                    txtArea.appendText(" Client Started \n");

                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());

                    while (!massage.equals("exit")) {
                        massage = dataInputStream.readUTF();
                        txtArea.appendText( " Server :" + massage + "\n");
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }).start();

    }

    private void InputUserName() {

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


