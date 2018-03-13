package by.it.karpeichyk.Project.java.my_filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by user on 03.03.2018.
 */
public class EncondingUTF8 implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encoding != null) {
            if (!encoding.equalsIgnoreCase(servletRequest.getCharacterEncoding())) {
                servletRequest.setCharacterEncoding(encoding);
            }
            if (!encoding.equalsIgnoreCase(servletRequest.getCharacterEncoding())) {
                servletRequest.setCharacterEncoding(encoding);

            }}
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
       public void destroy(){
            encoding = null;}



}