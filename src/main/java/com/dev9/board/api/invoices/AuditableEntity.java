package com.dev9.board.api.invoices;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 등록자, 수정자, 등록일, 수정일,
 * </pre>
 */
//@Data
@MappedSuperclass
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity {
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime updatedTime;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createTime;

    @JsonIgnore
    @Transient
    Integer page;

    @JsonIgnore
    @Transient
    Integer size;

    @JsonIgnore
    @Transient
    String sort;

    @JsonIgnore
    @Transient
    String keyword;

//    private Example exam;
//
//    private Sort pageable;
}
