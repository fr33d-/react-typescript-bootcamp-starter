package com.reply.comsysto.rustylobster.backend.models.entities;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public final class UserAccount extends BaseEntity {
  private String password;
  private String username;
}
