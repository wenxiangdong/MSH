package dataimpl.User;

import dataservice.userdataservice.UserDataService;
import org.junit.Test;
import po.StaffPO;
import util.ResultMessage;

import static org.junit.Assert.*;

/**
 * Created by Kray on 2016/11/17.
 */
public class StaffDataServiceImplTest {

    private UserDataService userDataService;

    public StaffDataServiceImplTest() {
        userDataService = UserDataServiceFactory.getStaffDataService();
    }

    @Test
    public void addStaff() throws Exception {
        ResultMessage resultMessage = userDataService.addStaff(new StaffPO("100001", "KrayC", "25010001", "songkuixi", "123456"));
        assertEquals(ResultMessage.SUCCESS, resultMessage);
    }

    @Test
    public void searchStaffByID() throws Exception {

    }

    @Test
    public void updateStaff() throws Exception {

    }

    @Test
    public void deleteStaff() throws Exception {

    }

    @Test
    public void searchStaff() throws Exception {

    }

    @Test
    public void login() throws Exception {

    }

    @Test
    public void logout() throws Exception {

    }

    @Test
    public void resetPassword() throws Exception {

    }

}