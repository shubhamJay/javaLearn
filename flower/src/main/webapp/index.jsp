<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>folwer Catalog</title>
  <link rel="stylesheet" href="css/styles.css">
  <script type="text/javascript">
    const hideVessel = function() {
      let vessel = document.getElementById("waterVessel");
      vessel.style.visibility = "hidden";
      setTimeout(() => vessel.style.visibility = "visible", 1000);
    };

    const parsekeyVal = function(text){
      return text.split(";").reduce((parsedKeyVals,ele)=>{
        let keyValPairs = ele.trim().split('=');
        parsedKeyVals[keyValPairs[0]] = keyValPairs[1];
        return parsedKeyVals;
      },{});
    };

    const showLogOutDiaolg = function(){
      let logOutBox = document.getElementById("logOutBox");
      logOutBox.style.visibility = "visible";
    };
    const hideLogInDialog = function(){
      let logInBox = document.getElementById("logInBox");
      logInBox.style.visibility = "hidden";
    };
    const actionOnLogIn = function(){
      let cookies = parsekeyVal(document.cookie);
      if(+cookies.logInStatus){
        showLogOutDiaolg();
        hideLogInDialog();
      };
    }
  </script>
</head>

<body onload="actionOnLogIn()">
  <h1 id="subHeading">Flower Catalog</h1>
  <img id="flowerImage" src="img/freshorigins.jpg">
  <form action="logIn" method="POST" id="logInBox" class="dialogBox">
    <h3>Log In</h3>
    User Id : <input type="text" name="userId"><br><br>
    Password : <input type="password" name="password"><br><br>
    <button >LogIn</button>
  </form>
  <form id="logOutBox" action="logOut" method="post" class="dialogBox">
    <button>logOut</button>
  </form>
  <div id="catalogOptions">
    <li>
      <a href="abeliophyllum.jsp">Abeliophyllum</a>
    </li>
    <li>
      <a href="agerantum.jsp">Agerantum</a>
    </li>
    <a href="guestBook.jsp">Guest Book</a>
    <img id="waterVessel" src="img/wateringVessel.gif" onclick="hideVessel()">
  </div>
</body>

</html>
