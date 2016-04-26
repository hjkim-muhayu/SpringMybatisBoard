function boardWriteCheck(formObj) {
	
	var form = formObj;
	var title = form.title.value;
	var contents = form.contents.value;
	
	if(title=='') {
		alert("input title");
		form.title.focus();
		return false;
	}
	
	if(contents=='') {
		alert("input contents");
		form.contents.focus();
		return false;
	}
	
	title = title.replace(">", "&gt;");
	title = title.replace("<", "&lt;");
	form.title.value = title;

	contents = contents.replace(">", "&gt;");
	contents = contents.replace("<", "&lt;");
	form.contents.value = contents;
	
	return true;
}