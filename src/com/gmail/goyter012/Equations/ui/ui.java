package com.gmail.goyter012.Equations.ui;

import com.gmail.goyter012.Equations.models.EqualDataSample;
import com.gmail.goyter012.Equations.services.Executor;
import com.gmail.goyter012.Equations.services.ImageAdress;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class ui extends Application {

    private BackgroundImage mybi= new BackgroundImage(new Image(ImageAdress.imRender("/home/goyter/developing/IdeaProjects/AMOEqs/img/vysh.jpg"),600,400,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private BackgroundImage mybi4= new BackgroundImage(new Image(ImageAdress.imRender("/home/goyter/developing/IdeaProjects/AMOEqs/img/VM.jpg"),600,400,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);


    String a = null;
    String b = null;
    String e = null;



    public static void builder(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage){

        MenuBar mb = new MenuBar();

        Menu fileMenu = new Menu("Файл");
        Menu open = new Menu("Відкрити");
        MenuItem close= new MenuItem("Закрити");
        MenuItem exit = new MenuItem("Вихід");
        MenuItem open2 = new MenuItem("Вибрати файл");
        open.getItems().add(open2);

        fileMenu.getItems().addAll(open,close,new SeparatorMenuItem(),exit);

        Menu options = new Menu("Налаштуванння");

        Menu view = new Menu("Вигляд");
        Menu butcol = new Menu("Колір кнопок");
        Menu backcolor = new Menu("Колір фону");

        MenuItem aqua = new MenuItem("Аквамарин");
        MenuItem gold = new MenuItem("Золотий");
        MenuItem biaq = new MenuItem("Бісквит");


        butcol.getItems().addAll(aqua,gold,biaq);

        MenuItem red = new MenuItem("Червоний");
        MenuItem green= new MenuItem("Зелений");
        MenuItem blue = new MenuItem("Синій");
        MenuItem black = new MenuItem("Чорний");
        MenuItem white = new MenuItem("Білий");
        backcolor.getItems().addAll(red,green,blue,black,white);

        view.getItems().addAll(backcolor,butcol);
        MenuItem reset = new MenuItem("Скинути");

        MenuItem premium = new MenuItem("Premium");


        options.getItems().addAll(view,premium,reset);

        Menu help = new Menu("Допомога");
        MenuItem about = new MenuItem("Про нас");

        help.getItems().add(about);

        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l = new Label("This app was developed by Cherednichenko Vladyslav");
                Label em = new Label("Email - goyter012@gmail.com");
                Label k = new Label("2019");

                Stage s = new Stage();
                FlowPane borderPane = new FlowPane(5,5);
                borderPane.setAlignment(Pos.TOP_LEFT);
                borderPane.setOrientation(Orientation.VERTICAL);

                borderPane.getChildren().addAll(l,em,k);
                s.setScene(new Scene(borderPane,400,50));
                s.setTitle("Info");
                s.show();


            }
        });

        mb.getMenus().addAll(fileMenu,options,help);

        open2.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
        close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });


        open2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage opener = new Stage();

                Label glav = new Label("Введіть назву файлу");
                Label res = new Label();

                Separator sep = new Separator();
                sep.setPrefWidth(200);

                TextField tf = new TextField();
                tf.setPrefColumnCount(10);

                tf.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        EqualDataSample m = Executor.loaderFromJsonFile(new File(tf.getText()));
                        if(m!= null){
                            a = Double.toString(m.getA());
                            b = Double.toString(m.getB());
                            e = Double.toString(m.getE());
                            res.setText("Зчитано коректно");
                        }else{
                            res.setText("Невірні дані");
                        }

                    }
                });

                opener.setTitle("Зчитування даних");
                FlowPane f2 = new FlowPane(10,10);
                f2.setAlignment(Pos.CENTER);
                f2.getChildren().addAll(glav,tf,sep,res);

                opener.setScene(new Scene(f2,250,100));
                opener.show();

            }
        });




        ///////////////
        Button mainprocess = new Button("Почати роботу");
        mainprocess.setPrefSize(150,80);
        mainprocess.setStyle("-fx-background-color: aquamarine");



        mainprocess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage mainStage = new Stage();

                Label methLabel = new Label("Метод Хорд ");
                methLabel.setStyle("-fx-background-color: #57ff3c");
                methLabel.setFont(new Font(30));
                methLabel.setAlignment(Pos.TOP_CENTER);


                Label tfALab = new Label("Введіть початок інтервалу");
                tfALab.setFont(new Font(15));
                tfALab.setStyle("-fx-background-color: #2d75ff");

                TextField tfA = new TextField();

                if(a!=null) {
                    tfA.setText(a);
                }   else {
                    tfA.setText("-5");
                }

                tfA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        /////////////////////////////////////////////////////////////////////////////////////////////////////
                    }
                });



                Label tfBLab = new Label("Введіть кінець інтервалу");
                tfBLab.setFont(new Font(15));
                tfBLab.setStyle("-fx-background-color: #2d75ff");

                TextField tfB = new TextField();

                if(b!=null){
                    tfB.setText(b);
                }else {
                    tfB.setText("5");
                }


                tfB.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //////////////////////////////////////////////////////////////////////////////////////////////////////////
                    }
                });

                Label tfELab = new Label("Введіть бажане наближення");
                tfELab.setFont(new Font(15));
                tfELab.setStyle("-fx-background-color: #2d75ff");

                TextField tfE = new TextField();

                if(e!=null) {
                    tfE.setText(e);
                }   else {
                    tfE.setText("0.001");
                }


                tfE.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////
                    }
                });

                Label res = new Label("");
                res.setFont(new Font(15));
                res.setStyle("-fx-background-color: #2d75ff");



                Button rozrah = new Button("",new ImageView(ImageAdress.imRender("/home/goyter/developing/IdeaProjects/AMOEqs/img/IMG_3313.jpg")));
                rozrah.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                    }
                });


                Button saver = new Button("Зберегти");
                saver.setStyle("-fx-background-color: aqua");
                saver.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        /////////////////////////////////////////////////////////////////////////////////////////////////////////
                    }
                });


                Button schema = new Button("Схема");
                schema.setStyle("-fx-background-color: aqua");
                schema.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                                            /////////////////////////////////////////////////////////////////////////////////////////

                    }
                });
















                FlowPane rootNode = new FlowPane(10,10);
                rootNode.setAlignment(Pos.TOP_CENTER);
                rootNode.setOrientation(Orientation.VERTICAL);
                rootNode.setBackground(new Background(mybi));

                rootNode.getChildren().addAll(methLabel,tfALab,tfA,tfBLab,tfB,tfELab,tfE,rozrah,res,saver,schema);
                Scene mainScene = new Scene(rootNode,400,400);

                mainStage.setScene(mainScene);
                mainStage.setTitle("Метод Хорд");
                mainStage.show();
            }
        });











        //////////////


        BorderPane rootNode = new BorderPane();
        Scene mainScene = new Scene(rootNode,500,400);
        red.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.RED);
                rootNode.setBackground(null);
            }
        });

        green.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.GREEN);
                rootNode.setBackground(null);
            }
        });

        blue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.BLUE);
                rootNode.setBackground(null);
            }
        });

        black.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.BLACK);
                rootNode.setBackground(null);
            }
        });

        white.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.WHITE);
                rootNode.setBackground(null);
            }
        });

        aqua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainprocess.setStyle("-fx-background-color: aqua");
            }
        });

        biaq.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainprocess.setStyle("-fx-background-color: chartreuse");
            }
        });

        gold.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainprocess.setStyle("-fx-background-color: gold");
            }
        });


        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootNode.setBackground(new Background(mybi));
                mainprocess.setStyle("-fx-background-color: aquamarine");

            }
        });


        premium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootNode.setBackground(new Background(mybi4));
            }
        });

        rootNode.setTop(mb);
        rootNode.setCenter(mainprocess);
        rootNode.setBackground(new Background(mybi));

        stage.setTitle("Розрахунок нелінійних рівнянь");
        stage.setScene(mainScene);
        stage.show();

    }



}
