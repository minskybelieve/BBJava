package com.helixleisure.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtils {


    public static Timestamp getCurrentUTC() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC"));
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        return timestamp;
    }
}
