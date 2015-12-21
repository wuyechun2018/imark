//清除SSL缓存
try{
  var agt=navigator.userAgent.toLowerCase();
  if (agt.indexOf("msie") != -1) {
    // IE clear HTTP Authentication
    document.execCommand("ClearAuthenticationCache");
  }
  else {
    // Let's create an xmlhttp object
    var xmlhttp = createXMLObject();
    // Let's get the force page to logout for mozilla
    xmlhttp.open("GET",".force_logout_offer_login_mozilla",true,"logout","logout");
    // Let's send the request to the server
    xmlhttp.send("");
    // Let's abort the request
    xmlhttp.abort();
  }
  // Let's redirect the user to the main webpage
  //window.location = "/rest/";
} catch(e) {
// There was an error
alert("there was an error");
}

function createXMLObject() {
    try {
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        }
        // code for IE
        else if (window.ActiveXObject) {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
    } catch (e) {
        xmlhttp=false
    }
    return xmlhttp;
}