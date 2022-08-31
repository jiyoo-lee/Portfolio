package admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;


public class CategoryCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CategoryCodeController() {
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String depth1Code = request.getParameter("depthCode");
		
		try {
			CategoryDAO categorydao = new CategoryDAO();
			List<String> depth2List = categorydao.selectDepth2Code(depth1Code);
						
			JSONArray ja = new JSONArray();
			JSONObject jobj = new JSONObject();
			
			jobj.put("aList", depth2List);
			
			PrintWriter pw = response.getWriter();
			pw.print(jobj.toJSONString());
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
