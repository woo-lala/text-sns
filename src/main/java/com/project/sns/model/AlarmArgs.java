package com.project.sns.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlarmArgs {
    private Integer fromUserId; //알람 발생시킨 사람
    private Integer targetId; //    알람 발생 주체

}
