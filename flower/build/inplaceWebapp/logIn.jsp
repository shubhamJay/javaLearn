<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>logIn Page</title>
  <link rel="stylesheet" href="css/styles.css">
  <script type="text/javascript">
    const parsekeyVal = function(text) {
      return text.split(";").reduce((parsedKeyVals, ele) => {
        let keyValPairs = ele.trim().split('=');
        parsedKeyVals[keyValPairs[0]] = keyValPairs[1];
        return parsedKeyVals;
      }, {});
    };

    const hideLogInDialog = function() {
      let logInBox = document.getElementById("logInBox");
      logInBox.style.visibility = "hidden";
    };
    const actionOnLogIn = function() {
      let cookies = parsekeyVal(document.cookie);
      if (+cookies.logInStatus && +cookies.sessionId ) {
        showLogOutDiaolg();
      };
    }
  </script>
</head>

<body>
  <h1 id="subHeading">Log In</h1>
  <form action="logIn" method="POST" id="logInBox" class="dialogBox">
    User Id : <input type="text" name="userId"><br><br> Password : <input type="password" name="password"><br><br>
    <button>LogIn</button>
  </form>

</body>

</html>
