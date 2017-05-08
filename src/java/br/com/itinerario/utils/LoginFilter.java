///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.itinerario.utils;
//
//import br.com.itinerario.model.Usuario;
//import java.io.IOException;
//import javax.faces.application.ResourceHandler;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author marce
// */
//@WebFilter(servletNames = {"Faces Servlet"})
//public class LoginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        String indexURL = request.getContextPath() + "/faces/index.xhtml";
//        String loginURL = request.getContextPath() + "/faces/login.xhtml";
//
//        HttpSession session = request.getSession();
//        Usuario usuario = (Usuario) session.getAttribute("user");
//        
//        boolean loginRequest = request.getRequestURI().startsWith(indexURL) || request.getRequestURI().startsWith(loginURL);
//        boolean resourceRequest = 
//                request.getRequestURI().startsWith(request.getContextPath() + "/faces/resources/")
//                || request.getRequestURI().startsWith(request.getContextPath() + "/faces" + ResourceHandler.RESOURCE_IDENTIFIER);
//        
//        if (usuario != null || loginRequest || resourceRequest) {
//            chain.doFilter(request, response);
//        }else {
//            response.sendRedirect(loginURL);
//        }
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//}
