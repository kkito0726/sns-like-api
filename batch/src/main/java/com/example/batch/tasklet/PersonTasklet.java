package com.example.batch.tasklet;

import com.example.batch.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class PersonTasklet implements Tasklet {

	private final Logger log = LoggerFactory.getLogger(PersonTasklet.class);
	final ItemStreamReader<Person> reader;
	final ItemWriter<Person> writer;

	public PersonTasklet(
		ItemStreamReader<Person> reader,
		ItemWriter<Person> writer
	) {
		this.reader = reader;
		this.writer = writer;
	}

	@Override
	public RepeatStatus execute(
		StepContribution contribution,
		ChunkContext chunkContext
	) throws Exception {
		Chunk<Person> personList = new Chunk<>();

		try {
			Person person;
			reader.open(
				chunkContext
					.getStepContext()
					.getStepExecution()
					.getExecutionContext()
			);

			while ((person = reader.read()) != null) {
				String firstName = person.firstName().toUpperCase();
				String lastName = person.lastName().toUpperCase();
				Person transformedPerson = new Person(firstName, lastName);
				System.out.println(transformedPerson);
				personList.add(person);
				log.info("Converting({}) into ({})", person, transformedPerson);
			}
			writer.write(personList);
		} finally {
			reader.close();
		}
		return RepeatStatus.FINISHED;
	}
}
