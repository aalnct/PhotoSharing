package com.photo.sharing.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SignatureException;

/**
 * Created by AmitAgarwal on 5/7/19.
 */
public class JwtFilter extends GenericFilterBean{


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final HttpServletResponse httpServletResponse  = (HttpServletResponse) response;
        final String authHeader = httpServletRequest.getHeader("authorization");

        if("OPTIONS".equals(httpServletRequest.getMethod())){
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(request,response);
        }else{
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                throw new ServletException("Missing or invalid Authorization Header");
            }

            final String token = authHeader.substring(7);

            try{
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
                httpServletRequest.setAttribute("claims" , claims);
            }catch(final Exception se){
                throw new ServletException("Invalid Token");
            }

            chain.doFilter(request,response);

        }
    }
}
