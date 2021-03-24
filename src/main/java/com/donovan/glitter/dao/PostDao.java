package com.donovan.glitter.dao;

import com.donovan.glitter.domain.Post;
import com.donovan.glitter.generated.tables.records.PostRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.donovan.glitter.generated.Tables.*;


import java.util.List;

import static com.donovan.glitter.generated.Tables.*;

@Repository
public class PostDao {

    @Autowired
    DSLContext dsl;

    public List<Post> getPosts(){
        return dsl.selectFrom(POST).fetch().into(Post.class);
    }

    public Post createPost(Post p){
        int id = dsl.insertInto(POST, POST.BODY).values(p.body).returningResult(POST.ID).fetchOne().getValue(POST.ID);
        p.id = id;
        return p;

    }

}
