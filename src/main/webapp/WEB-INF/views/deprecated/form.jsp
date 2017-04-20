

	<div class="container-fluid">
	<form action="processForm" method="GET">
		<input type="text" name="studentName"/>
		<input type="submit"/>
	
	</form>
	</div>








<br><br><br><br>

	<div class="container-fluid">

	    <p><font color="red"><b>${errorMessage}</b></font></p>

    	<form action="/login" method="POST">
        	<fieldset class="form-group">
	        	<label>Name :</label> 
    	    	<input name="name" type="text" />
        	</fieldset>
        
        	<fieldset class="form-group">
        		<label>Password :</label> 
        		<input name="password" type="password" />
        	</fieldset>
        
        	<input class="btn btn-success" type="submit" />
    	</form>
    </div>
    
<!--  ideja za gumbe, delete i update -->
<input class="btn btn-success" type="Submit" value="Delete"
							onclick="${deleteLink};return false;"/>
    