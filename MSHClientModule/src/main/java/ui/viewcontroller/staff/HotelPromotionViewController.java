package ui.viewcontroller.staff;

import bl.blfactory.BLFactoryImpl;
import blservice.promotionblservice.PromotionBLService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import main.Main;
import vo.PromotionVO;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by vivian on 16/12/8.
 */
public class HotelPromotionViewController {
    private BorderPane rootPane;

    private Node initNode;
    private Stack<Node> stack = new Stack<Node>();

    private HotelPromotionListViewController hotelPromotionListViewController;

    private PromotionBLService promotionBLService;

    private PromotionVO promotionVO;

    public HotelPromotionViewController(BorderPane rootPane) {
        this.promotionBLService = new BLFactoryImpl().getPromotionBLService();
        this.rootPane = rootPane;
    }

    /**
     * 返回上一界面
     */
    public void back() {
        if (!stack.empty()) {
            Node node = stack.pop();
            rootPane.setCenter(node);

        }
    }

    /**
     * 网站促销策略列表
     */
    public void showHotelPromotionList() {
        if (initNode != null) {
            stack.clear();
            rootPane.setCenter(initNode);
            return;
        }

        try {
            FXMLLoader listLoader = new FXMLLoader();
            listLoader.setLocation(Main.class.getResource("../view/staff/HotelPromotionListView.fxml"));
            ScrollPane list = listLoader.load();

            hotelPromotionListViewController = listLoader.getController();
            hotelPromotionListViewController.setHotelPromotionViewController(this);

            initNode = list;

            rootPane.setCenter(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新策略列表
     */
    public void refreshWebPromotionList() {
        hotelPromotionListViewController.showAllHotelPromotions();
    }

    /**
     * 展示策略详情
     *
     * @param promotionVO
     */
    public void showPromotionDetail(PromotionVO promotionVO) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/staff/HotelPromotionDetailView.fxml"));
            ScrollPane view = loader.load();

            HotelPromotionDetailViewController hotelPromotionDetailViewController = loader.getController();
            hotelPromotionDetailViewController.setHotelPromotionViewController(this);
            hotelPromotionDetailViewController.setPromotionBLService(promotionBLService);
            hotelPromotionDetailViewController.showHotelPromotionDetail(promotionVO);

            Node node = rootPane.getCenter();
            stack.push(node);

            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新策略列表
     */
//    public void refreshWebPromotionList() {
//        webPromotionListViewController.showAllWebPromotions();
//    }

    /**
     * 编辑策略
     */
//    public void showPromotionDetailEditView(PromotionVO promotionVO) {
//        this.promotionVO = promotionVO;
//        this.addWebPromotion(promotionVO.promotionType, true);
//    }

    /**
     * 增加策略
     */
//    public void addWebPromotion(PromotionType promotionType, boolean isEdit) {
//        switch (promotionType) {
//            case Web_ClientGrade:
//                this.addWeb_ClientGradePromotion(isEdit);
//                break;
//            case Web_SpecilaDate:
//                this.addWeb_SpecialDatePromotion(isEdit);
//                break;
//            case Web_SpecilPlace:
//                this.addWeb_SpecialPlacePromotion(isEdit);
//                break;
//        }
//    }

    /**
     * 增加或编辑网站会员等级策略
     */
//    public void addWeb_ClientGradePromotion(boolean isEdit) {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("../view/salesman/WebPromotion_ClientGradeAddView.fxml"));
//            ScrollPane view = loader.load();
//
//            WebPromotion_ClientGradeAddViewController webPromotion_clientGradeAddViewController = loader.getController();
//            webPromotion_clientGradeAddViewController.setWebPromotionViewController(this);
//            webPromotion_clientGradeAddViewController.setPromotionBLService(promotionBLService);
//            if(isEdit){
//                webPromotion_clientGradeAddViewController.showEditView(promotionVO);
//            }
//
//            Node node = rootPane.getCenter();
//            stack.push(node);
//
//            rootPane.setCenter(view);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 增加或编辑网站特殊期间折扣策略
     */
//    public void addWeb_SpecialDatePromotion(boolean isEdit) {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("../view/salesman/WebPromotion_SpecialDateAddView.fxml"));
//            ScrollPane view = loader.load();
//
//            WebPromotion_SpecialDateAddViewController webPromotion_specialDateAddViewController = loader.getController();
//            webPromotion_specialDateAddViewController.setWebPromotionViewController(this);
//            webPromotion_specialDateAddViewController.setPromotionBLService(promotionBLService);
//            if(isEdit){
//                webPromotion_specialDateAddViewController.showEditView(promotionVO);
//            }
//
//            Node node = rootPane.getCenter();
//            stack.push(node);
//
//            rootPane.setCenter(view);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 增加或编辑网站特殊商圈折扣策略
     */
//    public void addWeb_SpecialPlacePromotion(boolean isEdit) {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("../view/salesman/WebPromotion_SpecialPlaceAddView.fxml"));
//            ScrollPane view = loader.load();
//
//            WebPromotion_SpecialPlaceAddViewController webPromotion_specialPlaceAddViewController = loader.getController();
//            webPromotion_specialPlaceAddViewController.setWebPromotionViewController(this);
//            webPromotion_specialPlaceAddViewController.setPromotionBLService(promotionBLService);
//            if(isEdit){
//                webPromotion_specialPlaceAddViewController.showEditView(promotionVO);
//            }
//
//            Node node = rootPane.getCenter();
//            stack.push(node);
//
//            rootPane.setCenter(view);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
