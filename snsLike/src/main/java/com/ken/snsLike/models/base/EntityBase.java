package com.ken.snsLike.models.base;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class EntityBase {

	@Column(name = "created_at", updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@PrePersist
	protected void prePersist() {
		if (Objects.isNull(this.createdAt)) {
			this.createdAt = LocalDateTime.now();
		}
		if (Objects.isNull(updatedAt)) {
			this.updatedAt = LocalDateTime.now();
		}
	}

	@PreUpdate
	protected void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
