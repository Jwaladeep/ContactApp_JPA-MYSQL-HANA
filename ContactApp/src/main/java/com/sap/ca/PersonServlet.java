package com.sap.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Gson gson = new Gson();

		/*
		 * List<PersonalDetails> details = cp.getPersonalDetails();
		 * response.setContentType("application/json"); PrintWriter out =
		 * response.getWriter(); out.println(details);
		 * out.println(gson.toJson(details));
		 */

		/* console.log(details); */

		/*
		 * for (int i = 0; i < details.size(); i++) {
		 * System.out.println(details.get(i).getName()+ "   "+
		 * details.get(i).getPhoneNo()); }
		 */
		PersonalDetailsPersistence cp = new PersonalDetailsPersistence();
		List<PersonalDetails> details = cp.getPersonalDetails();
		PrintWriter out = response.getWriter();

		for (int i = 0; i < details.size(); i++) {
			out.println(details.get(i).getName() + " " + details.get(i).getPhoneNo());
		}

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonalDetails pd = new PersonalDetails();
		PrintWriter out = response.getWriter();
		request.getContentType();
		String name = request.getParameter("Name");

		String phone = request.getParameter("PhoneNo");

		pd.setName(name);
		pd.setPhoneNo(phone);
		PostDetailsPersistence cp = new PostDetailsPersistence();
		out.println(cp.putDetail(pd));

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonalDetails pd = new PersonalDetails();
		PrintWriter out = response.getWriter();
		request.getContentType();
		String oldPhone = request.getParameter("OldPhone");
		String name = request.getParameter("Name");
		String newPhone = request.getParameter("NewPhone");
		if(oldPhone==null) {
			oldPhone = request.getHeader("OldPhone");
			name = request.getHeader("Name");
			newPhone = request.getHeader("newPhone");
		}
		deleteDetailsPersistence dp = new deleteDetailsPersistence();
		dp.deleteContact(oldPhone);
		pd.setName(name);
		pd.setPhoneNo(newPhone);
		PostDetailsPersistence cp = new PostDetailsPersistence();
		cp.putDetail(pd);
	
		out.println("Contact Updated");

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// request.getContentType();
		String phone = request.getParameter("PhoneNo");
		if(phone==null) {
			phone=request.getHeader("PhoneNo");
		}
		deleteDetailsPersistence dp = new deleteDetailsPersistence();

		out.print(dp.deleteContact(phone));

	}

}
