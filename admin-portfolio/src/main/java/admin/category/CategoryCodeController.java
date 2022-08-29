package admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;


public class CategoryCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CategoryCodeController() {
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String depth1Code = request.getParameter("depthCode");
		try {
			CategoryDAO categorydao = new CategoryDAO();
			List<Category2DepthCodeDTO> depth2List = categorydao.selectDepth2Code(depth1Code);
			
			JSONObject jobj = new JSONObject();
			jobj.put("list", depth2List);
			response.getWriter().print(jobj);
		
		}
		catch (Exception e) {
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
