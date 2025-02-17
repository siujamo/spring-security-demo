package io.github.siujamo.playground.boot.repository;

import com.mybatisflex.core.BaseMapper;
import io.github.siujamo.playground.boot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseMapper<User> {

    @Select("""
            select *
            from "user"
            where username = #{username}
            """)
    User getUserByUsername(@Param("username") String username);

}
