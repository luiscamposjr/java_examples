<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   <html>
   <body>
       <a href="newTask">Create New Task</a>
       <br /> <br />
	<table border="1"> 
		<tr>
           <th>Id</th>
           <th>Description</th>
           <th>Finalized?</th>
           <th>Finalized Date</th>
        </tr>
        
       <c:forEach items="${tasks}" var="task">
           <tr>
               <td>${task.id}</td>
               <td>${task.description}</td>
               <c:if test="${task.finalized eq false}">
                   <td>Not finalized</td>
               </c:if>
               <c:if test="${task.finalized eq true}">
                   <td>Finalized</td>
			   </c:if>
                 <td>k
                 <fmt:formatDate
                         value="${task.finalizedDate.time}"
                         pattern="dd/MM/yyyy"/>
                 </td>
                 <td>
                 	<a href="removeTask?id=${task.id}">Remover</a>
                 </td>
                 <td>
                 	<a href="showTask?id=${task.id}">Alterar</a>
                 </td>
            </tr>
       </c:forEach>
         </table>
     </body>
</html>