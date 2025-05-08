package com.josmejia2401.nuevospa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tareas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nombre", nullable = false)
    private String nombre;

    @Column(name ="descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoTarea estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private LocalDateTime fechaCreacion = LocalDateTime.now();
}

