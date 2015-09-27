/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

 function pipe() {
   var result;
   for (i = 0; i < arguments.length; i++) {
       result = $EXEC(arguments[i], result);
   }
   return result;
 }

//print(pipe('find .', 'grep -v class', 'sort'));
print(pipe('find .', 'grep .js', 'sort'));
