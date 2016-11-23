package bl.userbl.mock;

import bl.userbl.User;
import util.LoginState;
import util.ResetState;

/**
 * Created by Kray on 2016/10/30.
 */
public class MockUser extends User {

    /**
     * 登出
     *
     * @return
     */
    public LoginState logout() {
        return LoginState.LOGOUT;
    }

    /**
     * 重置密码
     *
     * @param account
     * @param oldPassword
     * @param newPassword
     * @return
     */
    public ResetState resetPassword(String account, String oldPassword, String newPassword) {
        return ResetState.RESET_SUCCESS;
    }
}
