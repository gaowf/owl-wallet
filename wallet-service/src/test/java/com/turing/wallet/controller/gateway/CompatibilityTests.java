package com.turing.wallet.controller.gateway;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import javax.cache.Cache;
import javax.cache.processor.EntryProcessor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 */
@SpringBootTest
public class CompatibilityTests {
    @Autowired
    private Cache<String, Integer> cache;

    public CompatibilityTests() {
    }

    @Test
    public void test() throws InterruptedException {
        String key = "42";
        int threads = 4;
        int iterations = 1000;
        cache.put(key, 0);
        CountDownLatch latch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(
                    () -> {
                        try {
                            for (int j = 0; j < iterations; j++) {
                                EntryProcessor<String, Integer, Void> processor =
                                        (EntryProcessor<String, Integer, Void> & Serializable)
                                                (mutableEntry, objects) -> {
                                                    int value = mutableEntry.getValue();
                                                    mutableEntry.setValue(value + 1);
                                                    return null;
                                                };
                                cache.invoke(key, processor);
                            }
                        } finally {
                            latch.countDown();
                        }
                    })
                    .start();
        }
        latch.await();
        int value = cache.get(key);
        if (value == threads * iterations) {
            System.out.println("Implementation which you use is compatible with Bucket4j");
        } else {
            String msg = "Implementation which you use is not compatible with Bucket4j";
            msg += ", " + (threads * iterations - value) + " writes are missed";
            throw new IllegalStateException(msg);
        }
    }
}
