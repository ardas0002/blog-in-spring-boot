package pl.ardas.bloginspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.ardas.bloginspringboot.exception.PageNotFound;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.PostRepository;

@Service
public class HomeService {

    @Autowired
    private PostRepository postRepository;

    public Page<Post> listAll(int pageNum) throws PageNotFound {
        int pageSize = 3;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("createDateTime").descending());
        Page<Post> page = postRepository.findAll(pageable);
        if(isEmptyPage(page))
            throw new PageNotFound(pageNum);
        return page;
    }

    protected boolean isEmptyPage(Page<Post> page){
        return page.isEmpty();
    }
}
