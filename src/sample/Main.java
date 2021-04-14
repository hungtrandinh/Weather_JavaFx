package sample;

import Data.Maiin;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jdk.jshell.execution.LoaderDelegate;

import java.io.IOException;


public class Main extends Application {
    public static Boolean isSplashLoaded = false;
    private double xOffset = 0;
    private double yOffset = 0;

    private static class Delta {
        double x, y;
    }
    final Delta dragDelta = new Delta();
    final BooleanProperty inDrag = new SimpleBooleanProperty(false);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("giaodien.fxml"));
        primaryStage.setScene(new Scene(root, 680, 470));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Trần Đình Hùng");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image("Anh/hung.png"));
        primaryStage.setResizable(false);



        primaryStage.show();
        root.setOnMousePressed(event -> {
            dragDelta.x = primaryStage.getX() - event.getScreenX();
            dragDelta.y = primaryStage.getY() - event.getScreenY();
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() + dragDelta.x);
            primaryStage.setY(event.getScreenY() + dragDelta.y);
            inDrag.set(true);
        });




    }



}
