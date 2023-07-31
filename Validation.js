/**
 * 
 */
 
 
 function checkEmptyField(fieldId) {
 
 	alert('checkEmptyField '+fieldId);
 	
 }
 function checkEmail(emailId) {
if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(emailId)){

return true;
}    
return false;
}

function checkAge(year,month,date){
	var today = new Date();
    var age = today.getFullYear() - year;
    if (today.getMonth() < month || (today.getMonth() == month && today.getDate() < date))
     {
         age--;
     }  
                
	if(age>17){
		
		return true;
	}
	return false;
}

function checkpassword(password)
 {
    let strength=0;
    if (password.match(/[a-z]+/)){
        strength+=1;
    }
    if (password.match(/[A-Z]+/)){
        strength+=1;
    }
    if (password.match(/[0-9]+/)){
        strength+=1;
    }
    if (password.match(/[$@#&!]+/)){
        strength+=1;

        }
    if (password.length>6){
    strength+=1;

    }

  if(strength =>5){
	  return true;
  }
  
  return false;
    
}
 function validatereg() {
				var x=document.getElementById('uname').value;
				var y=document.getElementById('upass').value;
				var z=document.getElementById('uemail').value;
				var s = document.getElementById('udob').value.split("-");
				console.log('value of x '+x);
				console.log('value of y '+y);
                if(z == ""){
					document.getElementById("emailErr").innerHTML="Email cannot be blank";
					return false;
				}
				if(!checkEmail(z)){
					document.getElementById("emailErr").innerHTML="Enter valid Email";
					return false;
				}
				if(s ==""){
					
					document.getElementById("dobErr").innerHTML="Date of birth cannot be blank";
					return false;
				}
				
				if(!checkAge(Number(s[0]),Number(s[1]),Number(s[2]))){
					document.getElementById("dobErr").innerHTML="should be 18+";
					return false;
				}
				if(x =="") {
					
					
					alert(Number(s[0]));	
					document.getElementById("nameErr").innerHTML="Username cannot be blank";
					return false;
				}		
				
				if(y =="") {
					//alert('Password cannot be blank');	return false
					document.getElementById("passErr").innerHTML="Password cannot be blank";
					return false;
				}	
				if(!checkpassword(y)){
					document.getElementById("passErr").innerHTML="Password should";
					return false;
				}		
				return true;
			}	
 
function validate() {
				var x=document.getElementById('uname').value;
				var y=document.getElementById('upass').value;
				
				console.log('value of x '+x);
				console.log('value of y '+y);

				if(x =="") {
					//alert('Username cannot be blank');	
					document.getElementById("nameErr").innerHTML="Username cannot be blank";
					return false;
				}		
				
				if(y =="") {
					//alert('Password cannot be blank');	return false
					document.getElementById("passErr").innerHTML="Password cannot be blank";
					return false;
				}			
				return true;
			}	
 function clearTheForm() {
				document.getElementById('uname').value="";
				document.getElementById('upass').value="";
				
}

function clearNameErrMsg() {
				document.getElementById('nameErr').innerHTML="";

}
			
function clearPassErrMsg() {
				document.getElementById('passErr').innerHTML="";

}
function clearEmailErrMsg() {
				document.getElementById('emailErr').innerHTML="";

}
function clearDobErrMsg(){
	document.getElementById('dobErr').innerHTML="";
}