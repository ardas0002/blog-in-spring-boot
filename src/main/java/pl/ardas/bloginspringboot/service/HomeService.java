package pl.ardas.bloginspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.ardas.bloginspringboot.model.Post;
import pl.ardas.bloginspringboot.repository.PostRepository;

@Service
public class HomeService {

    @Autowired
    private PostRepository postRepository;

    public Page<Post> listAll(int pageNum){
        int pageSize = 3;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return postRepository.findAll(pageable);
    }
}
