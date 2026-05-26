package com.tuempresa.Facturar.calculadores;

import javax.persistence.*;
import org.openxava.calculators.*;
import org.openxava.jpa.*;
import lombok.*;

public class CalcSigNumParaAño {
    implements ICalculator {
        @Getter     @Setter
        int año;

        public Object calculate() throws Exception {
            Query query = XPersistence.getManager().createQuery("select max(f.numero) from Factura f where f.año = :año");

            query.setParameter("año", año);
            Integer ultimoNumero = (Integer) query.getSingleResult();
            return ultimoNumero==null ? 1 : ultimoNumero + 1;

        }
    }

}
