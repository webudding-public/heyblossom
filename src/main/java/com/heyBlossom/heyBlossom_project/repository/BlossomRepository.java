package com.heyBlossom.heyBlossom_project.repository;

import com.heyBlossom.heyBlossom_project.domain.Blossom;
import org.springframework.stereotype.Repository;

interface IBlossomRepository {
    void save(Blossom blossom);
}

@Repository
public class BlossomRepository implements IBlossomRepository {

    @Override
    public void save(Blossom blossom) {
        return;
    }
}
