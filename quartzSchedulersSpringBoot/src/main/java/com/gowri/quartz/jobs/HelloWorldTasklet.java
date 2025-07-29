package com.gowri.quartz.jobs;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.batch.core.step.tasklet.Tasklet;

/**
 * @author NaveenWodeyar
 * @date 29-Jul-2025
 * @time 7:57:24 pm
 */

@Component
public class HelloWorldTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        System.out.println("Hello World");
        return RepeatStatus.FINISHED;
    }
}
