/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

// jjs's funny result:
//
// jjs> var b = new java.math.BigInteger('1234567890987654321')
// jjs> b
// 1234567890987654400
// jjs> b.mod(java.math.BigInteger.TEN)
// 1

// Correct program:
var BigInteger = java.math.BigInteger;
var JString = java.lang.String;

var b = new BigInteger('1234567890987654321');
print("[JS long]")
print(b.longValue()); // 1234567890987654400 (JS long)
print("[Java long]")
print(JString.valueOf(b.longValue())) // 1234567890987654321 (J long) [OK!]
print("[JS mod]")
print(b.mod(BigInteger.TEN).longValue());
print("[Java mod]")
print(JString.valueOf(b.mod(BigInteger.TEN).longValue()));
