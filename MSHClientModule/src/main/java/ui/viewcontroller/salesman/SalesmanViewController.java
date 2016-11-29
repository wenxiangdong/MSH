package ui.viewcontroller.salesman;

import bl.userbl.Salesman;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.Main;

import java.io.IOException;

/**
 * Created by vivian on 16/11/27.
 */
public class SalesmanViewController {
    private BorderPane rootPane;

    private WebPromotionViewController webPromotionViewController;
    public SalesmanViewController(BorderPane rootPane) {
        this.rootPane = rootPane;

        try {
            FXMLLoader navLoader = new FXMLLoader();
            navLoader.setLocation(Main.class.getResource("../view/salesman/SalesmanNavbar.fxml"));
            Pane navbar = navLoader.load();

            SalesmanNavbarController salesmanNavbarController = navLoader.getController();
            salesmanNavbarController.setSalesmanViewController(this);

            rootPane.setLeft(navbar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        webPromotionViewController = new WebPromotionViewController(rootPane);
    }

    public void showWebPromotionList() {
        webPromotionViewController.showWebPromotionList();
//        System.out.print("shoeWebPromotionList!");
    }
}
