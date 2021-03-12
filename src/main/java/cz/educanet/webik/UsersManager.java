package cz.educanet.webik;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UsersManager implements Serializable {

    User user = null;

}
