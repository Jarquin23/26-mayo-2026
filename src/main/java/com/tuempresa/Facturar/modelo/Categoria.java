package com.tuempresa.Facturar.modelo;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter

public class Categoria {
    @Id
    @Hidden
    @GeneratedValue(generator =  "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    String oid;

    @Column(length = 50)
    String descripcion;
}
