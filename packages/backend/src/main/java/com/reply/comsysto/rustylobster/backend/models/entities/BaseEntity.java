package com.reply.comsysto.rustylobster.backend.models.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
abstract class BaseEntity {
  @Id @GeneratedValue private Long id;
}
