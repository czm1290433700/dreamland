package wang.dreamland.www.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import tk.mybatis.mapper.entity.Example;
import wang.dreamland.www.common.PageHelper;
import wang.dreamland.www.dao.UserContentMapper;
import wang.dreamland.www.entity.UserContent;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class IndexJspFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("===========自定义过滤器==========");
        ServletContext context = request.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        UserContentMapper userContentMapper = ctx.getBean(UserContentMapper.class);
        PageHelper.startPage(null, null);//开始分页
        Example e = new Example(UserContent.class);
        e.setOrderByClause("rpt_time DESC");
        List<UserContent> list = userContentMapper.selectByExample(e);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        request.setAttribute("page", endPage );
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}