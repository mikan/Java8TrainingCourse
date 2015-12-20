/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/java8-training-course
 */

var ProcessBuilder = java.lang.ProcessBuilder;
var Thread = java.lang.Thread;
var Scanner = java.util.Scanner;

function connect(input, output) {
  new Thread(function() {
    var value;
    while ((value = input.read()) != -1) {
      output.write(value);
    }
    output.close();
  }).start();
}

function pipe() {
  if (arguments.length < 1) {
    return "";
  }
  var procs = [];
  for (i = 0; i < arguments.length; i++) {
    procs[i] = new ProcessBuilder(arguments[i].split(" ")).start();
    if (i > 0) {
      connect(procs[i - 1].getInputStream(), procs[i].getOutputStream());
    }
  }
  var scanner = new Scanner(procs.pop().getInputStream());
  var result = "";
  while (scanner.hasNextLine()) {
    result += scanner.nextLine() + "\n";
  }
  return result;
}

//print(pipe('find .', 'grep -v class', 'sort'));
print(pipe('find .', 'grep .js', 'sort'));
