package com.system.design.message;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.system.design.message.Cosntants.STREAM_KEY_SINGLE;


@Component
@AllArgsConstructor
public class CycleGeneratorStreamMessageRunner implements ApplicationRunner {

    private final StreamProducer streamProducer;

    @Override
    public void run(ApplicationArguments args) {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(() -> streamProducer.sendRecord(STREAM_KEY_SINGLE),
                        0, 10, TimeUnit.SECONDS);
    }
}
