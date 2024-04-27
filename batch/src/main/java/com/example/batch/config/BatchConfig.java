package com.example.batch.config;

import com.example.batch.model.Person;
import com.example.batch.tasklet.HelloWorldTasklet;
import com.example.batch.tasklet.PersonTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	public final HelloWorldTasklet helloWorldTasklet;

	@Autowired
	public BatchConfig(HelloWorldTasklet helloWorldTasklet) {
		this.helloWorldTasklet = helloWorldTasklet;
	}

	@Bean
	public FlatFileItemReader<Person> reader() {
		return new FlatFileItemReaderBuilder<Person>()
			.name("personItemReader")
			.resource(new ClassPathResource("sample-data.csv"))
			.delimited()
			.names("firstName", "lastName")
			.targetType(Person.class)
			.build();
	}

	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Person>()
			.sql(
				"INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)"
			)
			.dataSource(dataSource)
			.beanMapped()
			.build();
	}

	@Bean
	public Step step1(
		JobRepository jobRepository,
		PlatformTransactionManager platformTransactionManager
	) {
		return new StepBuilder("step1", jobRepository)
			.tasklet(helloWorldTasklet, platformTransactionManager)
			.build();
	}

	@Bean
	public Step step2(
		JobRepository jobRepository,
		PlatformTransactionManager platformTransactionManager,
		PersonTasklet personTasklet
	) {
		return new StepBuilder("personTasklet", jobRepository)
			.tasklet(personTasklet, platformTransactionManager)
			.build();
	}

	@Bean
	public Job helloWorldJob(JobRepository jobRepository, Step step2) {
		String string = "hello";
		System.out.println(string);
		return new JobBuilder("helloWorldJob", jobRepository)
			.start(step2)
			.build();
	}

}
