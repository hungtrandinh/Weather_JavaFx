package sample;

import Data.All;
import Data.Goiytenthanhpho;
import Data.Laytentatcathanhpho;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private Label currentTimeLbl;
    @FXML
    private Label cityNameLbl;
    @FXML
    private ImageView weatherIcon;
    @FXML
    private Label descriptionLbl;
    @FXML
    private Label temperatureLbl;
    @FXML
    private Label pressureLbl;
    @FXML
    private Label humidityLbl;
    @FXML
    private Label windLbl;
    @FXML
    private Label cloudsLbl;
    @FXML
    private ImageView windIcon;
    @FXML
    private ImageView pressureIcon;
    @FXML
    private ImageView humidityIcon;
    @FXML
    private ImageView cloudsIcon;
    @FXML
    private HBox daily;
    @FXML
    private Pane pane1;
    @FXML
    private Label dateLblDay1;
    @FXML
    private ImageView weatherIconDay1;
    @FXML
    private Pane pane2;
    @FXML
    private Label temperatureLblDay1;
    @FXML
    private Label dateLblDay2;
    @FXML
    private ImageView weatherIconDay2;
    @FXML
    private Label temperatureLblDay2;
    @FXML
    private Pane pane3;
    @FXML
    private Label dateLblDay3;
    @FXML
    private ImageView weatherIconDay3;
    @FXML
    private Label temperatureLblDay3;
    @FXML
    private Pane pane4;
    @FXML
    private Label dateLblDay4;
    @FXML
    private ImageView weatherIconDay4;
    @FXML
    private Label temperatureLblDay4;
    @FXML
    private Pane pane5;
    @FXML
    private Label dateLblDay5;
    @FXML
    private ImageView weatherIconDay5;
    @FXML
    private Label temperatureLblDay5;
    @FXML
    private Pane menuBar;
    @FXML
    private Button refreshBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private TextField searchBar;



    private Socket socket;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            socket = new Socket("localhost", 3333);
            connectServer("Danang");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setincon();
        Init();
        settenthanhpho();
    }
    public void getdulieu(All all) {
        cityNameLbl.setText(String.valueOf(all.getCity().getName() + ", " + all.getCity().getCountry()));
        temperatureLbl.setText((String.valueOf(Math.round(all.getList()[0].getMain().getTemp()))));
        windLbl.setText(String.valueOf(all.getList()[0].getWind().getSpeed() + "  m/s"));
        humidityLbl.setText(String.valueOf(all.getList()[0].getMain().getHumidity() + " %"));
        pressureLbl.setText(String.valueOf(all.getList()[0].getMain().getPressure() + " mbar"));
        cloudsLbl.setText(String.valueOf(all.getList()[0].getClouds().getAll() + " %"));
        weatherIcon.setImage(new Image(("http://openweathermap.org/img/wn/" + all.getList()[0].getWeather()[0].getIcon() + ".png")));
        descriptionLbl.setText(String.valueOf(all.getList()[0].getWeather()[0].getDescription()));
        String ngay =String.valueOf(all.getList()[0].getDt_txt());
        String[] pastall = ngay.split(" ");
        String pastal= pastall[0];
        currentTimeLbl.setText(String.valueOf(pastal));
        //ngày thứ nhất
        temperatureLblDay1.setText(String.valueOf(Math.round(all.getList()[9].getMain().getTemp_min())+"°C/ "+Math.round(all.getList()[17].getMain().getTemp_max())+"°C "));
        weatherIconDay1.setImage(new Image(("http://openweathermap.org/img/wn/" + all.getList()[9].getWeather()[0].getIcon() + ".png")));
        String ngay1 =String.valueOf(all.getList()[9].getDt_txt());
        String[] past = ngay1.split(" ");
        String pasta= past[0];

        dateLblDay1.setText(String.valueOf(pasta));
        //ngày thứ 2
        temperatureLblDay2.setText(String.valueOf(Math.round(all.getList()[17].getMain().getTemp_min())+"°C/ "+Math.round(all.getList()[25].getMain().getTemp_max())+"°C "));
        weatherIconDay2.setImage(new Image(("http://openweathermap.org/img/wn/" + all.getList()[17].getWeather()[0].getIcon() + ".png")));
        String ngay2 =String.valueOf(all.getList()[17].getDt_txt());
        String[] past1 = ngay2.split(" ");
        String pastb= past1[0];
        dateLblDay2.setText(String.valueOf(pastb));
        //ngay thu 3
        temperatureLblDay3.setText(String.valueOf(Math.round(all.getList()[17].getMain().getTemp_min())+"°C/ "+Math.round(all.getList()[25].getMain().getTemp_max())+"°C "));
        weatherIconDay3.setImage(new Image(("http://openweathermap.org/img/wn/" + all.getList()[17].getWeather()[0].getIcon() + ".png")));
        String ngay3 =String.valueOf(all.getList()[25].getDt_txt());
        String[] past3 = ngay3.split(" ");
        String pastc= past3[0];
        dateLblDay3.setText(String.valueOf(pastc));
        //ngay thu 4
        temperatureLblDay4.setText(String.valueOf(Math.round(all.getList()[25].getMain().getTemp_min())+"°C/ "+Math.round(all.getList()[33].getMain().getTemp_max())+"°C "));
        weatherIconDay4.setImage(new Image(("http://openweathermap.org/img/wn/" + all.getList()[25].getWeather()[0].getIcon() + ".png")));
        String ngay4 =String.valueOf(all.getList()[33].getDt_txt());
        String[] past4 = ngay4.split(" ");
        String pastd= past4[0];
        dateLblDay4.setText(String.valueOf(pastd));
        // ngay thu 5
        temperatureLblDay5.setText(String.valueOf(Math.round(all.getList()[33].getMain().getTemp_min())+"°C/ "+Math.round(all.getList()[39].getMain().getTemp_max())+"°C "));
        weatherIconDay5.setImage(new Image(("http://openweathermap.org/img/wn/" + all.getList()[33].getWeather()[0].getIcon() + ".png")));
        String ngay5 =String.valueOf(all.getList()[39].getDt_txt());
        String[] past5 = ngay5.split(" ");
        String paste= past5[0];
        dateLblDay5.setText(String.valueOf(paste));

    }
    private void setincon() {
        pressureIcon.setImage(new Image("Anh/gauge.png"));
        humidityIcon.setImage(new Image("Anh/humidity.png"));
        windIcon.setImage(new Image("Anh/wind-sign.png"));
        cloudsIcon.setImage(new Image("Anh/cloud.png"));
        windIcon.setImage(new Image("Anh/wind-sign.png"));
    }
    @FXML
    private void search() throws IOException {
        String location = searchBar.getText();
        if (!location.equals("")){
            connectServer(location);
        }
    }
    private void connectServer(String location) throws IOException {
        try {


            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF(location);
            String nhan = dataInputStream.readUTF();
            Gson gson = new Gson();
            All all = gson.fromJson(nhan, All.class);
            getdulieu(all);
            System.out.println(all);
        }catch (Exception e){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("LỖI!");
            alert.setContentText("Bạn vui lòng nhập lại tên thành phố !");
            alert.setHeaderText("Tên thành phố bạn vừa nhập sai mất rồi");
            alert.showAndWait();



        }
    }
    void Init() {
        refreshBtn.setGraphic(new ImageView((new Image("Anh/refresh.png"))));
        refreshBtn.setStyle("-fx-background-color: #142747;");
        refreshBtn.setScaleY(0.5);
        refreshBtn.setScaleX(0.5);
        refreshBtn.setTooltip(new Tooltip("Refresh"));

        searchBtn.setGraphic(new ImageView(new Image("Anh/magnifying-glass.png")));
        searchBtn.setStyle("-fx-background-color: #142747;");
        searchBtn.setScaleY(0.7);
        searchBtn.setScaleX(0.7);
        searchBtn.setTooltip(new Tooltip("Search"));

        closeBtn.setGraphic(new ImageView(new Image("Anh/close.png")));
        closeBtn.setStyle("-fx-background-color: #142747;");
        closeBtn.setScaleY(0.8);
        closeBtn.setScaleX(0.8);
        closeBtn.setTooltip(new Tooltip("Close"));
        closeBtn.setOnMouseClicked(event -> {
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();
        });

    }
    void settenthanhpho(){
        List<Laytentatcathanhpho> listthanhpho = new Goiytenthanhpho().getTarget();
        TextFields.bindAutoCompletion(searchBar,listthanhpho);

    }

    }












