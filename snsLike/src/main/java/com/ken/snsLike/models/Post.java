package com.ken.snsLike.models;

import java.util.UUID;

import com.ken.snsLike.models.base.EntityBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "post")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Post extends EntityBase {
	@Id
	@Column(name = "post_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID postId;

	@Column(name = "user_id", nullable = false)
	private UUID userId;

	@Column(name = "title")
	private String title;

	@Column(name = "body")
	private String body;

}
