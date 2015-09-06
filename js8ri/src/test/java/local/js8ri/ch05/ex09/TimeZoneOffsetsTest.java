/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch05.ex09;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author mikan
 */
public class TimeZoneOffsetsTest {

    @Test
    public void testGetTimeZoneOffsets() {
        TimeZoneOffsets.getTimeZones(LocalDateTime.now().toInstant(ZoneOffset.UTC), 1).forEach(System.out::println);
    }

    /**
     Z (GMT)
     Z (Etc/GMT-0)
     Z (Atlantic/St_Helena)
     Z (Etc/GMT+0)
     Z (Africa/Banjul)
     Z (Etc/GMT)
     Z (Africa/Freetown)
     Z (Africa/Bamako)
     Z (Africa/Conakry)
     Z (Universal)
     Z (Africa/Sao_Tome)
     Z (Africa/Nouakchott)
     Z (UTC)
     Z (Etc/Universal)
     Z (Atlantic/Azores)
     Z (Africa/Abidjan)
     Z (Africa/Accra)
     Z (Etc/UCT)
     Z (GMT0)
     Z (Zulu)
     Z (Africa/Ouagadougou)
     Z (Atlantic/Reykjavik)
     Z (Etc/Zulu)
     Z (Iceland)
     Z (Africa/Lome)
     Z (Greenwich)
     Z (Etc/GMT0)
     Z (America/Danmarkshavn)
     Z (Africa/Dakar)
     Z (America/Scoresbysund)
     Z (Africa/Bissau)
     Z (Etc/Greenwich)
     Z (Africa/Timbuktu)
     Z (UCT)
     Z (Africa/Monrovia)
     Z (Etc/UTC)
     */
}
