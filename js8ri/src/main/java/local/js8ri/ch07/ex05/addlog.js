/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

function createMyArrayList() {
  return new (Java.extend(java.util.ArrayList)) {
    add: function(x) {
      print('Adding ' + x);
      return Java.super(arr).add(x);
    }
  }
}
var arr = createMyArrayList();
arr.add("foo")
arr.add("bar")
arr.add("baz")
print(arr)
