package com.tuempresa.Facturar.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.NoFrame;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@View(name = "Simple", members = "numero, nombre")

public class Cliente {

    @Id
    @Column(length = 6)
    int numero;

    @Column(length = 50)
    @Required
    String nombre;

    @Embedded   @NoFrame
    Direccion direccion;
}
