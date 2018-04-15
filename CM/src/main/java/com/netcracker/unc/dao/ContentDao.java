package com.netcracker.unc.dao;

import com.netcracker.unc.model.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentDao extends GenericDao<Content, Integer> {

    public ContentDao() {
        super(Content.class);
    }

    public List<Content> getAllByPostId(Integer postId) {
        return getManager().createQuery("select c from Content c where c.postId=:postId")
                .setParameter("postId", postId)
                .getResultList();
    }

}
