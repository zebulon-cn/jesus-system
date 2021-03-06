package com.code.proter.user.modules.resource.service;

import com.code.proter.user.domain.resource.Resource;
import com.code.proter.user.modules.resource.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ResourceService implements IResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public ResourceRepository getRepository() {
        return resourceRepository;
    }

    @Override
    public List<String> getResourceAll(String resourceIds) {

        //分割所有权限  获取id
        String[] rIds = resourceIds.split(",");
        List<String> urlList = new ArrayList<>();
        //获取资源列表
        for (String val : rIds) {
            Long id = Long.parseLong(val);

            Optional<Resource> opt = resourceRepository.findById(id);
            if(opt.isPresent()){
                Resource resource = opt.get();
                urlList.add(resource.getUrl());
            }
        }
        return urlList;
    }
}
