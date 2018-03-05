package by.it.karpeichyk.Project;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by user on 03.03.2018.
 */
public class EncjndingUTF8 implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding= filterConfig.getInitParameter("encjding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       if (encoding!= null){
          // if (!servletRequest.getCharacterEncoding().equalsIgnoreCase(encoding);){

           }
       }
   // }

    @Override
    public void destroy() {

    }
}
