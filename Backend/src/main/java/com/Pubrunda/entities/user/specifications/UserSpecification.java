package com.Pubrunda.entities.user.specifications;

import com.Pubrunda.EntitySpecification;
import com.Pubrunda.entities.user.dto.UserQueryParams;
import com.Pubrunda.entities.user.User;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class UserSpecification extends EntitySpecification<User> {

    private final UserQueryParams userParams;


    @Override
    protected Collection<Specification<User>> getSpecifications() {
        return Stream.of(byUsername(userParams.getUsername())).toList();
    }

    public Specification<User> byUsername(String username) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if (Strings.isNotBlank(username)) {
                predicate = builder.and(predicate, builder.equal(root.get("username"), username));
            }

            return predicate;
        };
    }

}
