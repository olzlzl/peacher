package kr.modustudy.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadHandler
 */
@WebServlet("/file_upload.html")
public class FileUploadHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "e:\\uploads";
	private String fullName = "";
	private String resultMessage;
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        fullName = UPLOAD_DIRECTORY + File.separator + name;
                        item.write( new File(fullName));
                    }
                }
           
               //File uploaded successfully
               resultMessage =  fullName;
            } catch (Exception ex) {
            	ex.printStackTrace();
            	resultMessage = "File Upload Failed due to " + ex;
            }          
         
        }else{
            resultMessage = "Sorry this Servlet only handles file upload request";
        }
        response.getWriter().print(resultMessage);
    }
}