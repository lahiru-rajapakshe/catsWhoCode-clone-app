package online.lahiru.sprinngbotrestapi.repository;

import online.lahiru.sprinngbotrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {


}
