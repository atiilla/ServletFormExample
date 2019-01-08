package ServletForm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final String UPLOAD_DIR = "/home/intec/Desktop/UploadFolder/";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Part part = req.getPart("uploadfile");
		part.write("uploadfile");
		// gets absolute path of the web application
		String applicationPath = req.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
		String name = req.getParameter("uploadfile");
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		try (PrintWriter out = res.getWriter()) {
			out.println("<html><head><title>Upload Service</title></head><body>");
			out.println("File uploaded <br/>" + name + " " + applicationPath);
			out.println("</body></html>");
		}
	}

}
