package sun;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) throws IOException {
       File file = new File("E:\\app\\xuehao.txt");
        File log  = new File("E:\\app\\log.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(log,true));//true,则追加写入text文本
        FileInputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[1024];
         inputStream.read(b);
        String metaData = new String(b);
        List<User> list = new JSONObject().parseArray(metaData, User.class);
        for (User user : list) {
            String s = sendPost("http://zs.future.jscst.edu.cn/webapp/api/v1/yqfktwsb/twxx", user);
            output.write(s);
            output.write("\r\n");//换行
        }
        output.flush();
        output.close();
    }
    public static String sendPost(String url, User user) {
        String param = JSONObject.toJSONString(user);
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            //Content-Type:
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            return "发送 POST 请求出现异常！"+unicode2String(e.getMessage());
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }

        return user.getXuehao()+"=="+unicode2String(result)+ new SimpleDateFormat("MM月dd号EHH时mm分ss ").format(new Date());
    }
    public static String unicode2String(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }

}
