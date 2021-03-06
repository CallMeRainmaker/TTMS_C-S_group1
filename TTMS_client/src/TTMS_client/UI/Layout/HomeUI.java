package UI.Layout;

import UI.Self.SelfMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Employee;
import util.Httpclient;

public class HomeUI{

    public static Employee employee;

    public HomeUI(Employee employee){
        this.employee = employee;
    }

    public static HBox top(){
        HBox toppane = new HBox();
        toppane.setAlignment(Pos.CENTER_RIGHT);
        toppane.setSpacing(20);
        toppane.setPadding(new Insets(10,10,2,20));
        Label username = new Label(employee.getEmp_name());
        username.setStyle("-fx-font-size: 24px");
        Hyperlink selfcenter = new Hyperlink("个人中心",new ImageView("/image/User/settings.png"));
        selfcenter.setStyle("-fx-border-style: hidden;-fx-content-display: graphic-only;-fx-font-size: 18px");
        Hyperlink logout = new Hyperlink("注销",new ImageView("/image/User/logout.png"));
        logout.setStyle("-fx-border-style: hidden;-fx-content-display: graphic-only;-fx-font-size: 18px");

        selfcenter.setOnAction(e->{
            HomeUI.setCenter(new SelfMenu(employee));
        });
        logout.setOnAction(e->{
            String url = "/logout";
            Httpclient.get(url);
            Main.borderPane.setTop(null);
            Main.borderPane.setLeft(null);
            Main.borderPane.setCenter(LoginUI.init());
        });
        toppane.getChildren().addAll(username,selfcenter,logout);
        return  toppane;
    }

    public void adminUI(){
        Main.borderPane.setTop(top());
        Main.borderPane.setCenter(center());
        Main.borderPane.setLeft(NavigationBar.getAdminBar());
    }

    public void sellManUI(){
        Main.borderPane.setTop(top());
        Main.borderPane.setCenter(center());
        Main.borderPane.setLeft(NavigationBar.getSellManBar());
    }

    public void ManagerUI(){
        Main.borderPane.setTop(top());
        Main.borderPane.setCenter(center());
        Main.borderPane.setLeft(NavigationBar.getManagerBar());
    }

    public static Pane center(){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setSpacing(40);
        vBox.setPadding(new Insets(50,20,20,20));
        Label welcome = new Label("欢迎使用海客票务管理系统！");
        welcome.setId("welcome");
        Label note = new Label("　　西安海客电影城由10个豪华放映厅组成，同时可以容纳1700位" +
                "观众观影。其中，陕西省首座IMAX影厅还受到广大影迷的狂热追捧！\n" +
                "\n" +
                "　　西安海客电影城采用了优质的数码视听设备，包括杜比数码SRD、DTS还音设备、" +
                "美国QSC功放系统、德国施耐德高端镜头以及英国超视野“Wall to Wall Screen”整壁式清晰" +
                "巨幅银幕。在西安海客电影城的任何一个影厅，观众都会享受到同等规格的视听盛宴，再加上" +
                "高品质和人性化的服务理念，使西安海客电影城华丽登场的同时，更不容置疑的披上了时尚前" +
                "沿的桂冠。海客电影城必将成为陕西省电影行业的新标杆和尊享生活的新高地！");
        note.setId("note");
        Label emailAndPhone = new Label("　　Email:  Hackers@hacker.org　　　　Phone:  029-88888888");
        vBox.getChildren().addAll(welcome,note,emailAndPhone);
        return vBox;
    }

    public static void setCenter(Pane pane){
        Main.borderPane.setCenter(pane);
    }

    public static void showNote(){
        Main.borderPane.setCenter(HomeUI.center());
    }
}
