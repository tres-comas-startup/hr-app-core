package com.trescomas.domain.projection;

import java.time.LocalDateTime;

/**
 * A base projection that is based on the BaseEntity domain class
 */
public interface BaseProjection {

    Long getVersion();

    LocalDateTime getCreatedDate();

    String getCreatedBy();

    LocalDateTime getLastModifiedDate();

    String getLastModifiedBy();

}
