package com.project.sns.model;

import com.project.sns.model.entity.AlarmEntity;
import com.project.sns.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Slf4j
@AllArgsConstructor
@Getter
public class Alarm {
    private Integer id;
//    private User user;
    private AlarmType alarmType;
    private AlarmArgs args;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static Alarm fromEntity(AlarmEntity entity) {
        log.info("===Call from Entity");
        return new Alarm(
                entity.getId(),
//                User.fromEntity(entity.getUser()),
                entity.getAlarmType(),
                entity.getArgs(),
                entity.getRegisteredAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt()

        );
    }
}
