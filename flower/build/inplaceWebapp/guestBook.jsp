<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>Guest Book</title>
  <link rel="stylesheet" href="css/styles.css" />
  <script type="text/javascript">
    const showComments = function(comments) {
      let table = document.getElementById('commentsTable');
      let insertedRow;
      comments.forEach(function(element) {
        insertedRow = table.insertRow();
        insertedRow.insertCell().innerText = element.date;
        insertedRow.insertCell().innerText = element.name;
        insertedRow.insertCell().innerText = element.comment;
      });
    }

    const getComments = function() {
      let req = new XMLHttpRequest();
      req.onreadystatechange = function() {
        let commentsStore = JSON.parse(this.responseText).reverse();
        showComments(commentsStore);
      };
      req.open("GET", "/loadComments");
      req.send();
    };

    const parsekeyVal = function(text) {
      return text.split(";").reduce((parsedKeyVals, ele) => {
        let keyValPairs = ele.trim().split('=');
        parsedKeyVals[keyValPairs[0]] = keyValPairs[1];
        return parsedKeyVals;
      }, {});
    };

    const hideCommentsSection = function() {
      let commentSection = document.getElementById("guestBookForm");
      commentSection.innerText = "";
      commentSection.style.visibility = "hidden";
    };

    const showCookiesIfUser = function() {
      let cookies = parsekeyVal(document.cookie);
      if (! +cookies.sessionId && !+cookies.logInStatus)
       hideCommentsSection();
    }

    const actionOnPageLoad = function(){
      // getComments();
      // showCookiesIfUser();
    }
  </script>
</head>

<body onload="actionOnPageLoad()">
  <div>
    <h1 id="flowerHeading"><a href="index.jsp"> << </a> Guest Book</h1>
  </div>
  <form id="guestBookForm" action="comment/commentAccepted" method="post">
    <h2 style="font-family:san-sarif">Leave A comment</h2>
    Your Name<input type="text" name="name" required/> <br /><br /> Comment
    <textarea name="comment" style="height:40px" required></textarea><br />
    <button>submit</button>
  </form>
  <table id="commentsTable">
  </table>
</body>

</html>
