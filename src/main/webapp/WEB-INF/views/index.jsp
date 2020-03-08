<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>KeepNote</title>
   </head>
   <body>
      <!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send
         button. Handle errors like empty fields -->
         <h1 align="center">Notes Recorder</h1>
      <form action="saveNote" method="post" style="align:center" name="noteRecorderForm">
         <table summary="Notes Recorder" border="1" align="center">
            <%
               String note_id = "";
               String note_title = "";
               String note_content = "";
               String note_status = "";

               if(request.getParameter("note_id")!=null){
                   note_id = (String) request.getParameter("noteId");
               }

               if(request.getParameter("note_title")!=null){
                   note_title = (String) request.getParameter("noteTitle");
               }

               if(request.getParameter("note_content")!=null){
                   note_content = (String) request.getParameter("noteContent");
               }

               if(request.getParameter("note_status")!=null){
                    note_status = (String) request.getParameter("noteStatus");
               }
                %>
            <tr>
               <td>Note ID:</td>
               <td><input type="text" title="enter your last name here" id ="noteId" name="noteId" size=100 required="required" pattern="[A-Za-z0-9]{1,20}" value=<%= note_id %> ></td>
            </tr>
            <tr>
               <td>Note Title: </td>
               <td><input type="text" name="noteTitle" required="required" pattern="[a-zA-Z0-9\s]+" size=100 maxlength=100 value=<%=note_title %> ></td>
            </tr>
            <tr>
               <td>Note Content: </td>
               <td><input type="text" name="noteContent" required="required" pattern="[a-zA-Z0-9\s]+" maxlength=100 size=100 value=<%=note_content %> > </td>
            </tr>
            <tr>
               <td>Note Status: </td>
               <td><input type="text" name="noteStatus" required="required" pattern="[a-zA-Z0-9\s]+" maxlength=100 size=100 value=<%=note_status %> > </td>
            </tr>
            <tr>
             <td></td><td align="center"><input type="submit" value="Submit" /></td>
            </tr>
         </table>

      </form>
      <!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <h1 align="center">Notes Recorder List</h1>
      <form action="deleteNote" method="GET" id="deleteform" style="align:center">
         <table border="2" width="70%" cellpadding="2" align="center">
            <tr>
               <th>Note_Id</th>
               <th>Note_Title</th>
               <th>Note_Content</th>
               <th>Note Status</th>
               <th>Created At</th>
               <th>Delete</th>
            </tr>
            <c:forEach var="note" items="${list}">
               <tr>
                  <td>${note.noteId}</td>
                  <td>${note.noteTitle}</td>
                  <td>${note.noteContent}</td>
                  <td>${note.noteStatus}</td>
                  <td>${note.createdAt}</td>
                  <td><a href="deleteNote?noteId=${note.noteId}">Delete</a>
               </tr>
            </c:forEach>
         </table>
      </form>
      <br/>
   </body>
</html>