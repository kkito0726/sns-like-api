package com.example.batch.config;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.batch.tasklet.HelloWorldTasklet;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {
    @Autowired
    public final HelloWorldTasklet helloWorldTasklet;

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("step1", jobRepository)
                .tasklet(helloWorldTasklet, platformTransactionManager)
                .build();
    }

    @Bean
    public Job helloWorldJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("helloWorldJob", jobRepository)
                .start(step1)
                .build();
    }
}
