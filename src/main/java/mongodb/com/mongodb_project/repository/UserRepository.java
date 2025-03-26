package mongodb.com.mongodb_project.repository;

import mongodb.com.mongodb_project.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);

    // ?0 is the parameter placeholder for age
    @Query("{'age': {$gte: ?0}}")
    User findByMinAge(Integer age);
}

