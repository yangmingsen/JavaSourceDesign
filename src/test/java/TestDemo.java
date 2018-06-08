import com.yms.comm.ServiceFactory;
import com.yms.domain.Friend;
import com.yms.domain.Kinsfolk;
import com.yms.domain.Person;
import com.yms.domain.Teacher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestDemo {
    public static void main(String[] args) {


        ArrayList<Person> ar = new ArrayList<Person>();
        ar.add(new Friend("184-7457-5698","Catherine","深圳市南山区科技园南区R2-B",
                "123456@gmail.com","1710644559","184-7457-5698"));
        ar.add(new Friend("128-7457-5698","Oliver","张家界市南山区科技园南区R2-B",
                "123456@gmail.com","2710644559","128-7457-5698"));
        ar.add(new Friend("138-1457-5698","Muhammed","深圳市南山区科技园南区R2-B",
                "123456@gmail.com","3710644559","138-1457-5698"));
        ar.add(new Friend("178-7157-5698","Olivia","长沙市南山区科技园南区R2-B",
                "123456@gmail.com","4710644559","178-7157-5698"));

        ServiceFactory.getFriendService().writePersion(ar);
    }
}
