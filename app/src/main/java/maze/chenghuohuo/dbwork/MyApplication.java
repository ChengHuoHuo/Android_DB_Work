package maze.chenghuohuo.dbwork;

import android.app.Application;

import data.Father;
import data.User;

/**
 * Created by 44223 on 2018/8/27.
 */

public class MyApplication extends Application{
    private User user;
    private Father father;
    public void setUser(User user) {
        this.user = user;
    }
    public void setFather(Father father){this.father=father;}

    public User getUser() {
        return user;
    }
    public Father getFather(){return father;}

}
