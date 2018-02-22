package com.example.FirstAppDemo.repository;

import com.example.FirstAppDemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {
    private final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return  如果成功返回<code>true</code>，失败返回<code>false</code>
     */
    public boolean save(User user){
        boolean success = false;

        //id 从1开始
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }


    public Collection<User> findAll(){
        return (Collection<User>) repository;
    }

}
