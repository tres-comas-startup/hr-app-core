package com.trescomas.assembler;

import com.trescomas.domain.model.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User entity) {
        return EntityModel.of(entity,
                Link.of("/api/users/" + entity.getId(), IanaLinkRelations.SELF),
                Link.of("/api/users", "users"));
    }

}
