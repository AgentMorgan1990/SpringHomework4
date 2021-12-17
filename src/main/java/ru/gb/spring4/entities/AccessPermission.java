package ru.gb.spring4.entities;

import javax.persistence.*;

import lombok.Data;


@Entity
@Data
@Table(name = "access_permission")
public class AccessPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
