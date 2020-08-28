package com.qin_kai.mongo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author qin kai
 * @Date 2020/8/28
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public int update(User user) {
        Query query = new Query(Criteria.where("userId").is(user.getUserId()));
        Update update = buildUserUpdate(user);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        if (updateResult == null) {
            return 0;
        }
        return (int) updateResult.getModifiedCount();
    }

    @Override
    public User findUserById(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public int remove(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        DeleteResult remove = mongoTemplate.remove(query, User.class);
        return (int) remove.getDeletedCount();
    }

    @Override
    public List<User> findUserList(int pageNum, int pageSize) {
        int from = (pageNum - 1) * pageSize;
        Query query = new Query().skip(from).limit(pageSize);
        return mongoTemplate.find(query, User.class);
    }

    private Update buildUserUpdate(User user) {
        Update update = new Update();
        if (!StringUtils.isEmpty(user.getName())) {
            update.set("name", user.getName());
        }
        if (!StringUtils.isEmpty(user.getAge())) {
            update.set("age", user.getAge());
        }
        return update;
    }
}
