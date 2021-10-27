package sun;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class req extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req(req,resp,true);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req(req,resp,false);
    }
    public void req(HttpServletRequest req,HttpServletResponse resp,Boolean b) throws IOException {
//        req.getParameter()  //getInputStream
        resp.setContentType("text/html;charset=utf-8");
        //     req.getAttribute()
//        req.getParameter()
        if(b){
            System.out.println("get请求");
        }else System.out.println("post请求");


//        req.getParameter()//根据方法名
//        req.getParameterMap()//返回所有集合
//        req.getParameterNames()//返回所有的名字
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((k,v)->{
            System.out.println("key="+k);
            System.out.println("value: ");
            for (String s : v) {
                System.out.println(s);
            }
        });

        ServletInputStream inputStream = req.getInputStream();
        byte[] by = new byte[1024];
        inputStream.read(by);
        String s1 = new String(by,"UTF-8");
        System.out.println("input接收数据: "+s1);
/**----------------------------------------------------------------------------------*/
        String str = "{user:'孙1',psd:'123'}";
        resp.getWriter().write(str);
    }
}
