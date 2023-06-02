/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nebras team
 */
public class APProject extends Application {

    Scene welcomeScene;
    Scene registerScene;
    Scene logInScene;
    Scene settingsScene;
    Scene playerInfoScene;
    Scene editInfoScene;
    Scene levelsScene;
    Scene level1Scene;
    Scene level2Scene;
    Scene level3Scene;
    Scene level4Scene;
    Scene level5Scene;

    String playerName;  
    ImageView rabbit;
    
    String video = "file:/C://Users//ACER//Documents//NetBeansProjects//APProject//src//video.MP4/";

    String pathcorrect = "/C://Users//ACER//Documents//NetBeansProjects//Lab1_Infographic//src//correct.m4a/";
    String pathwrong = "/C://Users//ACER//Documents//NetBeansProjects//Lab1_Infographic//src//wrong.m4a/";
    
    
    @Override
    public void start(Stage primaryStage) {

        // audio for leve1
        Media correct = new Media(new File(pathcorrect).toURI().toString() );
        MediaPlayer correctobj1 = new MediaPlayer(correct);

        Media wrong = new Media(new File(pathwrong).toURI().toString() );
        MediaPlayer wrongobj1 = new MediaPlayer(wrong);
        
        // audio for level2
        MediaPlayer correctobj2 = new MediaPlayer(correct);
        MediaPlayer wrongobj2 = new MediaPlayer(wrong);
        
        // audio for level3
        MediaPlayer correctobj3 = new MediaPlayer(correct);
        MediaPlayer wrongobj3 = new MediaPlayer(wrong);
        
        // audio for level4
        MediaPlayer correctobj4 = new MediaPlayer(correct);
        MediaPlayer wrongobj4 = new MediaPlayer(wrong);
        
        // audio for level5
        MediaPlayer correctobj5 = new MediaPlayer(correct);
        MediaPlayer wrongobj5 = new MediaPlayer(wrong);
        
        
        ////////// welcome scene ///////////
        Pane welcomeRoot = new Pane();
        welcomeRoot.setBackground(new Background(new BackgroundFill(Color.web("#fffaf0"), CornerRadii.EMPTY, Insets.EMPTY)));
        welcomeRoot.setBorder(new Border(new BorderStroke(Color.web("#eee8aa"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(8))));

        // Create the main pane
        Pane mainPane = new Pane();
        mainPane.setLayoutX(16);
        mainPane.setLayoutY(100);
        mainPane.setPrefSize(303, 355);
        mainPane.setBackground(new Background(new BackgroundFill(Color.web("#fffaf0"), new CornerRadii(20), Insets.EMPTY)));
        mainPane.setBorder(new Border(new BorderStroke(Color.web("#fffaf0"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(8))));

        // Create the start button
        Button startButton = new Button("إبدأ");                
        startButton.setLayoutX(93);
        startButton.setLayoutY(220);
        startButton.setPrefSize(120, 41);
        startButton.setStyle("-fx-background-color: #C9EDED;  -fx-background-radius: 20; -fx-border-radius: 20; -fx-border-color: #000000; -fx-border-width: 1.75;");
        startButton.setTextFill(Color.BLACK);
        startButton.setFont(new Font(18));

        // Create the image views
        ImageView welcomeRabbit = new ImageView(new Image("rabbit.png"));
        welcomeRabbit.setLayoutX(59);
        welcomeRabbit.setFitWidth(311);
        welcomeRabbit.setFitHeight(238);
        welcomeRabbit.setPreserveRatio(true);
        welcomeRabbit.setPickOnBounds(true);

        ImageView stars1 = new ImageView(new Image("stars.png"));
        stars1.setLayoutX(39);
        stars1.setLayoutY(96);
        stars1.setFitWidth(112);
        stars1.setFitHeight(126);
        stars1.setPreserveRatio(true);
        stars1.setPickOnBounds(true);

        ImageView stars = new ImageView(new Image("stars.png"));
        stars.setLayoutX(153);
        stars.setLayoutY(40);
        stars.setFitWidth(105);
        stars.setFitHeight(93);
        stars.setPreserveRatio(true);
        stars.setPickOnBounds(true);

        // Add the children to the main pane
        mainPane.getChildren().addAll(startButton, welcomeRabbit, stars1, stars);

        // Create the welcome label
        Label welcomeLabel = new Label("لنبدأ اللعب!");
        welcomeLabel.setLayoutX(113);
        welcomeLabel.setLayoutY(61);
        welcomeLabel.setFont(new Font(23));
        welcomeLabel.setTextFill(new RadialGradient(0.5, 0.5, 0.5, 0.5, 1, true, null, new Stop[]{new Stop(0, Color.web("#FF9DC9")), new Stop(1, Color.web("#B4EBFF"))}));
        welcomeLabel.setAlignment(Pos.CENTER);
        
        //rotate animation stars 1
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(stars);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setByAngle(360);
        rotate.play();
        
        //rotate animation stars 2
        RotateTransition rotate2 = new RotateTransition();
        rotate2.setNode(stars1);
        rotate2.setDuration(Duration.millis(1000));
        rotate2.setCycleCount(TranslateTransition.INDEFINITE);
        rotate2.setByAngle(360);
        rotate2.play();
        
        //translate animation rabbit
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(welcomeRabbit);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(10);
        translate.setByY(10);
        translate.setAutoReverse(true);
        translate.play();

        // Add the children to the root pane
        welcomeRoot.getChildren().addAll(mainPane, welcomeLabel);
        welcomeScene = new Scene(welcomeRoot, 335, 600);

        /////////////// register scene ///////////////
        GridPane registerRoot = new GridPane();
        registerRoot.setPrefSize(355, 600);
        registerRoot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        registerRoot.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        registerRoot.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        registerRoot.getRowConstraints().addAll(new RowConstraints(), new RowConstraints(), new RowConstraints());

        // Create the VBox
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(355, 600);
        vbox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        vbox.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        vbox.setPadding(new Insets(0, 35, 0, 35));
        vbox.setStyle("-fx-border-color: #eee8aa; -fx-border-width: 10; -fx-background-color: #fffaf0;");
        registerRoot.add(vbox, 0, 1, 2, 1);

        // Create the image view
        ImageView registerRabbit = new ImageView(new Image("nebras logo.png"));
        registerRabbit.setFitWidth(200);
        registerRabbit.setFitHeight(150);
        vbox.getChildren().add(registerRabbit);
        VBox.setMargin(registerRabbit, new Insets(20, 50, 0, 50));

        // Create the text fields
        TextField txtNameReg = new TextField();
        txtNameReg.setAlignment(Pos.CENTER);
        txtNameReg.setPromptText("الاسم");
        txtNameReg.setStyle("-fx-border-color: #ffeff3; -fx-border-width: 3;");
        txtNameReg.setPrefSize(180, 40);
        vbox.getChildren().add(txtNameReg);
        VBox.setMargin(txtNameReg, new Insets(0, 0, 20, 0));

        TextField txtEmailReg = new TextField();
        txtEmailReg.setAlignment(Pos.CENTER);
        txtEmailReg.setPromptText("البريد الالكتروني");
        txtEmailReg.setStyle("-fx-border-color: #ffeff3; -fx-border-width: 3;");
        txtEmailReg.setPrefSize(180, 40);
        vbox.getChildren().add(txtEmailReg);
        VBox.setMargin(txtEmailReg, new Insets(0, 0, 20, 0));

        PasswordField txtPasswordReg = new PasswordField();
        txtPasswordReg.setAlignment(Pos.CENTER);
        txtPasswordReg.setPromptText("كلمة السر");
        txtPasswordReg.setStyle("-fx-border-color: #ffeff3; -fx-border-width: 3;");
        txtPasswordReg.setPrefSize(180, 40);
        vbox.getChildren().add(txtPasswordReg);
        VBox.setMargin(txtPasswordReg, new Insets(0, 0, 20, 0));

        Label binding1 = new Label(" أهلا ");
        Label binding2 = new Label();
        binding1.setTextFill(Color.web("#d9b8cb"));
        binding2.textProperty().bind(txtNameReg.textProperty());
        binding2.setTextFill(Color.web("#d9b8cb"));
        HBox bindHbox = new HBox();
        bindHbox.getChildren().addAll(binding2, binding1);
        bindHbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(bindHbox);
        VBox.setMargin(bindHbox, new Insets(0, 0, 20, 0));
        
        Label msg = new Label();
        msg.setTextFill(Color.web("#d9b8cb"));        
        vbox.getChildren().add(msg);
        VBox.setMargin(bindHbox, new Insets(0, 0, 20, 0));

        // Create the buttons
        Button btnRegi = new Button("إنشاء حساب");
        btnRegi.setTextFill(Color.web("#000000"));
        btnRegi.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-color: #eee8aa; -fx-border-radius: 20; -fx-border-width: 1.75;");
        btnRegi.setPrefSize(120, 40);
        vbox.getChildren().add(btnRegi);
        VBox.setMargin(btnRegi, new Insets(0, 10, 20, 0));

        Button btnMain = new Button("الصفحة الرئيسية");
        btnMain.setTextFill(Color.web("#000000"));
        btnMain.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-color: #eee8aa; -fx-border-radius: 20; -fx-border-width: 1.75;");
        btnMain.setPrefSize(120, 40);
        vbox.getChildren().add(btnMain);
        VBox.setMargin(btnMain, new Insets(0, 10, 20, 0));

        Button btnLogin = new Button("هل لديك حساب بالفعل؟ تسجيل الدخول");

        btnLogin.setTextFill(Color.web("000000"));
        btnLogin.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-color: #eee8aa; -fx-border-radius: 20; -fx-border-width: 1.75;");
        btnLogin.setPrefSize(240, 40);
        vbox.getChildren().add(btnLogin);
        VBox.setMargin(btnLogin, new Insets(0, 10, 60, 0));

        // Create the scene and set the stage
        registerScene = new Scene(registerRoot, 335, 600);

        ///////////// logIn scene /////////////
        // create GridPane
        GridPane logInRoot = new GridPane();

        logInRoot.setPrefSize(335, 600);
        logInRoot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        logInRoot.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        logInRoot.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        logInRoot.getRowConstraints().addAll(new RowConstraints(), new RowConstraints(), new RowConstraints());

        // create VBox
        VBox vBox = new VBox();
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefWidth(355);
        vBox.setPrefHeight(600);
        vBox.setPadding(new Insets(0, 35, 0, 35));
        vBox.setStyle("-fx-border-color: #eee8aa; -fx-border-width: 10; -fx-background-color: #fffaf0;");
        logInRoot.add(vBox, 0, 1, 2, 1);

        // create ImageView
        ImageView logInRabbit = new ImageView(new Image("nebras logo.png"));
        logInRabbit.setFitWidth(200.0);
        logInRabbit.setFitHeight(150.0);
        logInRabbit.setPreserveRatio(true);
        vBox.getChildren().add(logInRabbit);
        VBox.setMargin(logInRabbit, new Insets(40.0, 0, 0, 0));

        // create TextFields
        TextField txtNameLog = new TextField();
        txtNameLog.setPrefWidth(180.0);
        txtNameLog.setPrefHeight(40.0);
        txtNameLog.setPromptText("الاسم");
        txtNameLog.setStyle("-fx-border-color: #ffeff3; -fx-border-width: 3;");
        vBox.getChildren().add(txtNameLog);
        VBox.setMargin(txtNameLog, new Insets(0, 0, 20.0, 0));

        PasswordField txtPasswordLog = new PasswordField();
        txtPasswordLog.setPrefWidth(180.0);
        txtPasswordLog.setPrefHeight(40.0);
        txtPasswordLog.setPromptText("كلمة السر");
        txtPasswordLog.setStyle("-fx-border-color: #ffeff3; -fx-border-width: 3;");
        vBox.getChildren().add(txtPasswordLog);
        VBox.setMargin(txtPasswordLog, new Insets(0, 0, 33.0, 0));

        Label msg2 = new Label();
        msg2.setTextFill(Color.web("#d9b8cb"));        
        vbox.getChildren().add(msg2);
        VBox.setMargin(bindHbox, new Insets(0, 0, 20, 0));
        vBox.getChildren().add(msg2);
        
        // create Buttons        
        Button btnLoginScene = new Button();
        btnLoginScene.setPrefWidth(120.0);
        btnLoginScene.setPrefHeight(40.0);
        btnLoginScene.setText("تسجيل الدخول");
        btnLoginScene.setTextFill(Color.web("#000000"));
        btnLoginScene.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-color: #eee8aa; -fx-border-radius: 20; -fx-border-width: 1.75;");
        vBox.getChildren().add(btnLoginScene);
        VBox.setMargin(btnLoginScene, new Insets(0, 10.0, 20.0, 0));

        Button btnMainlogIn = new Button();
        btnMainlogIn.setPrefWidth(120.0);
        btnMainlogIn.setPrefHeight(40.0);
        btnMainlogIn.setText("الصفحة الرئيسية");
        btnMainlogIn.setTextFill(Color.web("#000000"));
        btnMainlogIn.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-color: #eee8aa; -fx-border-radius: 20; -fx-border-width: 1.75;");
        vBox.getChildren().add(btnMainlogIn);
        VBox.setMargin(btnMainlogIn, new Insets(0, 10.0, 20.0, 0));

        logInScene = new Scene(logInRoot, 335, 600);

        ///////////////// settings scene /////////////////
        // Create the GridPane layout
        GridPane settingsRoot = new GridPane();
        settingsRoot.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        settingsRoot.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        settingsRoot.getColumnConstraints().addAll(new ColumnConstraints(), new ColumnConstraints());
        settingsRoot.getRowConstraints().addAll(new RowConstraints(), new RowConstraints(), new RowConstraints());
        settingsRoot.setPrefSize(355, 600);

        // Add the VBox container
        VBox setVbox = new VBox();
        setVbox.setPrefWidth(355);
        setVbox.setPrefHeight(600);
        setVbox.setStyle("-fx-background-color: #fffaf0; -fx-border-color: #eee8aa; -fx-border-width: 8;");
        settingsRoot.add(setVbox, 1, 0, 1, 3);

        // Add the content to the VBox
        ImageView logoImageView = new ImageView(new Image("settings.png"));
        logoImageView.setFitHeight(90);
        logoImageView.setFitWidth(100);
        logoImageView.setPickOnBounds(true);
        logoImageView.setPreserveRatio(true);
        VBox.setMargin(logoImageView, new Insets(0, 0, 0, 125));
        setVbox.getChildren().add(logoImageView);

        ImageView settingsRabbit = new ImageView(new Image("rabbit.png"));
        settingsRabbit.setFitHeight(170);
        settingsRabbit.setFitWidth(350);
        settingsRabbit.setPreserveRatio(true);
        VBox.setMargin(settingsRabbit, new Insets(-100, 0, 0, 0));
        setVbox.getChildren().add(settingsRabbit);

        Text titleText = new Text("الإعدادات");
        titleText.setFill(javafx.scene.paint.Color.valueOf("#fff9ff"));
        titleText.setFont(Font.font("System", FontWeight.NORMAL, 20));
        titleText.setStroke(javafx.scene.paint.Color.valueOf("#161516"));
        titleText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titleText.setStrokeWidth(2.0);
        VBox.setMargin(titleText, new Insets(-150, 0, 0, 200));
        setVbox.getChildren().add(titleText);

        ImageView starImageView = new ImageView(new Image("stars.png"));
        starImageView.setFitHeight(150);
        starImageView.setFitWidth(100);
        starImageView.setPickOnBounds(true);
        starImageView.setPreserveRatio(true);
        VBox.setMargin(starImageView, new Insets(-13, 0, 0, 190));
        setVbox.getChildren().add(starImageView);

        Button btnProfile = new Button("حسابي");
        btnProfile.setId("btnProfile");
        btnProfile.setTextFill(Color.web("000000"));
        btnProfile.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        btnProfile.setMnemonicParsing(false);
        btnProfile.setPrefHeight(38);
        btnProfile.setPrefWidth(121);
        btnProfile.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-color: #eee8aa; -fx-border-width: 1.75; -fx-border-radius: 20;");
        btnProfile.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        btnProfile.setTextFill(javafx.scene.paint.Color.valueOf("#d9b8cb"));
        VBox.setMargin(btnProfile, new Insets(60, 0, 0, 110));
        setVbox.getChildren().add(btnProfile);

        Button btnwho = new Button("من نحن؟");
        btnwho.setId("btnWho");
        btnwho.setTextFill(Color.web("000000"));
        btnwho.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        btnwho.setMnemonicParsing(false);

        btnwho.setPrefHeight(38);
        btnwho.setPrefWidth(121);
        btnwho.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-color: #eee8aa; -fx-border-width: 1.75; -fx-border-radius: 20;");
        btnwho.setTextFill(javafx.scene.paint.Color.valueOf("#d9b8cb"));
        VBox.setMargin(btnwho, new Insets(20, 0, 0, 110));
        setVbox.getChildren().add(btnwho);

        ImageView arrowImageView = new ImageView(new Image("home.png"));
        arrowImageView.setFitHeight(50);
        arrowImageView.setFitWidth(40);
        arrowImageView.setPickOnBounds(true);
        arrowImageView.setPreserveRatio(true);
        VBox.setMargin(arrowImageView, new Insets(60, 0, 0, 150));
        setVbox.getChildren().add(arrowImageView);

        Button settingHomeBtn = new Button("معلومات الحساب");
        settingHomeBtn.setId("btnMain");
        settingHomeBtn.setTextFill(Color.web("000000"));
        settingHomeBtn.setMnemonicParsing(false);
        settingHomeBtn.setPrefHeight(29);
        settingHomeBtn.setPrefWidth(156);
        settingHomeBtn.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-radius: 20; -fx-border-color: #eee8aa; -fx-border-width: 1.75;");
        settingHomeBtn.setTextFill(javafx.scene.paint.Color.valueOf("#d9b8cb"));
        VBox.setMargin(settingHomeBtn, new Insets(15, 0, 0, 90));
        setVbox.getChildren().add(settingHomeBtn);

        Button btnLogout = new Button("تسجيل الخروج");
        btnLogout.setId("btnLogout");
        btnLogout.setTextFill(Color.web("000000"));
        btnLogout.setMnemonicParsing(false);
        btnLogout.setPrefHeight(29);
        btnLogout.setPrefWidth(156);
        btnLogout.setStyle("-fx-background-color: #ffeff3; -fx-background-radius: 20; -fx-border-radius: 20; -fx-border-color: #eee8aa; -fx-border-width: 1.75;");
        btnLogout.setTextFill(javafx.scene.paint.Color.valueOf("#d9b8cb"));
        VBox.setMargin(btnLogout, new Insets(15, 0, 0, 90));
        setVbox.getChildren().add(btnLogout);

        settingsScene = new Scene(settingsRoot, 335, 600);
        
        ///////////// who we are scene /////////////
        // Create the VBox
        VBox vboxHWA = new VBox();
        vboxHWA.setPrefSize(355, 400);
        vboxHWA.setStyle("-fx-background-color: fffaf0; -fx-border-color: eee8aa; -fx-border-width: 9;");

        // Create the button
        Button btnClose = new Button("X");
        btnClose.setFont(Font.font("System Bold", 24));
        btnClose.setStyle("-fx-background-color: #ffeff3; -fx-border-color: #eee8aa; -fx-border-width: 5; -fx-border-radius: 20; -fx-background-radius: 20;");
        btnClose.setTextFill(javafx.scene.paint.Color.web("#e2a4b3"));

        // Create the first label
        Label labelHWA= new Label("نبراس هو تطبيق يهدف لتعليم الأطفال عن طريق دمج العلوم باللعب، مما يجعل عملية التعليم أكثر متعة ومرحًا.");
        labelHWA.setPadding(new Insets(150, 20, 10, 20));
        labelHWA.setWrapText(true);
        labelHWA.setStyle("-fx-text-fill: #e2a4b3; -fx-font-size: 24px;");


        // Add the button and labels to the VBox
        vboxHWA.getChildren().addAll(btnClose, labelHWA);

        // Create the border pane
        BorderPane HWAroot = new BorderPane();
        HWAroot.setCenter(vboxHWA);


        // Create the scene and set it on the stage
        Scene HWAScene = new Scene(HWAroot, 335, 600);

        //-----------------------------Player Info Scene--------------------------
        // Create the VBox for the top section
        VBox topVBox = new VBox();
        topVBox.setStyle("-fx-background-color: #fffaf0; -fx-border-width: 8; -fx-border-color: #eee8aa;");
        topVBox.setPrefHeight(200);
        topVBox.setPrefWidth(100);

        // Create the VBox for the middle section
        VBox middleVBox = new VBox();
        middleVBox.setStyle("-fx-background-color: #fffaf0; -fx-border-width: 8; -fx-border-color: #eee8aa;");
//        middleVBox.setPadding(new Insets(20, 20, 20, 15));
        middleVBox.setPrefSize(335, 600);
        middleVBox.setAlignment(Pos.CENTER);
        middleVBox.setSpacing(13);

       
        Label playerInfoLabel = new Label("معلومات اللاعب");
        Reflection ref = new Reflection();
        ref.setFraction(0.5);
        playerInfoLabel.setEffect(ref);
        playerInfoLabel.setTextAlignment(TextAlignment.LEFT);
        playerInfoLabel.setFont(new Font("System", 42.0));
        playerInfoLabel.setTextFill(Color.BLACK);

        // Create the ImageView for the middle section
        ImageView middleImageView = new ImageView(new Image("rabbit.png"));
        middleImageView.setFitHeight(144);
        middleImageView.setFitWidth(163);
        middleImageView.setPreserveRatio(true);
        middleImageView.setPickOnBounds(true);
//        middleImageView.setTranslateX(90);
//        middleImageView.setTranslateY(30);

        // Create the Labels for the middle section
        Label emailLabel = new Label("البريد الإلكتروني: ");
        Label emailDB = new Label();        
        emailLabel.setAlignment(Pos.CENTER_RIGHT);
        emailLabel.setPadding(new Insets(10, 0, 0, 0));
        HBox emailHbox = new HBox(15);
        emailHbox.setPrefWidth(300);
        emailHbox.setPrefHeight(39);
        emailHbox.setStyle("-fx-background-color: #eec2b9;");
        emailHbox.setAlignment(Pos.CENTER_RIGHT);
        emailHbox.setPadding(new Insets(0, 7, 0,0));
        emailHbox.getChildren().addAll(emailDB, emailLabel);

        Label passwordLabel = new Label("كلمة المرور: ");
        Label passwordDB = new Label();       
        passwordLabel.setAlignment(Pos.CENTER_RIGHT);
        HBox passwordHbox = new HBox(15);
        passwordHbox.setPrefWidth(300);
        passwordHbox.setPrefHeight(39);
        passwordHbox.setStyle("-fx-background-color: #eec2b9;");
        passwordHbox.setAlignment(Pos.CENTER_RIGHT);
        passwordHbox.setPadding(new Insets(0, 7, 0,0));
        passwordHbox.getChildren().addAll( passwordDB, passwordLabel);

        Label pointsLabel = new Label("مجموع النقاط: ");
        Label pointsDB = new Label();       
        pointsLabel.setAlignment(Pos.CENTER_RIGHT);
        pointsLabel.setPadding(new Insets(0, 0, 10, 0));
        HBox pointsHbox = new HBox(15);
        pointsHbox.setAlignment(Pos.CENTER_RIGHT);
        pointsHbox.setPadding(new Insets(0, 7, 0,0));
        pointsHbox.setPrefWidth(300);
        pointsHbox.setPrefHeight(39);
        pointsHbox.setStyle("-fx-background-color: #eec2b9;");
        pointsHbox.getChildren().addAll(pointsDB, pointsLabel );

        // Create the Button for the top section
        Button topButton = new Button("المستويات");
        topButton.setPrefHeight(46);
        topButton.setPrefWidth(133);
        topButton.setStyle("-fx-background-color: #f3d078; -fx-border-color: #ffffff; -fx-border-width: 1.5; -fx-border-radius: 20px; -fx-background-radius: 22px; -fx-font-family: Dubai; -fx-font-size: 15; -fx-font-weight: bold; -fx-font-color: #ffffff");
//        topButton.setTranslateX(100);
//        topButton.setTranslateY(30);

        // Add the Rectangle, ImageView, and Labels to the middle VBox
        middleVBox.getChildren().addAll(playerInfoLabel, middleImageView, emailHbox, passwordHbox, pointsHbox, topButton);

        // Create the BorderPane for the scene
        BorderPane playerInfoRoot = new BorderPane();
        playerInfoRoot.setCenter(middleVBox);

        playerInfoScene = new Scene(playerInfoRoot, 335, 600);

//-----------------------------Edit info scene-----------------------------------

        // Create UI components
        Label editScene = new Label("تعديل المعلومات");
        editScene.setFont(new Font("System", 32.0));
        editScene.setTextFill(Color.BLACK);

        BorderPane editInfoRoot = new BorderPane();
       
        ImageView editInfiRabbit = new ImageView(new Image("rabbit.png"));
        editInfiRabbit.setFitHeight(200);
        editInfiRabbit.setFitWidth(180);
        editInfiRabbit.setPreserveRatio(true);
        VBox.setMargin(editInfiRabbit, new Insets(10, 0, 0, 0));

        Text usernameLabel = new Text("اسم المستخدم: ");
        TextField usernameField = new TextField(" ");
        usernameField.setOpacity(0.3);
        usernameField.setStyle("-fx-background-color: #f3d078;");
        HBox usernameBox = new HBox(usernameField, usernameLabel);
        usernameBox.setPrefHeight(30);
        usernameBox.setPrefWidth(326);

        usernameBox.setPadding(new Insets(10, 0, 0, 20));
        
        Text emailLabell = new Text("البريد الإلكتروني: ");
        TextField emailFieldd = new TextField(" ");
        emailFieldd.setOpacity(0.3);
        emailFieldd.setStyle("-fx-background-color: #eec2b9;");
        HBox emailBoxx = new HBox(emailFieldd, emailLabell);
        emailBoxx.setPrefHeight(30);
        emailBoxx.setPrefWidth(326);

        emailBoxx.setPadding(new Insets(20, 0, 0, 20));

        Text passwordLabell = new Text("كلمة المرور: ");
        PasswordField passwordFieldd = new PasswordField();
        passwordFieldd.setOpacity(0.3);
        passwordFieldd.setStyle("-fx-background-color: #a66da4;");
        HBox passwordBoxx = new HBox(passwordFieldd, passwordLabell);
        passwordBoxx.setPrefHeight(30);
        passwordBoxx.setPrefWidth(326);
        passwordBoxx.setPadding(new Insets(20, 0, 0, 20));

        Button saveButton = new Button("حفظ");
        saveButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        saveButton.setPrefHeight(45);
        saveButton.setPrefWidth(90);
        saveButton.setStyle("-fx-background-color: #eec2b9; -fx-border-color: #000000; -fx-border-width: 1.5; -fx-border-radius: 20px; -fx-background-radius: 22px; -fx-font-family: Dubai; -fx-font-size: 22; -fx-font-weight: bold;");
        saveButton.setFont(new Font("Arial", 24));
        VBox.setMargin(saveButton, new Insets(20));
        
        Button backButton10 = new Button("<");
        backButton10.setLayoutX(31.0);
        backButton10.setLayoutY(31.0);
        backButton10.setPrefSize(34.0, 35.0);
        backButton10.setAlignment(Pos.CENTER);
        backButton10.setPadding(new Insets(0, 20, 0, 0));
        backButton10.setStyle("-fx-background-color: #f3d078; -fx-border-width: 1.75; -fx-border-color: BLACK; -fx-background-radius: 10; -fx-border-radius: 10;");
        editInfoRoot.setTop(backButton10);
        
        // Create the root node and add the UI components
        VBox vbox2 = new VBox(editScene, editInfiRabbit, usernameBox, emailBoxx, passwordBoxx, saveButton);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setPrefHeight(200);
        vbox2.setPrefWidth(100);
//        vbox2.setStyle("-fx-background-color: #fffaf0; -fx-border-width: 8; -fx-border-color: #eee8aa;");
        editInfoRoot.setCenter(vbox2);
        editInfoRoot.setStyle("-fx-background-color: #fffaf0; -fx-border-width: 8; -fx-border-color: #eee8aa;");
        
        editInfoScene  = new Scene(editInfoRoot, 335, 600);
    
        /////////// levels scene ///////////
        AnchorPane levelsRoot = new AnchorPane();
        levelsRoot.setStyle("-fx-background-color: #fffaf0; -fx-border-color: #eee8aa; -fx-border-width: 8;");

        VBox levelsVbox = new VBox();
        levelsVbox.setAlignment(Pos.CENTER);
        levelsVbox.setLayoutX(64.0);
        levelsVbox.setLayoutY(87.0);
        levelsVbox.setPrefHeight(438.0);
        levelsVbox.setPrefWidth(207.0);
        levelsVbox.setSpacing(20.0);

        Button backButton = new Button("<");
        backButton.setLayoutX(31.0);
        backButton.setLayoutY(31.0);
        backButton.setPrefSize(34.0, 35.0);
        backButton.setStyle("-fx-background-color: #f3d078; -fx-border-width: 1.75; -fx-border-color: BLACK; -fx-background-radius: 10; -fx-border-radius: 10;");

        ImageView goToSettings = new ImageView(new Image("setting.png"));
        goToSettings.setLayoutX(275.0);
        goToSettings.setLayoutY(31.0);
        goToSettings.setFitHeight(31);
        goToSettings.setFitWidth(31);
        goToSettings.setStyle("-fx-background-color: #f3d078; -fx-border-width: 1.75; -fx-border-color: BLACK; -fx-background-radius: 10; -fx-border-radius: 10;");
        
        ImageView levelsRabbit = new ImageView(new Image("nebras logo.png"));
        levelsRabbit.setFitHeight(200.0);
        levelsRabbit.setFitWidth(150.0);
        levelsRabbit.setPickOnBounds(true);
        levelsRabbit.setPreserveRatio(true);
        
        Label msg3 = new Label();
        msg3.setTextFill(Color.web("#f3d078"));        
        
        Button button1 = new Button("المستوى الأول");
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(38.0);
        button1.setPrefWidth(145.0);
        button1.setStyle("-fx-background-color: #eec2b9; -fx-border-width: 1.75; -fx-border-color: #000000; -fx-border-radius: 20; -fx-background-radius: 20;");
        button1.setTextAlignment(TextAlignment.CENTER);

        Button button2 = new Button("المستوى الثاني");
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(38.0);
        button2.setPrefWidth(145.0);
        button2.setStyle("-fx-background-color: #81d9e3; -fx-border-width: 1.75; -fx-border-color: #000000; -fx-border-radius: 20; -fx-background-radius: 20;");
        button2.setTextAlignment(TextAlignment.CENTER);
//        button2.setVisible(false);

        Button button3 = new Button("المستوى الثالث");
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(38.0);
        button3.setPrefWidth(145.0);
        button3.setStyle("-fx-background-color: #f3d078; -fx-border-width: 1.75; -fx-border-color: #000000; -fx-border-radius: 20; -fx-background-radius: 20;");
        button3.setTextAlignment(TextAlignment.CENTER);
//        button3.setVisible(false);

        Button button4 = new Button("المستوى الرابع");
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(38.0);
        button4.setPrefWidth(145.0);
        button4.setStyle("-fx-background-color: #ceb4d1; -fx-border-width: 1.75; -fx-border-color: #000000; -fx-border-radius: 20; -fx-background-radius: 20;");
        button4.setTextAlignment(TextAlignment.CENTER);
//        button4.setVisible(false);

        Button button5 = new Button("المستوى الخامس");
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(38.0);
        button5.setPrefWidth(145.0);
        button5.setStyle("-fx-background-color: #57C5B6; -fx-border-width: 1.75; -fx-border-color: #000000; -fx-border-radius: 20; -fx-background-radius: 20;");
        button5.setTextAlignment(TextAlignment.CENTER);
//        button5.setVisible(false);

        levelsVbox.getChildren().addAll(levelsRabbit, msg3, button1, button2, button3, button4, button5);
        levelsRoot.getChildren().addAll(backButton, goToSettings, levelsVbox);

        levelsScene = new Scene(levelsRoot, 335, 600);

        /////////////// level1 scene //////////////
        Button nextButton1 = new Button("التالي");
        nextButton1.setStyle("-fx-background-color: #f3d078; -fx-border-width: 1.75; -fx-border-color: BLACK; -fx-background-radius: 10; -fx-border-radius: 10;");
        nextButton1.setLayoutX(200.0);
        nextButton1.setLayoutY(265.0);
        nextButton1.setPrefSize(70.0, 35.0);
        nextButton1.setVisible(false);

        Button backButton1 = new Button("<");
        backButton1.setLayoutX(31.0);
        backButton1.setLayoutY(31.0);
        backButton1.setPrefSize(34.0, 35.0);
        backButton1.setStyle("-fx-background-color: #f3d078; -fx-border-width: 1.75; -fx-border-color: BLACK; -fx-background-radius: 10; -fx-border-radius: 10;");

        AnchorPane level1root = new AnchorPane();
        level1root.setPrefSize(335.0, 600.0);
        level1root.setStyle("-fx-background-color: #fffaf0; -fx-border-color: #eee8aa; -fx-border-width: 8;");

        AnchorPane pane = new AnchorPane();
        pane.setLayoutX(35.0);
        pane.setLayoutY(259.0);
        pane.setPrefSize(258.0, 233.0);

        Label label = new Label("أين تقع قبلة المسلمين؟");
        label.setLayoutX(52.0);
        label.setLayoutY(131.0);
        label.setFont(new Font(24.0));

        Image image = new Image("map.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(261.0);
        imageView.setFitHeight(231.0);
        imageView.setLayoutX(7.0);
        imageView.setLayoutY(1.0);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);

        Rectangle makkah = new Rectangle(132.0, 131.0, 8.0, 11.0);
        makkah.setFill(Color.rgb(33, 255, 37, 0.0));
        makkah.setStroke(Color.TRANSPARENT);
        makkah.setStrokeType(null);

        Rectangle false1 = new Rectangle(259.0, 129.0);
        false1.setLayoutY(1.0);
        false1.setFill(Color.rgb(31, 147, 255, 0.0));
        false1.setStroke(Color.TRANSPARENT);
        false1.setStrokeType(null);

        Rectangle false2 = new Rectangle(270.0, 87.0);
        false2.setLayoutX(-1.0);
        false2.setLayoutY(143.0);
        false2.setFill(Color.rgb(31, 147, 255, 0.0));
        false2.setStroke(Color.TRANSPARENT);
        false2.setStrokeType(null);

        Rectangle false3 = new Rectangle(130.0, 21.0);
        false3.setLayoutX(140.0);
        false3.setLayoutY(126.0);
        false3.setFill(Color.rgb(31, 147, 255, 0.0));
        false3.setStroke(Color.TRANSPARENT);
        false3.setStrokeType(null);

        Rectangle false4 = new Rectangle(130.0, 21.0);
        false4.setLayoutY(126.0);
        false4.setFill(Color.rgb(31, 147, 255, 0.0));
        false4.setStroke(Color.TRANSPARENT);
        false4.setStrokeType(null);

        pane.getChildren().addAll(imageView, makkah, false1, false2, false3, false4, nextButton1);

        level1root.getChildren().addAll(pane, label, backButton1);

        level1Scene = new Scene(level1root, 335, 600);

        //-----------------------------level2-----------------------------------
    
        BorderPane level2Root = new BorderPane();
        level2Root.setPrefSize(335, 600);
        level2Root.setStyle("-fx-background-color: #fffaf0; -fx-border-color: #eee8aa; -fx-border-width: 8;");

        // Top region
        Label accountLabel = new Label("حسابي");
        accountLabel.setFont(Font.font("Comic Sans MS Bold", 20));
        BorderPane.setMargin(accountLabel, new Insets(20, 20, 0, 0));
        BorderPane.setAlignment(accountLabel, javafx.geometry.Pos.TOP_RIGHT);
        level2Root.setTop(accountLabel);
        

        // Center region
        Text questionText = new Text("الساعة تشير إلى الثالثة وخمس وخمسين دقيقة، كم يكون الوقت لو احتل عقرب الساعات محل عقرب الدقائق؟");
        // the time if the hour hand was in the place of the minute hand?");
        questionText.setFont(Font.font("Dubai Bold", 19));
        questionText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        questionText.setWrappingWidth(308.0771789550781);
        BorderPane.setMargin(questionText, new Insets(20, 0, 0, 0));
        
        
        ImageView clock = new ImageView(new Image("clock.png"));
        clock.setFitHeight(100);
        clock.setFitWidth(100);
        
        VBox clockVbox = new VBox(25);
        clockVbox.getChildren().addAll(questionText, clock);
        clockVbox.setAlignment(Pos.CENTER);
        level2Root.setCenter(clockVbox);
        
        // Bottom region
        VBox level2box = new VBox();
        GridPane leve2grid = new GridPane();
        leve2grid.setPrefSize(400, 255);
        leve2grid.setAlignment(javafx.geometry.Pos.CENTER);
        leve2grid.setHgap(10);
        leve2grid.setVgap(10);

        Button choice = new Button("11:15");
        choice.setFont(Font.font("Comic Sans MS Bold", 22));
        choice.setStyle("-fx-background-color: #eec2b9; -fx-border-color: #ffffff; -fx-border-width: 1.75; -fx-border-radius: 20px; -fx-background-radius: 22px;");
        choice.setPrefSize(104, 51);
        choice.setAlignment(javafx.geometry.Pos.CENTER);
        GridPane.setRowIndex(choice, 0);
        GridPane.setColumnIndex(choice, 0);
        GridPane.setMargin(choice, new Insets(0, 0, 0, 0));
        leve2grid.getChildren().add(choice);

        Button choice2 = new Button("12:05");
        choice2.setFont(Font.font("Comic Sans MS Bold", 22));
        choice2.setStyle("-fx-background-color: #eec2b9; -fx-border-color: #ffffff; -fx-border-width: 1.75; -fx-border-radius: 20px; -fx-background-radius: 22px;");
        choice2.setPrefSize(104, 51);
        choice2.setAlignment(javafx.geometry.Pos.CENTER);
        GridPane.setRowIndex(choice2, 0);
        GridPane.setColumnIndex(choice2, 1);
        GridPane.setMargin(choice2, new Insets(0, 0, 0, 0));
        leve2grid.getChildren().add(choice2);

        Button choice3 = new Button("2:59");
        choice3.setFont(Font.font("Comic Sans MS Bold", 22));
        choice3.setStyle("-fx-background-color: #eec2b9; -fx-border-color: #ffffff; -fx-border-width: 1.75; -fx-border-radius: 20px; -fx-background-radius: 22px;");
        choice3.setPrefSize(104, 51);
        choice3.setAlignment(javafx.geometry.Pos.CENTER);
        GridPane.setRowIndex(choice3, 1);
        GridPane.setColumnIndex(choice3, 0);
        GridPane.setMargin(choice3, new Insets(10, 0, 0, 0));
        leve2grid.getChildren().add(choice3);
        
        Button choice4 = new Button("3:55");
        choice4.setFont(Font.font("Comic Sans MS Bold", 22));
        choice4.setStyle("-fx-background-color: #eec2b9; -fx-border-color: #ffffff; -fx-border-width: 1.75; -fx-border-radius: 20px; -fx-background-radius: 22px;");
        choice4.setPrefSize(104, 51);
        choice4.setAlignment(javafx.geometry.Pos.CENTER);
        GridPane.setRowIndex(choice4, 1);
        GridPane.setColumnIndex(choice4, 1);
        GridPane.setMargin(choice4, new Insets(10, 0, 0, 0));
        leve2grid.getChildren().add(choice4);       
        
        Button nextButton2 = new Button("التالي");
        nextButton2.setLayoutX(21);
        nextButton2.setLayoutY(539);
        nextButton2.setPrefSize(80, 40);
        nextButton2.setStyle("-fx-background-color: #f3d078; -fx-border-color: #ffffff; -fx-border-width: 1.75; -fx-border-radius: 20px; -fx-background-radius: 16px; -fx-background-radius: 22px;");
        nextButton2.setTextFill(javafx.scene.paint.Color.WHITE);
        nextButton2.setFont(Font.font("System Bold", 16));
        nextButton2.setVisible(false);
        
        // Create the back button
        Button backButton2 = new Button("<");
        backButton2.setLayoutX(31);
        backButton2.setLayoutY(30);
        backButton2.setPrefSize(34, 35);
        backButton2.setStyle("-fx-background-color: #f3d078; -fx-border-width: 1.75; -fx-border-color: #ffffff; -fx-background-radius: 10; -fx-border-radius: 10;");
        backButton2.setTextFill(javafx.scene.paint.Color.BLACK);
        backButton2.setFont(Font.font("System Bold", 12));
       
        
        level2box.getChildren().addAll(leve2grid, nextButton2);
        level2box.setAlignment(Pos.CENTER);
        HBox level2box2 = new HBox();
        level2box2.setSpacing(220);
        level2box2.getChildren().addAll(backButton2, accountLabel);
        level2Root.setTop(level2box2);
     

        level2Root.setBottom(level2box);
        level2Scene = new Scene(level2Root, 335, 600);
        
        ////////////////////// level3 scene ////////////////////////
        // create root node
        AnchorPane level3Root = new AnchorPane();
        level3Root.setPrefSize(335.0, 600.0);

        // create pane node
        Pane level3Pane = new Pane();
        level3Pane.setPrefSize(335.0, 600.0);
        level3Pane.setStyle("-fx-background-color: #fffaf0; -fx-border-color: #eee8aa; -fx-border-width: 8; ");

        // create label node
        Label level3Label = new Label("ديني");
        level3Label.setLayoutX(168.0);
        level3Label.setLayoutY(23.0);
        level3Label.setTextFill(Color.web("#c16969"));
        level3Label.setFont(new Font("Dubai Regular", 58.0));

        // create button nodes
        Button khadija = new Button("خديجة بنت خويلد");
        khadija.setLayoutX(78.0);
        khadija.setLayoutY(369.0);
        khadija.setPrefSize(180.0, 50.0);
        khadija.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20;");
        khadija.setTextFill(javafx.scene.paint.Color.WHITE);
        khadija.setFont(new Font(19.0));
        

        Button zainb = new Button("زينب بنت جحش");
        zainb.setLayoutX(78.0);
        zainb.setLayoutY(427.0);
        zainb.setPrefSize(180.0, 50.0);
        zainb.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20;");
        zainb.setTextFill(javafx.scene.paint.Color.WHITE);
        zainb.setFont(new Font(19.0));
        

        Button aisha = new Button("عائشة بنت الصديق");
        aisha.setLayoutX(78.0);
        aisha.setLayoutY(485.0);
        aisha.setPrefSize(180.0, 50.0);
        aisha.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20;");
        aisha.setTextFill(javafx.scene.paint.Color.WHITE);
        aisha.setFont(new Font(19.0));
        

        // create image view node
        imageView = new ImageView(new Image("rabbit.png"));
        imageView.setLayoutX(50.0);
        imageView.setFitWidth(135.0);
        imageView.setFitHeight(149.0);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);

        // create media view node
        Media media = new Media("file:/C://Users//ACER//Documents//NetBeansProjects//APProject//src//video.MP4/");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setLayoutX(31.0);
        mediaView.setLayoutY(130.0);
        mediaView.setFitWidth(275.0);
        mediaView.setFitHeight(170.0);

        // create image view node for play button
        ImageView playIcon = new ImageView(new Image("play icon.png"));
//        ImageView pause = new ImageView(new Image("pause.png"));
        playIcon.setLayoutX(145.0);
        playIcon.setLayoutY(310.0);
        playIcon.setFitWidth(45.0);
        playIcon.setFitHeight(50.0);
        playIcon.setPreserveRatio(true);
        playIcon.setPickOnBounds(true);
        

        // create button nodes
        Button nextButton3 = new Button("التالي");
        nextButton3.setLayoutX(15.0);
        nextButton3.setLayoutY(546.0);
        nextButton3.setPrefSize(70.0, 33.0);
        nextButton3.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 0; -fx-border-radius: 0;");
        nextButton3.setTextFill(Color.web("#ffffff"));
        nextButton3.setFont(new Font("System Bold", 16.0));
        nextButton3.setVisible(false);
        

        Button backButton3 = new Button("<");
        backButton3.setLayoutX(24.0);
        backButton3.setLayoutY(23.0);
        backButton3.setPrefSize(34.0, 35.0);
        backButton3.setStyle("-fx-background-color: #eec2b9; -fx-border-width: 1.75; -fx-border-color: #ffffff; -fx-background-radius: 10; -fx-border-radius: 10;");
        backButton3.setTextFill(javafx.scene.paint.Color.WHITE);
        backButton3.setFont(new Font("System Bold", 12.0));

        // add all nodes to the pane node
        level3Pane.getChildren().addAll(level3Label, khadija, zainb, aisha, imageView, mediaView, nextButton3, playIcon, backButton3);

        // add pane node to the root node
        level3Root.getChildren().add(level3Pane);

        // create a scene and add the root node to it
        level3Scene = new Scene(level3Root);

        /////////////////// level4 scene /////////////////////
        Pane level4Root = new Pane();
        level4Root.setStyle("-fx-background-color: #fffaf0; -fx-border-color: #eee8aa; -fx-border-width: 8;");

        // Create the content pane
        Pane contentPane = new Pane();
        contentPane.setLayoutX(16);
        contentPane.setLayoutY(69);
        contentPane.setPrefSize(303, 463);
        contentPane.setStyle("-fx-background-color: #fffaf0; -fx-background-radius: 20; ");

        // Create the button for correct answer
        Button correctAnswer = new Button("8");
        correctAnswer.setPrefSize(120, 41);
        correctAnswer.setStyle("-fx-background-color: c9eded; -fx-border-color: ffffff; -fx-background-radius: 20; -fx-border-radius: 20;");
        correctAnswer.setTextFill(javafx.scene.paint.Color.WHITE);
        correctAnswer.setFont(new Font(18));
        
        //Create the button for wrong answer 1
        Button wrongAnswer = new Button("5");
        wrongAnswer.setPrefSize(120, 41);
        wrongAnswer.setStyle("-fx-background-color: c9eded; -fx-border-color: ffffff; -fx-background-radius: 20; -fx-border-radius: 20;");
        wrongAnswer.setTextFill(javafx.scene.paint.Color.WHITE);
        wrongAnswer.setFont(new Font(18));
        
        
        //Create the button for wrong answer 2
        Button wrongAnswer2 = new Button("3");
        wrongAnswer2.setPrefSize(120, 41);
        wrongAnswer2.setStyle("-fx-background-color: c9eded; -fx-border-color: ffffff; -fx-background-radius: 20; -fx-border-radius: 20;");
        wrongAnswer2.setTextFill(javafx.scene.paint.Color.WHITE);
        wrongAnswer2.setFont(new Font(18));
        
        
        //Create the button for the wrong answer 3
        Button wrongAnswer3 = new Button("7");
        wrongAnswer3.setPrefSize(120, 41);
        wrongAnswer3.setStyle("-fx-background-color: c9eded; -fx-border-color: ffffff; -fx-background-radius: 20; -fx-border-radius: 20;");
        wrongAnswer3.setTextFill(javafx.scene.paint.Color.WHITE);
        wrongAnswer3.setFont(new Font(18));
        

        // Create the HBox for the button correct answer
        HBox correctAnsHBox = new HBox();
        correctAnsHBox.setLayoutX(93);
        correctAnsHBox.setLayoutY(279);
        correctAnsHBox.setPrefSize(118, 46);
        correctAnsHBox.getChildren().add(correctAnswer);
        
        // Create the HBox for the button wrong answer 
        HBox wrongAnsHBox = new HBox();
        wrongAnsHBox.setLayoutX(93);
        wrongAnsHBox.setLayoutY(230);
        wrongAnsHBox.setPrefSize(118, 46);
        wrongAnsHBox.getChildren().add(wrongAnswer);
        
        
        // Create the HBox for the button wrong answer 2
        HBox wrongAns2HBox = new HBox();
        wrongAns2HBox.setLayoutX(93);
        wrongAns2HBox.setLayoutY(330);
        wrongAns2HBox.setPrefSize(118, 46);
        wrongAns2HBox.getChildren().add(wrongAnswer2);
        
        
        // Create the HBox for the button correct answer 3
        HBox wrongAns3HBox = new HBox();
        wrongAns3HBox.setLayoutX(93);
        wrongAns3HBox.setLayoutY(180);
        wrongAns3HBox.setPrefSize(118, 46);
        wrongAns3HBox.getChildren().add(wrongAnswer3);

        // Create the label for the first question
        Label q1 = new Label("يحتوى وعاء الفاكهة على  خمسة قطع تفاح");
        q1.setPrefSize(258, 93);
        q1.setLayoutX(21);
        q1.setLayoutY(11);
        q1.setTextFill(javafx.scene.paint.Color.web("#ff006b"));
        q1.setFont(new Font(14));
        q1.setAlignment(javafx.geometry.Pos.CENTER);

        // Create the label for the second part of the first question
        Label q1pt2 = new Label("وثلاثة قطع موز كم مجموع القطع في الوعاء؟");
        q1pt2.setPrefSize(273, 66);
        q1pt2.setLayoutX(39);
        q1pt2.setLayoutY(45);
        q1pt2.setTextFill(javafx.scene.paint.Color.web("#ff006b"));
        q1pt2.setFont(new Font(14));
        q1pt2.setAlignment(javafx.geometry.Pos.CENTER);

        // Create the image view for the apple
        ImageView appleImageView = new ImageView();
        appleImageView.setFitHeight(55);
        appleImageView.setFitWidth(50);
        appleImageView.setLayoutX(256);
        appleImageView.setLayoutY(-16);
        appleImageView.setImage(new Image("apple.png"));

        // Create the image view for the fruit
        ImageView bananaImageView = new ImageView();
        bananaImageView.setFitHeight(66);
        bananaImageView.setFitWidth(47);
        bananaImageView.setLayoutX(8);
        bananaImageView.setLayoutY(81);
        bananaImageView.setImage(new Image("banana.png"));

        // Create the back button
        Button backButton4 = new Button("<");
        backButton4.setLayoutX(27);
        backButton4.setLayoutY(26);
        backButton4.setPrefSize(34, 35);
        backButton4.setStyle("-fx-background-color: #eec2b9; -fx-border-width: 1.75; -fx-border-color: #ffffff; -fx-background-radius: 10; -fx-border-radius: 10;");
        backButton4.setTextFill(javafx.scene.paint.Color.WHITE);
        backButton4.setFont(Font.font("System Bold", 12));

        // Create the "Next" button
        Button nextButton4 = new Button("التالي");
        nextButton4.setLayoutX(21);
        nextButton4.setLayoutY(539);
        nextButton4.setPrefSize(80, 40);
        nextButton4.setStyle("-fx-background-color: #f5b8e1; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 0; -fx-border-radius: 0;");
        nextButton4.setTextFill(javafx.scene.paint.Color.web("#ffffff"));
        nextButton4.setFont(Font.font("System Bold", 16));
        nextButton4.setVisible(false);

        // Add all the UI components to the content pane
        contentPane.getChildren().addAll(wrongAnsHBox,wrongAns2HBox,wrongAns3HBox, correctAnsHBox, bananaImageView, q1, q1pt2, appleImageView);

        // Add all the UI components to the root pane
        level4Root.getChildren().addAll(contentPane, backButton4, nextButton4);

        level4Scene = new Scene(level4Root, 335, 600);
        
        /////////////// level5 scene //////////////////
        Pane level5Root = new Pane();
        level5Root.setPrefHeight(612.0);
        level5Root.setPrefWidth(335.0);
        level5Root.setStyle("-fx-background-color: #fffaf0; -fx-border-color: #eee8aa; -fx-border-width: 8;");

        RadioButton fx1 = new RadioButton();
        fx1.setId("fx1");
        fx1.setLayoutX(94.0);
        fx1.setLayoutY(262.0);
        fx1.setMnemonicParsing(false);
        fx1.setPrefHeight(50.0);
        fx1.setPrefWidth(160.0);
        fx1.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20;");
        fx1.setText("المرض");
        fx1.setTextFill(javafx.scene.paint.Color.WHITE);
        Font font1 = new Font("System", 24.0);
        fx1.setFont(font1);

        RadioButton fx2 = new RadioButton();
        fx2.setId("fx2");
        fx2.setLayoutX(94.0);
        fx2.setLayoutY(352.0);
        fx2.setMnemonicParsing(false);        
        fx2.setPrefHeight(50.0);
        fx2.setPrefWidth(160.0);
        fx2.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20;");
        fx2.setText("الفقر");
        fx2.setTextFill(javafx.scene.paint.Color.WHITE);
        Font font2 = new Font("System", 24.0);
        fx2.setFont(font2);

        RadioButton fx3 = new RadioButton();
        fx3.setId("fx3");
        fx3.setLayoutX(94.0);
        fx3.setLayoutY(447.0);
        fx3.setMnemonicParsing(false);
        fx3.setPrefHeight(50.0);
        fx3.setPrefWidth(160.0);
        fx3.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20;");
        fx3.setText("خلاف");
        fx3.setTextFill(javafx.scene.paint.Color.WHITE);
        Font font3 = new Font("System", 24.0);
        fx3.setFont(font3);
        
        ToggleGroup group = new ToggleGroup();
        fx1.setToggleGroup(group);
        fx2.setToggleGroup(group);
        fx3.setToggleGroup(group);

        // Create and configure the first label
        Label label1 = new Label("معنى \"البأسآء\"");
        label1.setLayoutX(74.0);
        label1.setLayoutY(180.0);
        label1.setPrefWidth(199.0);
        label1.setPrefHeight(46.0);
        label1.setTextAlignment(TextAlignment.RIGHT);
        label1.setTextFill(Color.web("#c16969"));

        Font font11 = new Font("Agency FB", 31.0);
        label1.setFont(font11);

        // Create and configure the second label
        Label label2 = new Label("ديني");
        label2.setLayoutX(161.0);
        label2.setLayoutY(42.0);
        label2.setPrefWidth(150.0);
        label2.setPrefHeight(94.0);
        label2.setTextFill(Color.web("#c16969"));
        Font font22 = new Font("Dubai Regular", 68.0);
        label2.setFont(font22);

        // Create and configure the image view
        ImageView level5Rabbit = new ImageView(new Image("rabbit.png"));
        level5Rabbit.setFitWidth(150.0);
        level5Rabbit.setFitHeight(171.0);
        level5Rabbit.setLayoutX(46.0);
        level5Rabbit.setLayoutY(16.0);
        level5Rabbit.setPreserveRatio(true);
        level5Rabbit.setPickOnBounds(true);

        // Create the back button
        Button backButton5 = new Button("<");
        backButton5.setLayoutX(27);
        backButton5.setLayoutY(26);
        backButton5.setPrefSize(34, 35);
        backButton5.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 10; -fx-border-radius: 10;");
        backButton5.setTextFill(javafx.scene.paint.Color.WHITE);
        backButton5.setFont(Font.font("System Bold", 12));

        // Create the "Next" button
        Button nextButton5 = new Button("التالي");
        nextButton5.setLayoutX(21);
        nextButton5.setLayoutY(539);
        nextButton5.setPrefSize(80, 40);
        nextButton5.setStyle("-fx-background-color: #eec2b9; -fx-border-color: white; -fx-border-radius: 2; -fx-border-width: 2; -fx-background-radius: 0; -fx-border-radius: 0;");
        nextButton5.setTextFill(javafx.scene.paint.Color.WHITE);
        nextButton5.setFont(Font.font("System Bold", 16));
        nextButton5.setVisible(false);

        level5Root.getChildren().addAll(backButton5, fx1, fx2, fx3, label1, label2, level5Rabbit, nextButton5);
        level5Scene = new Scene(level5Root, 335, 600);

        
        /////////////////// controller ///////////////////

        ///////welcome scene actions///////
        startButton.setOnAction(e -> {
            primaryStage.setScene(registerScene);
            primaryStage.setTitle("إنشاء الحساب");            
        });
        
        welcomeScene.setOnKeyPressed(e-> {
            if(e.getCode() == KeyCode.ENTER){
                primaryStage.setScene(registerScene);
                primaryStage.setTitle("إنشاء الحساب");
            }
        });    
        
        ////////////// playerInfo actions //////////////
        
            
            topButton.setOnAction(e->{
                primaryStage.setScene(levelsScene);
                primaryStage.setTitle("المستويات");
            });
            
            
        //-------------EditInfoActions---------------------------

        
        saveButton.setOnAction(e -> {
            
//            saveButton.setVisible(true);
                Session ss = HibernateUtil.getSessionFactory().openSession();
                Transaction tt = ss.beginTransaction(); 
                List <Player> list = null;
                String query22 = "from Player";
                Query qq = ss.createQuery(query22);
            if(passwordFieldd.getText().length() < 8){
                msg.setText("كلمة السر يجب أن تحتوي على ثمانية حروف على الأقل");
            }else if(!emailFieldd.getText().contains("@")){
                msg.setText("تأكد من إدخال البريد الإلكتروني بشكل صحيح");
            }else{                              
                list = qq.list();
                for(Player p : list){
                    if(p.getPlayerName().equals(txtNameLog.getText())){
                    p.setPlayerEmail(emailFieldd.getText());
                    p.setPlayerPassword(passwordFieldd.getText());
                }   else{
                        System.out.println("يرجى التأكد من صحة كتابة الاسم");
                    }
                }
                
                tt.commit();
                ss.close();  
                
                try {
                        // Save the registration data to a file
                        updatedRegistrationDataToFile(usernameField.getText(), emailFieldd.getText(), passwordFieldd.getText());
                        
                    } catch (IOException ex) {
                        // Show an error message if the registration fails                        
                    }
            }
        });
            
        backButton10.setOnAction(e->{
            primaryStage.setScene(settingsScene);
        });
        
        /////////// register actions ///////////
        btnRegi.setOnAction(e->{
            if(txtNameReg.getText().isEmpty() || txtEmailReg.getText().isEmpty() || txtPasswordReg.getText().isEmpty()){
                msg.setText("تأكد من تعبئة كافة الحقول");           
            }else if(txtPasswordReg.getText().length() < 8){
                msg.setText("كلمة السر يجب أن تحتوي على ثمانية حروف على الأقل");
            }else if(!txtEmailReg.getText().contains("@")){
                msg.setText("تأكد من إدخال البريد الإلكتروني بشكل صحيح");
            }else{
                Player p1 = new Player();

                int j=0;
                Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();
                
                List <Player> list = null;
                String query = "from Player";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player i : list){
                    if(i.getPlayerName().equals(txtNameReg.getText())){
                        msg.setText("اسم اللاعب مستخدم, اختر اسما آخر");
                        return;
                    }
                    else
                        j=1;
                }
                t.commit();
                s.close();
         
                s = HibernateUtil.getSessionFactory().openSession();
                t = s.beginTransaction();
                
                p1.setPlayerName(txtNameReg.getText());
                p1.setPlayerEmail(txtEmailReg.getText());
                p1.setPlayerPassword(txtPasswordReg.getText());
                Player_state ps1 = new Player_state();
                ps1.setName_of_player(txtNameReg.getText());
                ps1.setNumberOfStars(0);               
                s.save(p1);
                s.save(ps1);
                t.commit();
                s.close();                
                
                try {
                        // Save the registration data to a file
                        saveRegistrationDataToFile(txtNameReg.getText(), txtEmailReg.getText(), txtPasswordReg.getText());
                        
                    } catch (IOException ex) {
                        // Show an error message if the registration fails                        
                    }      
                primaryStage.setScene(logInScene);
                primaryStage.setTitle("تسجيل الدخول");
            }
        });
        
        btnMain.setOnAction(e->{
            primaryStage.setScene(welcomeScene);
            primaryStage.setTitle("أهلا بك في تطبيق نبراس");
        });
        
        btnLogin.setOnAction(e->{
            primaryStage.setScene(logInScene);
            primaryStage.setTitle("تسجيل الدخول");
        });
        
       ////////// logIn actions //////////
       btnLoginScene.setOnAction(e->{ 
            int j=0;
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            List <Player> list = null;
            String query = "from Player";
            Query q = s.createQuery(query);
            list = q.list();
            for(Player p : list){
                if(txtNameLog.getText().isEmpty() || txtPasswordLog.getText().isEmpty()){
                    msg2.setText("تأكد من تعبئة كافة الحقول");
                }
                else if(p.getPlayerName().equals(txtNameLog.getText())){
                    if(p.getPlayerPassword().equals(txtPasswordLog.getText())){
                        playerName = txtNameLog.getText();
                        j=1;
                        primaryStage.setScene(levelsScene);
                        primaryStage.setTitle("المستويات");
                        return;                        
                    }
                    else{
                    msg2.setText("اسم المستخدم أو كلمة السر غير صحيح/ة");
                }
                }
                 else{
                    msg2.setText("اسم المستخدم أو كلمة السر غير صحيح/ة");
                }               
            }
            t.commit();
            s.close();
        });
        
        btnMainlogIn.setOnAction(e->{
           primaryStage.setScene(welcomeScene);
           primaryStage.setTitle("أهلا بك في تطبيق نبراس");
        });
               
        /////////// settings actions ///////////
        btnProfile.setOnAction(e -> {
            primaryStage.setScene(playerInfoScene);
            primaryStage.setTitle("معلومات اللاعب");
            List <Player> Players = new ArrayList();
            Session session1 = HibernateUtil.getSessionFactory().openSession();      
            session1 = HibernateUtil.getSessionFactory().openSession();  
            Query q3 = session1.createQuery("from Player");
            Players = q3.list();
            session1.close();
            for (Player p:Players){
                if(p.getPlayerName().equals(txtNameLog.getText())){
                emailDB.setText(p.getPlayerEmail());
                passwordDB.setText(p.getPlayerPassword());
                }
                else{
                    System.out.println("لم يتم تحديث المعلومات");
                }
            }
           
        List <Player_state> PlayerState = new ArrayList();
         Session session2 = HibernateUtil.getSessionFactory().openSession();      
            session2 = HibernateUtil.getSessionFactory().openSession();  
            Query q4 = session2.createQuery("from Player_state");
            PlayerState = q4.list();
            for (Player_state m:PlayerState){
                if(m.getName_of_player().equals(txtNameLog.getText())){
                pointsDB.setText(String.valueOf(m.getNumberOfStars()));
            }
            }
        });
        
        btnwho.setOnAction(e -> {
            primaryStage.setScene(HWAScene);
            primaryStage.setTitle("من نحن؟");
        });
        
        settingHomeBtn.setOnAction(e -> {
            primaryStage.setScene(editInfoScene);
            primaryStage.setTitle("المستويات");
        });
        
        btnLogout.setOnAction(e -> {
            primaryStage.setScene(welcomeScene);
            primaryStage.setTitle("أهلا بك في تطبيق نبراس");
        });
        
        arrowImageView.setOnMousePressed(e ->{
            primaryStage.setScene(levelsScene);
            primaryStage.setTitle("المستويات");
        });
        
        
        ///////////// who we are actions /////////////
            btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Stage stage = (Stage) btnClose.getScene().getWindow();
                primaryStage.setScene(settingsScene);
                primaryStage.setTitle("الإعدادات");
            }
        });

        //////////// levels actions ///////////
        button1.setOnAction(e->{ 
                Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction(); 
                List <Player_state> list = null;
                String query = "from Player_state";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player_state p : list){
                    if(p.getName_of_player().equals(txtNameLog.getText())){
                if(p.getNumberOfStars()>=0){
                    primaryStage.setScene(level1Scene);
                    primaryStage.setTitle("المستوى الأول");
                }else{
                msg3.setText("يرجى إكمال المراحل السابقة أولا");
                primaryStage.setScene(levelsScene);
                primaryStage.setTitle("المستويات");
            }
                }
                }
                
                t.commit();
                s.close();        
        });
        
        button2.setOnAction(e->{ 
        Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction(); 
                List <Player_state> list = null;
                String query = "from Player_state";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player_state p : list){
                    if(p.getName_of_player().equals(txtNameLog.getText())){
                if(p.getNumberOfStars()>=1){
                primaryStage.setScene(level2Scene);
                primaryStage.setTitle("المستوى الثاني");
            }else{
                msg3.setText("يرجى إكمال المراحل السابقة أولا");
                primaryStage.setScene(levelsScene);
                primaryStage.setTitle("المستويات");
            }
                }
                }
                t.commit();
                s.close();
        });
        
        button3.setOnAction(e->{ 
        Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction(); 
                List <Player_state> list = null;
                String query = "from Player_state";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player_state p : list){
                    if(p.getName_of_player().equals(txtNameLog.getText())){
                if(p.getNumberOfStars()>=2){
                primaryStage.setScene(level3Scene);
                primaryStage.setTitle("المستوى الثالث");
            }else{
                msg3.setText("يرجى إكمال المراحل السابقة أولا");
                primaryStage.setScene(levelsScene);
                primaryStage.setTitle("المستويات");
            }
                }
                }
                t.commit();
                s.close();
        });
        
        button4.setOnAction(e->{ 
        Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction(); 
                List <Player_state> list = null;
                String query = "from Player_state";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player_state p : list){
                    if(p.getName_of_player().equals(txtNameLog.getText())){
                if(p.getNumberOfStars()>=3){
                primaryStage.setScene(level4Scene);
                primaryStage.setTitle("المستوى الرابع");
            }else{
                msg3.setText("يرجى إكمال المراحل السابقة أولا");
                primaryStage.setScene(levelsScene);
                primaryStage.setTitle("المستويات");
            }
                }
                }
                t.commit();
                s.close();
        });
        
        button5.setOnAction(e->{ 
        Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction(); 
                List <Player_state> list = null;
                String query = "from Player_state";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player_state p : list){
                    if(p.getName_of_player().equals(txtNameLog.getText())){
                if(p.getNumberOfStars()>=4){
                    primaryStage.setScene(level5Scene);
                    primaryStage.setTitle("المستوى الخامس");
            }else{
                    msg3.setText("يرجى إكمال المراحل السابقة أولا");
                    primaryStage.setScene(levelsScene);
                    primaryStage.setTitle("المستويات");
            }
                }
                }
                t.commit();
                s.close();
        });
        
       
        goToSettings.setOnMousePressed(e->{
            primaryStage.setScene(settingsScene);
            primaryStage.setTitle("الإعدادات");
        });
        
        backButton.setOnAction(e->{
            primaryStage.setScene(welcomeScene);
            primaryStage.setTitle("أهلا بك في تطبيق نبراس");
        });
              
        ////////////// level1 actions ///////////////
        makkah.setOnMousePressed(e -> {
            correctobj1.play();
            nextButton1.setVisible(true); 
            Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction(); 
                List <Player_state> list = null;
                String query = "from Player_state";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player_state p : list){
                if((p.getName_of_player()).equals(txtNameLog.getText()))
                {    if(p.getNumberOfStars()==0){  
                    p.setNumberOfStars(p.getNumberOfStars()+1);
                }
                }
                }
                
                t.commit();
                s.close();
        });
        
        false1.setOnMousePressed(e -> {
            wrongobj1.play();
        });
        
        false2.setOnMousePressed(e -> {
            wrongobj1.play();
        });
        
        false3.setOnMousePressed(e -> {
            wrongobj1.play();
        });
        
        false4.setOnMousePressed(e -> {
            wrongobj1.play();
        });
        
        nextButton1.setOnAction(e -> {
            primaryStage.setScene(level2Scene);
            primaryStage.setTitle("المستوى الثاني");
        });

        backButton1.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(levelsScene);
            primaryStage.setTitle("المستويات");
           });
        
        
        //-----------------------level2 Actions----------------------
        choice.setOnMousePressed(e -> {
            correctobj2.play();
            nextButton2.setVisible(true);
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction(); 
            List <Player_state> list = null;
            String query = "from Player_state";
            Query q = s.createQuery(query);
            list = q.list();
            for(Player_state p : list){
            if((p.getName_of_player()).equals(txtNameLog.getText()))
            {    if(p.getNumberOfStars()<=1){
                p.setNumberOfStars(p.getNumberOfStars()+1);                    
            }
            }
            }

            t.commit();
            s.close();
        });
        
        choice2.setOnMousePressed(e -> {
            wrongobj2.play();
            nextButton2.setVisible(false);
        });
        
        choice3.setOnMousePressed(e -> {
            wrongobj2.play();
            nextButton2.setVisible(false);
        });
        
        choice4.setOnMousePressed(e -> {
           wrongobj2.play();
           nextButton2.setVisible(false);
        });
        
        nextButton2.setOnAction((e) -> {
            primaryStage.setScene(level3Scene);
            primaryStage.setTitle("المستوى الثالث");
        });
        
        backButton2.setOnAction((e) ->{
            primaryStage.setScene(levelsScene);
            primaryStage.setTitle("المستويات");
        });

        ///////// level 3 actions///////////
        khadija.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                correctobj3.play();
                nextButton3.setVisible(true);
                Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction(); 
                List <Player_state> list = null;
                String query = "from Player_state";
                Query q = s.createQuery(query);
                list = q.list();
                for(Player_state p : list){
                if((p.getName_of_player()).equals(txtNameLog.getText()))
                {    if( p.getNumberOfStars()<=2){
                    p.setNumberOfStars(p.getNumberOfStars()+1);                    
                }
                }
                }
                
                t.commit();
                s.close();
            }
        });
        
        zainb.setOnAction(new EventHandler<ActionEvent>() {
                   @Override
                    public void handle(ActionEvent event) {
                       wrongobj3.play();
                    }
                });

        aisha.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    wrongobj3.play();
                }
        });

        playIcon.setOnMousePressed(e -> {
                mediaPlayer.play();
        });
        
        nextButton3.setOnAction(e -> {
            primaryStage.setScene(level4Scene);
            primaryStage.setTitle("المستوى الرابع");
        });

        backButton3.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(levelsScene);
            primaryStage.setTitle("المستويات");
           });
        
        ////////////////// level 4 actions //////////////////

        wrongAnswer.setOnAction((ActionEvent event) -> {
            wrongobj4.play();
           });

        correctAnswer.setOnAction((ActionEvent event) -> {
            correctobj4.play();
            nextButton4.setVisible(true);
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction(); 
            List <Player_state> list = null;
            String query = "from Player_state";
            Query q = s.createQuery(query);
            list = q.list();
            for(Player_state p : list){
            if((p.getName_of_player()).equals(txtNameLog.getText()))
            {    if(p.getNumberOfStars()<=3){
                p.setNumberOfStars(p.getNumberOfStars()+1);                    
            }
            }
            }

            t.commit();
            s.close();
           });

        wrongAnswer2.setOnAction((ActionEvent event) -> {
            wrongobj4.play();
        });

        wrongAnswer3.setOnAction((ActionEvent event) -> {
            wrongobj4.play();
        });

        nextButton4.setOnAction(e -> {
            primaryStage.setScene(level5Scene);
            primaryStage.setTitle("المستوى الخامس");
        });

        backButton4.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(levelsScene);
            primaryStage.setTitle("المستويات");
        });

        

        /////////// level 5 actions ///////////
     
        fx1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wrongobj5.play();
            }
        });
        

        fx2.setOnAction(new EventHandler<ActionEvent>() {
            
                   @Override
                    public void handle(ActionEvent event) {
                        correctobj5.play();
                        nextButton5.setVisible(true);
                        Session s = HibernateUtil.getSessionFactory().openSession();
                        Transaction t = s.beginTransaction(); 
                        List <Player_state> list = null;
                        String query = "from Player_state";
                        Query q = s.createQuery(query);
                        list = q.list();
                        for(Player_state p : list){
                        if((p.getName_of_player()).equals(txtNameLog.getText()))
                        {    if(p.getNumberOfStars()<=4){
                            p.setNumberOfStars(p.getNumberOfStars()+1);
                        }
                        }
                        }
                
                        t.commit();
                        s.close();
                    }
                });

        fx3.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        wrongobj5.play();
                    }
        });
        
        nextButton5.setOnAction(e -> {
            primaryStage.setScene(levelsScene);
            primaryStage.setTitle("المستويات");
        });

        backButton5.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(levelsScene);
            primaryStage.setTitle("المستويات");
       });
        
        ///////////// end of controller //////////////


        primaryStage.setResizable(false);
        primaryStage.setTitle("أهلا بك في تطبيق نبراس");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    /**
     * Saves the registration data to a file.
     *
     * @param name     the user's name
     * @param email    the user's email, password the user's password
     * @throws IOException if an I/O error occurs while writing to the file
     */
    private void saveRegistrationDataToFile(String name, String email, String password) throws IOException {
        // Create a new file or append to an existing one
        File file = new File("registration.txt");
        // Write the registration data to the file
        try (FileWriter writer = new FileWriter(file, true)) {
            // Write the registration data to the file
            writer.write("Name: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Password: " + password + "\n\n");
            // Close the file writer
        }
}
    
    
    
    private void updatedRegistrationDataToFile(String name, String email, String password) throws IOException {
        // Create a new file or append to an existing one
        File file = new File("updatedRegistration.txt");
        // Write the registration data to the file
        try (FileWriter writer = new FileWriter(file, true)) {
            // Write the registration data to the file
            writer.write("Name: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Password: " + password + "\n\n");
            // Close the file writer
        }
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    
}
