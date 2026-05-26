package com.tuempresa.Facturar.modelo;

import java.time.*;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.*;

import com.tuempresa.Facturar.calculadores.CalcSigNumParaAnio;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

@Entity
@Getter @Setter
@View(members = "anyo, numero, fecha;" +
            "Cliente;" +
            "detalles" +
            "observaciones"
        )

public class Factura {
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length = 32)
    String oid;

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int año;

    @Column(length = 6)
            @DefaultValueCalculator(value = CalcSigNumParaAnio.class, properties = @PropertyValue(name = "anyo"))
    int numero;

    @Required
    @DefaultValueCalculator(CurrentMonthCalculator.class)
    LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("Simple")
    Cliente cliente;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion.cantidad")
    Collection<Detalle> detalles;

    @Stereotype("MEMO")
    String observaciones;

}
