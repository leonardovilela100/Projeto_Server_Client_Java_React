package br.com.erudio.services;


import br.com.erudio.controllers.PersonController;
import br.com.erudio.controllers.UserController;
import br.com.erudio.data.vo.v1.UserVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.User;
import br.com.erudio.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class UserServices implements UserDetailsService {
    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name "+ username +"!");
        var user = repository.findByUsername(username);
        if ( user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException(" Username  " + username + " not found!");
        }
    }

    public UserVO findById(Long id) {

        logger.info("Finding one User!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, UserVO.class);
        vo.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        return vo;
    }

    public UserVO create(UserVO user) {

        if (user == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one book!");
        var entity = DozerMapper.parseObject(user, User.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), UserVO.class);
        vo.add(linkTo(methodOn(UserController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public UserVO update(UserVO user) {

        if (user == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one user!");

        var entity = repository.findById(user.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setUserName(user.getUserName());
        entity.setFullName(user.getFullName());
        entity.setPassword(user.getPassword());


        var vo =  DozerMapper.parseObject(repository.save(entity), UserVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }


}
