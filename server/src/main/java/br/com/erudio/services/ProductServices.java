package br.com.erudio.services;

import br.com.erudio.controllers.BookController;
import br.com.erudio.data.vo.v1.ProductVO;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductServices {

    private Logger logger = Logger.getLogger(ProductServices.class.getName());

    @Autowired
    ProductRepository repository;

    @Autowired
    PagedResourcesAssembler<ProductVO> assembler;

    public PagedModel<EntityModel<ProductVO>> findAll(Pageable pageable) {

        logger.info("Finding all books!");

        var productsPage = repository.findAll(pageable);

        var productsVOs = productsPage.map(p -> DozerMapper.parseObject(p, ProductVO.class));
        productsVOs.map(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));

        Link findAllLink = linkTo(
                methodOn(BookController.class)
                        .findAll(pageable.getPageNumber(),
                                pageable.getPageSize(),
                                "asc")).withSelfRel();

        return assembler.toModel(productsVOs, findAllLink);
    }


}
