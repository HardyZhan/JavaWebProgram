package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {

    private BrandService service = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Brand> brands = service.selectAll();

        String jsonString = JSON.toJSONString(brands);

        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        service.add(brand);

        response.getWriter().write("success");
    }


    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();

//        System.out.println(params);

        Brand brand = JSON.parseObject(params, Brand.class);

        service.update(brand);

        response.getWriter().write("success");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader br = request.getReader();
        String id = br.readLine();
//        System.out.println(id);

        service.delete(Integer.parseInt(id));

        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();

        int[] ids = JSON.parseObject(params, int[].class);

        service.deleteByIds(ids);

        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("currentPage");

        String pageSize = request.getParameter("pageSize");

        PageBean<Brand> brandPageBean = service.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));

        String jsonString = JSON.toJSONString(brandPageBean);

        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("currentPage");

        String pageSize = request.getParameter("pageSize");

        BufferedReader br = request.getReader();
        String params = br.readLine();


        Brand brand = JSON.parseObject(params, Brand.class);

        PageBean<Brand> brandPageBean = service.selectByPageAndCondition(Integer.parseInt(currentPage), Integer.parseInt(pageSize), brand);

        String jsonString = JSON.toJSONString(brandPageBean);

        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(jsonString);
    }

}
