function validateReg()
{
	var aadh=document.reg1.aadharid.value;
	alert(aadh);
	if(isNaN(aadh))
	{
		
		alert("please enter aadharid in numerical");
		document.getElementById("aadhar").focus();
		event.returnValue = false;
		return false;
	}
	else
	{
		event.returnValue = true;
		return true;
	}
}