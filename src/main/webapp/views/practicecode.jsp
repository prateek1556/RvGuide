<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
	type="text/javascript"></script>
<script src="http://www.skulpt.org/js/skulpt.min.js"
	type="text/javascript"></script>
<script src="http://www.skulpt.org/js/skulpt-stdlib.js"
	type="text/javascript"></script>
<!-- <link href="css/skulpt.css" rel="stylesheet"> -->
<style>

</style>
</head>
<body>

	<script type="text/javascript">
		// output functions are configurable.  This one just appends some text
		// to a pre element.
		function outf(text) {
			var mypre = document.getElementById("output");
			mypre.innerHTML = mypre.innerHTML + text;
		}
		function builtinRead(x) {
			if (Sk.builtinFiles === undefined
					|| Sk.builtinFiles["files"][x] === undefined)
				throw "File not found: '" + x + "'";
			return Sk.builtinFiles["files"][x];
		}

		// Here's everything you need to run a python program in skulpt
		// grab the code from your textarea
		// get a reference to your pre element for output
		// configure the output function
		// call Sk.importMainWithBody()
		function runit() {
			var prog = document.getElementById("yourcode").value;
			var mypre = document.getElementById("output");
			mypre.innerHTML = '';
			Sk.pre = "output";
			Sk.configure({
				output : outf,
				read : builtinRead
			});
			(Sk.TurtleGraphics || (Sk.TurtleGraphics = {})).target = 'mycanvas';
			var myPromise = Sk.misceval.asyncToPromise(function() {
				return Sk.importMainWithBody("<stdin>", false, prog, true);
			});
			myPromise.then(function(mod) {
				console.log('success');
			}, function(err) {
				console.log(err.toString());
			});
		}
	</script>

	<h3>Try This</h3>
	<form>
		<div class="textarea-wrapper">
			<textarea id="yourcode" cols="40" rows="10">import turtle

t = turtle.Turtle()
t.forward(100)

print "Hello World" 
			</textarea>
		</div>
		<br />
		<button type="button" onclick="runit()">Run</button>
	</form>
	<pre id="output"></pre>
	<!-- If you want turtle graphics include a canvas -->
	<div id="mycanvas"></div>

</body>

</html>
