    package com.example.demo.repository;

    import com.example.demo.entity.User;
    import org.springframework.data.repository.CrudRepository;

    public interface UserRepository extends CrudRepository<User, Long> {
        User findByUsername(String username);
    }

