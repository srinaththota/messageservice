package assignment.messageservice.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;

import assignment.messageservice.model.Message;

public interface MessageRepository extends CassandraRepository<Message , Integer> {

}
