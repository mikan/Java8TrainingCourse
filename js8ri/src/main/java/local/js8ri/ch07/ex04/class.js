/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

var source = 'Musashi Kosugi' // JS String
print("source: " + source.getClass()) // J getClass() returns java.lang.String
var slice = source.slice(-6) // JS method
print("slice:  " + slice.getClass()) // J getClass() returns java.lang.String
var cast = java.lang.String.class.cast(slice)
print(cast) // "Kosugi"
