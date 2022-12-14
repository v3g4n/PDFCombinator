<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>PDFCombinator | About</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
</head>

<body>

<!--  Nav Bar  -->

	<nav class="navbar py-5 px-6" role="navigation" aria-label="main navigation">

			<div class="navbar-brand">
			<a class="navbar-item" href="/PDFCombinator/home"><i class="fa-sharp fa-solid fa-house"></i>  Home</a>
			<a class="navbar-item" href="/PDFCombinator/about"><i class="fa-solid fa-circle-info"></i>  About</a>
			
			<a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarMain">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		</div>
		<div id="navbarMain" class="navbar-menu">
			<div class="navbar-end">
			<% if (session.getAttribute("username") == null) {
				out.println(
						"<a class=\"navbar-item\" href=\"/PDFCombinator/register\"><i class=\"fa-solid fa-address-card\"></i>  Register</a> "
						+ "<a class=\"navbar-item\" href=\"/PDFCombinator/login\"><i class=\"fa-solid fa-right-to-bracket\"></i>  Log In</a>");
				
			} else {
				out.println(
						"<a class=\"navbar-item\" href=\"/PDFCombinator/upload\"><i class=\"fa-solid fa-upload\"></i>  Upload</a> " 
						+ "<a class=\"navbar-item\" href=\"/PDFCombinator/account\"><i class=\"fa-solid fa-address-card\">  Account</a>"
						+ "<a class=\"navbar-item\" href=\"/PDFCombinator/logout\"><i class=\"fa-solid fa-right-from-bracket\"></i>  Log Out</a>");

			}
			%>
	
	      	</div>

		</div>

	</nav>
	
<!--  Main part of website -->	

	<main class="container pb-6">
	
		<section class="content py-1">
	
			<h1 class="title is-1" >About PDFCombinator</h1>
		
		</section>
		
		<section class="content">
			<p><a href="https://github.com/v3g4n/PDFCombinator">PDFCombinator</a> is the result of a group project assignment as part of the Computer Programming diploma programme at Algonquin College.
			Our website allows you to upload PDFs, select the pages you want to use for each of the documents, and combine the documents to create a new PDF.</p>
	
		</section>
		
		<section class="content lorem">
			<h2 class="title">Filler text</h2>
			<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nibh nisl condimentum id venenatis a condimentum vitae sapien. Urna nec tincidunt praesent semper feugiat nibh sed. Elementum pulvinar etiam non quam. Quis vel eros donec ac. Libero nunc consequat interdum varius sit amet mattis vulputate. Convallis tellus id interdum velit laoreet. Odio morbi quis commodo odio aenean. Et netus et malesuada fames ac turpis. Quisque sagittis purus sit amet volutpat consequat mauris nunc congue. Cras ornare arcu dui vivamus arcu felis bibendum. Pulvinar neque laoreet suspendisse interdum consectetur. Volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Mauris a diam maecenas sed enim ut. Adipiscing at in tellus integer feugiat. Diam maecenas ultricies mi eget mauris pharetra. Felis imperdiet proin fermentum leo vel orci porta non pulvinar. At urna condimentum mattis pellentesque id nibh. Sit amet purus gravida quis blandit turpis cursus in hac. Mattis aliquam faucibus purus in massa tempor.
			</p>
			<p>
			Enim sed faucibus turpis in eu mi. Sed elementum tempus egestas sed sed. Aliquam eleifend mi in nulla posuere sollicitudin aliquam ultrices. Id diam maecenas ultricies mi eget mauris pharetra et. Enim lobortis scelerisque fermentum dui faucibus. Accumsan sit amet nulla facilisi. Molestie at elementum eu facilisis sed. Rhoncus urna neque viverra justo nec ultrices. Integer feugiat scelerisque varius morbi enim nunc faucibus a. Volutpat blandit aliquam etiam erat. Velit laoreet id donec ultrices tincidunt arcu non. Faucibus in ornare quam viverra orci sagittis eu. Suspendisse faucibus interdum posuere lorem ipsum dolor sit amet. Quis vel eros donec ac odio tempor orci. Quis lectus nulla at volutpat diam ut. Lorem donec massa sapien faucibus. Mauris cursus mattis molestie a. Viverra mauris in aliquam sem fringilla ut morbi tincidunt augue. Dignissim diam quis enim lobortis scelerisque fermentum dui. Morbi quis commodo odio aenean.
			</p>
			<p>
			Lacus vel facilisis volutpat est velit. Eget aliquet nibh praesent tristique magna. Nisl rhoncus mattis rhoncus urna. Pellentesque dignissim enim sit amet venenatis urna cursus. Venenatis lectus magna fringilla urna porttitor rhoncus. Amet cursus sit amet dictum sit. Duis ultricies lacus sed turpis tincidunt id. Pellentesque nec nam aliquam sem et tortor consequat. Sed adipiscing diam donec adipiscing tristique risus nec. Volutpat diam ut venenatis tellus in metus vulputate eu. Ornare lectus sit amet est placerat in egestas erat. Faucibus interdum posuere lorem ipsum. A cras semper auctor neque vitae tempus. Nisi quis eleifend quam adipiscing vitae proin sagittis nisl. Aliquam ut porttitor leo a diam sollicitudin. Euismod in pellentesque massa placerat duis ultricies.
			</p>
				
		</section>
	
	</main>

	<footer class="footer">
	  <div class="content has-text-centered">
	    <p>
	      <strong>PDFCombinator</strong> by <a class="link" href="https://github.com/v3g4n/">Miet Vanderheyden</a>, <a class="link" href="https://github.com/emchyeah">Meigan Cheah</a>, 
	      and <a class="link" href="https://github.com/Serapik">Serap Keskinler</a>. 2022
	    </p>
	  </div>
	</footer>

</body>

<script>

document.addEventListener('DOMContentLoaded', () => {

	  // Get all "navbar-burger" elements
	  const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

	  // Add a click event on each of them
	  $navbarBurgers.forEach( el => {
	    el.addEventListener('click', () => {

	      // Get the target from the "data-target" attribute
	      const target = el.dataset.target;
	      const $target = document.getElementById(target);

	      // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
	      el.classList.toggle('is-active');
	      $target.classList.toggle('is-active');

	    });
	  });

	});
</script>


