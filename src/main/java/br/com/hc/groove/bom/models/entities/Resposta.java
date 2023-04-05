package br.com.hc.groove.bom.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "gb_respostas")
@AllArgsConstructor@NoArgsConstructor
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name = "resposta", nullable = true, columnDefinition = "TEXT")
    private String resposta;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_resposta")
    private Usuario usuarioResposta;

    @Column(name = "data", nullable = true)
    private LocalDateTime data;

    @PrePersist
    public void abertura() {
        this.data = LocalDateTime.now();
    }
}