package bl.userbl;

import dataimpl.userdataimpl.UserDataServiceFactory;
import dataservice.userdataservice.UserDataService;
import po.LevelPO;
import po.SalesmanPO;
import util.LoginState;
import util.ResultMessage;
import vo.LevelVO;
import vo.SalesmanVO;
import vo.SalesmanVO_Register;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by Kray on 2016/10/30.
 */
public class Salesman extends User {

    private UserDataService userDataService;
    private String account;
    private String password;

    public Salesman() {
        this.userDataService = UserDataServiceFactory.getSalesmanDataService();
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return 当前登录状态
     */
    public LoginState login(String account, String password) {
        LoginState loginState = userDataService.login(account, password);
        if (loginState == LoginState.LOGIN_SUCCESS_Salesman) {
            System.out.println("Login Salesman");
            SalesmanPO salesmanPO = userDataService.searchSalesman(account).get(0);
            super.setCurrentID(salesmanPO.getSalesmanID());
            this.account = account;
            this.password = password;
        }
        return loginState;
    }

    /**
     * 增加网站营销人员
     *
     * @param userVO
     * @return 是否增加成功
     */
    public ResultMessage add(UserVO userVO) {
        SalesmanVO_Register salesmanVO = (SalesmanVO_Register) userVO;
        SalesmanPO salesmanPO = new SalesmanPO(salesmanVO.salesmanID, salesmanVO.salesmanName, salesmanVO.account, salesmanVO.password);
        return userDataService.addSalesman(salesmanPO);
    }

    /**
     * 根据ID查找网站营销人员
     *
     * @param SalesmanID
     * @return 符合ID的SalesmanVO
     */
    public SalesmanVO searchByID(String SalesmanID) {
        SalesmanPO SalesmanPO = userDataService.searchSalesmanByID(SalesmanID);
        if (SalesmanPO == null) {
            return null;
        } else {
            SalesmanVO SalesmanVO = new SalesmanVO(SalesmanPO.getSalesmanID(), SalesmanPO.getSalesmanName());
            return SalesmanVO;
        }
    }

    /**
     * 更新网站营销人员
     *
     * @param userVO
     * @return 是否更新成功
     */
    public ResultMessage update(UserVO userVO) {
        SalesmanVO SalesmanVO = (SalesmanVO) userVO;
        SalesmanPO SalesmanPO = new SalesmanPO(SalesmanVO.salesmanID, SalesmanVO.salesmanName, account, password);
        return userDataService.updateSalesman(SalesmanVO.salesmanID, SalesmanPO);
    }

    /**
     * 删除网站营销人员
     *
     * @param salesmanID
     * @return 是否删除成功
     */
    public ResultMessage delete(String salesmanID) {
        return userDataService.deleteSalesman(salesmanID);
    }

    /**
     * 根据关键词搜索网站营销人员
     *
     * @param keyword
     * @return 符合关键词的所有网站营销人员
     */
    public ArrayList<SalesmanVO> search(String keyword) {
        ArrayList<SalesmanPO> SalesmanPOs = userDataService.searchSalesman(keyword);
        ArrayList<SalesmanVO> SalesmanVOs = new ArrayList<SalesmanVO>();
        for (SalesmanPO SalesmanPO : SalesmanPOs) {
            SalesmanVOs.add(new SalesmanVO(SalesmanPO.getSalesmanID(), SalesmanPO.getSalesmanName()));
        }
        return SalesmanVOs;
    }

    /**
     * 增加一条等级信息
     *
     * @return
     */
    public ResultMessage addLevel(LevelVO levelVO) {
        LevelPO levelPO = new LevelPO(levelVO.level, Integer.parseInt(levelVO.level), Integer.parseInt(levelVO.credit));
        return userDataService.addLevel(levelPO);
    }

    /**
     * 更新一条等级信息
     *
     * @return
     */
    public ResultMessage updateLevel(LevelVO levelVO) {
        LevelPO levelPO = new LevelPO(levelVO.level, Integer.parseInt(levelVO.level), Integer.parseInt(levelVO.credit));
        return userDataService.updateLevel(levelVO.level, levelPO);
    }

    /**
     * 删除一条等级信息
     *
     * @return
     */
    public ResultMessage deleteLevel(String ID) {
        return userDataService.deleteLevel(ID);
    }

}
