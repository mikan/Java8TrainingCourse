/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch01.ex09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author mikan
 */
public class ArrayList2Test {

    @Test
    public void testAll_equality() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList2<String> arrayList2 = new ArrayList2<>();
        arrayList.addAll(Arrays.asList("one", "two", "three"));
        arrayList2.addAll(Arrays.asList("one", "two", "three"));
        assertEquals(arrayList.size(), arrayList2.size());
        assertEquals(arrayList.isEmpty(), arrayList2.isEmpty());
        assertEquals(arrayList.contains("one"), arrayList2.contains("one"));
        assertEquals(arrayList.iterator().next(), arrayList2.iterator().next());
        assertArrayEquals(arrayList.toArray(), arrayList2.toArray()); // pre-modification check
        String[] sink1 = new String[3];
        String[] sink2 = new String[3];
        assertArrayEquals(arrayList.toArray(sink1), arrayList2.toArray(sink2));
        assertEquals(arrayList.add("four"), arrayList2.add("four"));
        assertArrayEquals(arrayList.toArray(), arrayList2.toArray()); // intermediate check after add()
        assertEquals(arrayList.remove("one"), arrayList2.remove("one"));
        assertArrayEquals(arrayList.toArray(), arrayList2.toArray()); // intermediate check after remove()
        assertEquals(arrayList.containsAll(Arrays.asList("two")), arrayList2.containsAll(Arrays.asList("two")));
        assertEquals(arrayList.addAll(Arrays.asList("six")), arrayList2.addAll(Arrays.asList("six")));
        assertArrayEquals(arrayList.toArray(), arrayList2.toArray()); // intermediate check after addAll()
        assertEquals((arrayList.removeAll(Arrays.asList("six"))), arrayList2.removeAll(Arrays.asList("six")));
        assertArrayEquals(arrayList.toArray(), arrayList2.toArray()); // intermediate check after removeAll()
        assertEquals((arrayList.retainAll(Arrays.asList("foo"))), arrayList2.retainAll(Arrays.asList("foo")));
        assertArrayEquals(arrayList.toArray(), arrayList2.toArray()); // intermediate check after retainAll()
        arrayList.clear();
        arrayList2.clear();
        assertArrayEquals(arrayList.toArray(), arrayList2.toArray()); // final check after clear()
    }
}
