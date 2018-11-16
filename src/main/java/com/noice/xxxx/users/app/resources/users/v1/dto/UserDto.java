package com.noice.xxxx.users.app.resources.users.v1.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class UserDto implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 8976385626708521557L;
	private String _id;
	  private String _name;
}
