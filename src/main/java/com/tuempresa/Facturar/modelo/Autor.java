package com.tuempresa.Facturar.modelo;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter @Setter

public class Autor {

    @Id @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;

    @Column(length=50)
    @Required
    String nombre;

    @OneToMany(mappedBy = "autor")
    @ListProperties("numero, descripcion, precio")
    Collection<Producto> productos;
}
