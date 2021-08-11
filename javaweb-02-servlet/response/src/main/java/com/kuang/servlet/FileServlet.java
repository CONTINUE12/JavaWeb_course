package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {

    //下载文件
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取下载文件路径
        String realPath = "F:\\JAVA\\MyProject\\JavaWeb_course\\javaweb-02-servlet\\response\\target\\response\\WEB-INF\\classes\\1.png";
        System.out.println("下载文件的路径:"+realPath);
        //2.获取下载文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //3.设置浏览器支持（Content-Disposition）下载需要的文件
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
        //4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5.自建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6.获取outputstream对象
        ServletOutputStream out = resp.getOutputStream();
        //7.将fileoutputstream流写入到缓冲区，用getoutputstream将缓冲区的数据保存到客户端
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
