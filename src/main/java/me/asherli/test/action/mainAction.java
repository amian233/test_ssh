package me.asherli.test.action;


import com.opensymphony.xwork2.ActionSupport;
import me.asherli.test.dao.impl.UserDaoImpl;
import me.asherli.test.model.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class mainAction extends ActionSupport {


    private String url = "./";

    private void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Autowired
    private UserDaoImpl userDao;


    public String index() {
        HttpServletRequest request = ServletActionContext.getRequest();
        this.setUrl("/index.jsp");
        request.setAttribute("tipMessage", "无");
        return this.SUCCESS;
    }

    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String method = request.getMethod();
        if (method.equals("GET")) {
            this.setUrl("/login.jsp");
        }
        if (method.equals("POST")) {
            User user = new User();
            user.setName(request.getParameter("name"));
            List<User> list = userDao.selectBean(user);
            if (list.size() != 0) {
                request.setAttribute("tipMessage", "欢迎您，" + list.get(0).getName() + (list.get(0).getSex() == 0 ? "女士" : "先生"));
            } else {
                request.setAttribute("tipMessage", "无");
            }
            this.setUrl("/index.jsp");
        }
        return this.SUCCESS;
    }

    public String register() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String method = request.getMethod();
        if (method.equals("GET")) {
            this.setUrl("/register.jsp");
        }
        if (method.equals("POST")) {
            User user = new User();
            user.setName(request.getParameter("name"));
            user.setSex(Integer.parseInt(request.getParameter("sex")));
            userDao.insertBean(user);
            this.setUrl("/index.jsp");
            request.setAttribute("tipMessage", "无");
        }
        return this.SUCCESS;
    }
}