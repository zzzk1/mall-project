package com.system.design.message;

import com.system.design.common.util.ThreadLocalUtil;
import com.system.design.entity.ManagerSystemNotice;
import com.system.design.entity.User;
import com.system.design.entity.dto.Book;
import com.system.design.entity.vo.ManagerSystemNoticeVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.system.design.message.Cosntants.USER_MESSAGE_KEY;

@Component
@RequiredArgsConstructor
@Slf4j
public class StreamProducer {
    private final RedisTemplate<String, Object> redisTemplate;

    public void sendRecord(String streamKey) {
        User user = (User) ThreadLocalUtil.get("userInfo");
        Book book = Book.create();
        log.info("从缓存中获取发送给单个用户的通知:[{}]", book);

        ObjectRecord<String, Book> record = StreamRecords.newRecord()
                .in(streamKey)
                .ofObject(book)
                .withId(RecordId.autoGenerate());

        RecordId recordId = redisTemplate.opsForStream()
                .add(record);

        log.info("返回的record-id:[{}]", recordId);
    }
}
