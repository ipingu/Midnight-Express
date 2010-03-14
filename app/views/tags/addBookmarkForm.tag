#{form @Sandbox.addBookmark()}
	<fieldset>
		<legend>Add a bookmark</legend>
		
		#{ifErrors}
		<span class="error">An error occured. Correct values and try again...</span><br /><br />
		#{/ifErrors}
		
		<label for="url">http url</label>	
		<input type="text" id="url" name="url" value="${flash.url}" />
		<span class="error">#{error 'url' /}</span>
		<br />
		
		<label for="title">title</label>
		<input type="text" id="title" name="title" value="${flash.title}" />
		<span class="error">#{error 'title' /}</span>
		<br />
		
		<input type="submit" value="Add" />
	</fieldset>	
#{/form}