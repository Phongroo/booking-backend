package com.example.ecommerce.repo;


import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    @Query(value = "SELECT * from users u, cart c where u.id = c.user_id and u.num > 0 and c.product_id =:productId  order by RANDOM() limit 1",nativeQuery = true)
    public User user(@Param("productId")Long productId);

}
