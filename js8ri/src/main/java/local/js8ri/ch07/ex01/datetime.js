/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

// jjs command in Mac OS X memo:
// alias jjs='$(/usr/libexec/java_home -v 1.8)/jre/bin/jjs'

var ZonedDateTime = Java.type('java.time.ZonedDateTime');
var current = ZonedDateTime.now();
print(current); // 2015-08-30T21:27:19.549+09:00[Asia/Tokyo]
current = current.plusDays(1);
print(current); // 2015-08-31T21:27:19.549+09:00[Asia/Tokyo]
